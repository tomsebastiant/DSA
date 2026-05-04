package problems.priorityqueue;

import java.util.PriorityQueue;

/**
 * LC: 215
 * https://leetcode.com/problems/kth-largest-element-in-an-array/
 * Given an integer array nums and an integer k, return the kth largest element in the array.
 *
 * Note that it is the kth largest element in the sorted order, not the kth distinct element.
 *
 * Example 1:
 *
 * Input: nums = [3,2,1,5,6,4], k = 2
 * Output: 5
 *
 * Example 2:
 *
 * Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
 * Output: 4
 *
 * Approach: Use a min-heap of size k.
 * Keep only the k largest numbers seen so far in the heap.
 * The heap root is then the kth largest number because everything smaller has been removed.
 * Tags: PriorityQueue
 * Tags: Heap
 * Tags: Array
 */
public class M_KthLargest {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        // Keep the heap limited to size k so it stores only the k largest elements seen so far.
        for (int num : nums) {
            pq.offer(num);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        // The smallest element in the heap is the kth largest overall.
        return pq.peek();
    }
}
