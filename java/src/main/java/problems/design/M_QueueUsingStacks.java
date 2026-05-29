package problems.design;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * LC: 232
 * Tags: Design
 * Tags: Stack
 * https://leetcode.com/problems/implement-queue-using-stacks/
 * Implement a first-in first-out (FIFO) queue using only two stacks. The implemented queue must
 * support push(x), pop(), peek(), and empty() using only standard stack operations (push to top,
 * pop/peek from top, size, isEmpty).
 *
 * Follow-up: Can you implement the queue so that each operation is amortized O(1)?
 *
 * Constraints:
 * 1 <= x <= 9
 * At most 100 calls will be made to push, pop, peek, and empty.
 * All calls to pop and peek are valid (queue is non-empty).
 *
 * Example 1:
 *
 * Input:  ["MyQueue","push","push","peek","pop","empty"]
 *         [[], [1], [2], [], [], []]
 * Output: [null, null, null, 1, 1, false]
 * Explanation:
 * myQueue.push(1); // queue: [1]
 * myQueue.push(2); // queue: [1, 2]
 * myQueue.peek();  // return 1
 * myQueue.pop();   // return 1, queue: [2]
 * myQueue.empty(); // return false
 *
 * Approach: inbox receives all pushes; outbox is refilled lazily by draining inbox (reversing
 * order) only when outbox is empty. Each element moves between stacks at most once, giving
 * amortized O(1) per operation.
 *
 * NOTE: LeetCode rates this problem Easy — the M_ filename prefix appears to be a mismatch.
 */
public class M_QueueUsingStacks {
        Deque<Integer> inbox;
    Deque<Integer> outbox;

    public M_QueueUsingStacks() {
        inbox = new ArrayDeque<>();
        outbox = new ArrayDeque<>();
    }
    
    public void push(int x) {
        inbox.push(x);
    }
    
    public int pop() {
        refill();
        return outbox.pop();
    }
    
    public int peek() {
        refill();
        return outbox.peek();
    }
    
    public boolean empty() {
        return outbox.isEmpty() && inbox.isEmpty();
    }

    public void refill(){
        if(outbox.isEmpty()){
            while(!inbox.isEmpty()){
                outbox.push(inbox.pop());
            }
        }
    }
}
