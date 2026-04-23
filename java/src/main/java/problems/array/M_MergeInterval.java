package problems.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LC: 56
 * https://leetcode.com/problems/merge-intervals/
 * Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals,
 * and return an array of the non-overlapping intervals that cover all the intervals in the input.
 *
 * Example 1:
 *
 * Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 *
 * Example 2:
 *
 * Input: intervals = [[1,4],[4,5]]
 * Output: [[1,5]]
 *
 * Approach: Sort intervals by start/end and keep merging into the current interval when they overlap.
 * Tags: Array
 * Tags: Sorting
 * Tags: Interval
 */
public class M_MergeInterval {
        public int[][] merge(int[][] intervals) {
        if(intervals.length<1){
            return intervals;
        }
        Arrays.sort(intervals, (a,b)->(a[1]-b[1]));
        List<int[]> output = new ArrayList<>();
        int[] curr = intervals[0];
        output.add(curr);
        for(int[] interval:intervals){
            int curr_start = curr[0];
            int curr_end = curr[1];
            int next_start = interval[0];
            int next_end = interval[1];

            if(curr_end >=next_start){
                curr[1] = Math.max(curr_end,next_end);
            } else {
                curr = interval;
                output.add(curr);
            }
        }
        return output.toArray(new int[output.size()][]);
    }
}
