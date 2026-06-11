package problems.array;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * LC: 253
 * Tags: Array
 * Tags: PriorityQueue
 * https://leetcode.com/problems/meeting-rooms-ii/
 * Given an array of meeting time intervals where intervals[i] = [start_i, end_i], return the
 * minimum number of conference rooms required to hold all meetings simultaneously.
 *
 * Constraints:
 * 1 <= intervals.length <= 10^4
 * 0 <= start_i < end_i <= 10^6
 *
 * Example 1:
 *
 * Input: intervals = [[0,30],[5,10],[15,20]]
 * Output: 2
 * Explanation: [5,10] overlaps [0,30] → 2 rooms needed. [15,20] reuses the room freed by [5,10].
 *
 * Example 2:
 *
 * Input: intervals = [[7,10],[2,4]]
 * Output: 1
 * Explanation: Sorted: [[2,4],[7,10]] — [2,4] ends before [7,10] starts, one room suffices.
 *
 * Approach: Sort by start time. A min-heap stores the end times of all currently occupied rooms,
 * smallest at the top. For each meeting, if the earliest-ending room has already freed up
 * (pq.peek() <= current start), recycle it (poll); then always push the current end time.
 * Each heap entry represents one room still in use — the final heap size is the peak overlap
 * count, which equals the minimum rooms needed.
 *
 * NOTE: Premium LeetCode problem. Companion to E_MeetingRooms1 (LC 252).
 */
public class M_MeetingRooms2 {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->(a[0]-b[0]));
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
    
        for(int i=0;i<intervals.length;i++){
            if (!pq.isEmpty() && pq.peek() <= intervals[i][0]) {
                pq.poll();
            }
            pq.offer(intervals[i][1]);
            
        }

        return pq.size();
    }
}
