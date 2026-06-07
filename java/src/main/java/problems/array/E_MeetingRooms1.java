package problems.array;

import java.util.Arrays;

/**
 * LC: 252
 * Tags: Array
 * https://leetcode.com/problems/meeting-rooms/
 * Given an array of meeting time intervals where intervals[i] = [start_i, end_i], determine if
 * a person could attend all meetings (i.e. no two meetings overlap).
 *
 * Constraints:
 * 0 <= intervals.length <= 10^4
 * intervals[i].length == 2
 * 0 <= start_i < end_i <= 10^6
 *
 * Example 1:
 *
 * Input: intervals = [[0,30],[5,10],[15,20]]
 * Output: false
 * Explanation: [0,30] overlaps with both [5,10] and [15,20].
 *
 * Example 2:
 *
 * Input: intervals = [[7,10],[2,4]]
 * Output: true
 * Explanation: Sorted: [[2,4],[7,10]] — [2,4] ends before [7,10] starts, no overlap.
 *
 * Approach: Sort by start time. A single pass then suffices — if any meeting starts before the
 * previous one ends (intervals[i][0] < intervals[i-1][1]) there is an overlap. O(n log n) time.
 *
 * NOTE: Premium LeetCode problem.
 */
public class E_MeetingRooms1 {
    public boolean canAttendMeetings(int[][] intervals) {
    // sort by start time
    Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

    for (int i = 1; i < intervals.length; i++) {
        // if current meeting starts before previous ends → overlap
        if (intervals[i][0] < intervals[i-1][1]) {
            return false;
        }
    }
    return true;
    }
}
