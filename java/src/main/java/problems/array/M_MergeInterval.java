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
        Arrays.sort(intervals, (a,b)->(a[0]-b[0]));
        List<int[]> output = new ArrayList<>();
        output.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            int[] curr = output.get(output.size() - 1);
            int[] next = intervals[i];
            
            if (curr[1] >= next[0]) {
                curr[1] = Math.max(curr[1], next[1]);
            } else {
                output.add(next);
            }
        }
        
        return output.toArray(new int[output.size()][]);
    }
}
