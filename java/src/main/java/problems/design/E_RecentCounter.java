package problems.design;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * LC: 933
 * Tags: Design
 * Tags: Queue
 * https://leetcode.com/problems/number-of-recent-calls/
 * Design a RecentCounter class to count recent requests within a 3000-millisecond sliding window.
 *
 * Implement the RecentCounter class:
 * - RecentCounter() initializes the counter with zero recent requests.
 * - int ping(int t) adds a new request at time t (milliseconds) and returns the number of requests
 *   that have occurred in the inclusive range [t - 3000, t]. It is guaranteed that every call to
 *   ping uses a strictly larger value of t than before.
 *
 * Constraints:
 * 1 <= t <= 10^9
 * Each test case calls ping with strictly increasing values of t.
 * At most 10^4 calls will be made to ping.
 *
 * Example 1:
 *
 * Input: ["RecentCounter","ping","ping","ping","ping"], [[], [1], [100], [3001], [3002]]
 * Output: [null, 1, 2, 3, 3]
 * Explanation:
 * recentCounter.ping(1);    // requests = [1],          range [-2999, 1],    return 1
 * recentCounter.ping(100);  // requests = [1, 100],     range [-2900, 100],  return 2
 * recentCounter.ping(3001); // requests = [1, 100, 3001], range [1, 3001],   return 3
 * recentCounter.ping(3002); // requests = [100, 3001, 3002], range [2, 3002], return 3
 *
 * Approach: Enqueue each incoming timestamp, then dequeue all entries older than t-3000. Because
 * pings arrive in strictly increasing order, expired entries are always at the front, making the
 * queue size after cleanup the exact count of requests in the window.
 */
public class E_RecentCounter {
        private Queue<Integer> queue;

    public E_RecentCounter() {
        queue = new ArrayDeque<>();
    }
    
    public int ping(int t) {
        queue.offer(t);

        while(queue.peek()<t-3000){
            queue.poll();
        }
        return queue.size();
    }
}
