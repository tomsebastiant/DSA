package problems.priorityqueue;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * LC: 295
 * Tags: PriorityQueue
 * Tags: Design
 * https://leetcode.com/problems/find-median-from-data-stream/
 * The median is the middle value in an ordered integer list. If the size of the list is even,
 * there is no middle value, and the median is the mean of the two middle values.
 *
 * For example, for arr = [2,3,4], the median is 3.
 * For example, for arr = [2,3], the median is (2 + 3) / 2 = 2.5.
 *
 * Implement the MedianFinder class:
 * - MedianFinder() initializes the MedianFinder object.
 * - void addNum(int num) adds the integer num from the data stream to the data structure.
 * - double findMedian() returns the median of all elements so far. Answers within 10^-5 of
 *   the actual answer will be accepted.
 *
 * Example 1:
 *
 * Input: ["MedianFinder","addNum","addNum","findMedian","addNum","findMedian"]
 *        [[],[1],[2],[],[3],[]]
 * Output: [null,null,null,1.5,null,2.0]
 * Explanation:
 * MedianFinder medianFinder = new MedianFinder();
 * medianFinder.addNum(1);    // arr = [1]
 * medianFinder.addNum(2);    // arr = [1, 2]
 * medianFinder.findMedian(); // return 1.5
 * medianFinder.addNum(3);    // arr = [1, 2, 3]
 * medianFinder.findMedian(); // return 2.0
 *
 * Constraints:
 * -10^5 <= num <= 10^5
 * There will be at least one element in the data structure before calling findMedian.
 * At most 5 * 10^4 calls will be made to addNum and findMedian.
 *
 * Approach: Maintain two heaps — small (max-heap) holds the lower half and large (min-heap) holds
 * the upper half. Every insertion routes through small first, then moves small's maximum to large,
 * guaranteeing every element in small <= every element in large. If large grows bigger, one element
 * is moved back to small so small is always equal to or one ahead of large in size.
 * The median is small's top alone (odd total) or the average of both tops (even total).
 */
public class H_DataStreamMedian {
    PriorityQueue<Integer> small = new PriorityQueue<>(Collections.reverseOrder());
    PriorityQueue<Integer> large = new PriorityQueue<>();    

    
    public void addNum(int num) {
        // Always insert into small first so the cross-heap ordering invariant is enforced next.
        small.offer(num);
        // Push small's max to large — guarantees max(small) <= min(large) after every insert.
        large.offer(small.poll());
        // Rebalance: small must be >= large in size so the median is always accessible from small.
        if(large.size()>small.size()){
            small.offer(large.poll());
        }
    }
    
    public double findMedian() {
        if(small.size()>large.size()) return small.peek();
        return (small.peek()+large.peek())/2.0;
    }
}
