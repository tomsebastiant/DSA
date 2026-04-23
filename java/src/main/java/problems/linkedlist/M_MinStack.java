package problems.linkedlist;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * LC: 155
 * https://leetcode.com/problems/min-stack/
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 *
 * Implement the MinStack class:
 * - MinStack() initializes the stack object.
 * - void push(int val) pushes the element val onto the stack.
 * - void pop() removes the element on the top of the stack.
 * - int top() gets the top element of the stack.
 * - int getMin() retrieves the minimum element in the stack.
 *
 * Example 1:
 *
 * Input:
 * ["MinStack","push","push","push","getMin","pop","top","getMin"]
 * [[],[-2],[0],[-3],[],[],[],[]]
 * Output:
 * [null,null,null,null,-3,null,0,-2]
 *
 * Approach: Keep one stack for values and another stack for the current minimum at each depth.
 * Tags: Stack
 * Tags: Design
 */
public class M_MinStack {

    private final Deque<Integer> stack;
    private final Deque<Integer> minStack;

    public M_MinStack() {
        stack = new ArrayDeque<>();
        minStack = new ArrayDeque<>();
    }

    public void push(int val) {
        stack.push(val);
        if (minStack.isEmpty()) {
            minStack.push(val);
        } else {
            minStack.push(Math.min(val, minStack.peek()));
        }
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
