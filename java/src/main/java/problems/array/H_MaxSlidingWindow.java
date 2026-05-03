package problems.array;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * LC: 239
 https://leetcode.com/problems/sliding-window-maximum/
 Given an array nums and an integer k, there is a sliding window of size k
 which moves from the very left of the array to the very right.
 You can only see the k numbers in the window. Each time the window moves right by one position.
 Return the max sliding window.

 Example:
 nums = [1,3,-1,-3,5,3,6,7], k = 3
 Output: [3,3,5,5,6,7]

 Approach: Maintain a decreasing deque of indices so the front always stores the index of the
 current window's maximum element.

 Tags: Deque
 Tags: Monotonic Queue
 Tags: Sliding Window
 */
public class H_MaxSlidingWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];
        Deque<Integer> dequeue = new ArrayDeque<>();

        for (int i = 0; i < nums.length; i++) {
            // Remove indices that are no longer inside the current window.
            while (!dequeue.isEmpty() && dequeue.peekFirst() < i - k + 1) {
                dequeue.pollFirst();
            }
            // Keep the deque decreasing so the front always holds the max value index.
            while (!dequeue.isEmpty() && nums[dequeue.peekLast()] <= nums[i]) {
                dequeue.pollLast();
            }
            // Add the current index after cleaning up smaller/outdated elements.
            dequeue.offerLast(i);
            // Once the first window is formed, record its maximum.
            if (i >= k - 1) {
                result[i - k + 1] = nums[dequeue.peekFirst()];
            }
        }
        return result;
    }
}
