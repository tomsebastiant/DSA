package problems.design;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * LC: 716
 * Tags: Design
 * Tags: Stack
 * https://leetcode.com/problems/max-stack/
 * Design a max stack that supports push(x), pop(), top(), peekMax(), and popMax(). peekMax
 * returns the maximum without removal. popMax removes and returns the most recently pushed
 * copy of the maximum (i.e. the one closest to the top when duplicates exist).
 *
 * Constraints:
 * -10^7 <= x <= 10^7
 * At most 10^4 calls will be made to push, pop, top, peekMax, and popMax.
 * pop, top, peekMax, and popMax will always be called on a non-empty stack.
 *
 * Example 1:
 *
 * Input:  ["MaxStack","push","push","push","top","popMax","top","peekMax","pop","top"]
 *         [[], [5], [1], [5], [], [], [], [], [], []]
 * Output: [null, null, null, null, 5, 5, 1, 5, 1, 5]
 * Explanation:
 * push(5); // stack: [5]
 * push(1); // stack: [5,1]
 * push(5); // stack: [5,1,5]
 * top();     // return 5
 * popMax();  // return 5 (topmost 5 removed), stack: [5,1]
 * top();     // return 1
 * peekMax(); // return 5
 * pop();     // return 1, stack: [5]
 * top();     // return 5
 *
 * Approach (active — TreeMap + doubly linked list, O(log n) all ops):
 * DLL holds elements in stack order (tail = top), giving O(1) removal at any position.
 * A TreeMap maps each value to a list of its DLL nodes; lastKey() yields the max in O(log n),
 * and the last entry in the list is the most recently pushed copy. popMax removes that node
 * from both structures in O(log n) with no element shifting.
 *
 * Approach (commented-out — two stacks, O(n) popMax):
 * maxStack mirrors the main stack storing the running maximum at each depth so peekMax is O(1).
 * popMax buffers elements into a temp stack until it finds the max, removes it via pop() (keeping
 * maxStack in sync), then pushes the buffer back via push(). O(1) for all ops except popMax O(n).
 */
public class H_MaxStack {

    // Doubly linked list node — enables O(1) removal at any position
    private static class Node {
        int val;
        Node prev, next;
        Node(int val) { this.val = val; }
    }

    private Node head, tail;                       // dummy sentinels; tail.prev = top of stack
    private TreeMap<Integer, List<Node>> map;      // val → nodes with that val, insertion-ordered

    public H_MaxStack() {
        head = new Node(0);
        tail = new Node(0);
        head.next = tail;
        tail.prev = head;
        map = new TreeMap<>();
    }

    public void push(int x) {
        // insert new node just before tail so tail.prev is always the top
        Node node = new Node(x);
        node.prev = tail.prev;
        node.next = tail;
        tail.prev.next = node;
        tail.prev = node;
        // track in TreeMap — list order matches push order, so last = most recently pushed
        map.computeIfAbsent(x, k -> new ArrayList<>()).add(node);
    }

    public int pop() {
        Node top = tail.prev;
        removeNode(top);
        List<Node> list = map.get(top.val);
        list.remove(list.size() - 1);              // most recently pushed = last in list
        if (list.isEmpty()) map.remove(top.val);
        return top.val;
    }

    public int top() {
        return tail.prev.val;
    }

    public int peekMax() {
        return map.lastKey();                       // TreeMap sorted ascending; lastKey = max
    }

    public int popMax() {
        int maxVal = map.lastKey();
        List<Node> list = map.get(maxVal);
        Node maxNode = list.remove(list.size() - 1); // most recently pushed copy of max
        if (list.isEmpty()) map.remove(maxVal);
        removeNode(maxNode);                        // O(1) DLL unlink — no shifting needed
        return maxVal;
    }

    // O(1) removal from doubly linked list by pointer surgery
    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
}


// -------------------------------------------------------------------------
// Two-stack alternative — simpler but O(n) popMax
// import java.util.Stack; (needed for this version)
// -------------------------------------------------------------------------
// class H_MaxStack {
//
//     private Stack<Integer> stack;
//     private Stack<Integer> maxStack;  // top always holds current max
//
//     public H_MaxStack() {
//         stack = new Stack<>();
//         maxStack = new Stack<>();
//     }
//
//     public void push(int x) {
//         stack.push(x);
//         // maxStack top = running max of everything pushed so far
//         maxStack.push(maxStack.isEmpty() ? x : Math.max(x, maxStack.peek()));
//     }
//
//     public int pop() {
//         maxStack.pop();
//         return stack.pop();
//     }
//
//     public int top() {
//         return stack.peek();
//     }
//
//     public int peekMax() {
//         return maxStack.peek();
//     }
//
//     public int popMax() {
//         int max = peekMax();
//         Stack<Integer> buffer = new Stack<>();
//         // pop until we find the max; use pop() to keep maxStack in sync
//         while (stack.peek() != max) {
//             buffer.push(pop());
//         }
//         pop();  // remove the max itself
//         // push everything back; use push() to rebuild maxStack correctly
//         while (!buffer.isEmpty()) {
//             push(buffer.pop());
//         }
//         return max;
//     }
// }
