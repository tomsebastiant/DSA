package problems.array;

import java.util.ArrayList;
import java.util.List;

/**
 * LC: 57
 * Tags: Array
 * https://leetcode.com/problems/insert-interval/
 * You are given an array of non-overlapping intervals sorted in ascending order by start time,
 * and a single newInterval to insert. Insert newInterval into the array, merging any overlapping
 * intervals, so the result remains sorted and non-overlapping. Return the resulting interval array.
 *
 * Constraints:
 * 0 <= intervals.length <= 10^4
 * intervals[i].length == 2
 * 0 <= starti <= endi <= 10^5
 * intervals is sorted by starti in ascending order and contains no overlapping intervals.
 * newInterval.length == 2
 * 0 <= start <= end <= 10^5
 *
 * Example 1:
 *
 * Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
 * Output: [[1,5],[6,9]]
 * Explanation: [2,5] overlaps [1,3] → merged to [1,5]. [6,9] is untouched.
 *
 * Example 2:
 *
 * Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * Output: [[1,2],[3,10],[12,16]]
 * Explanation: [4,8] overlaps [3,5],[6,7],[8,10] → all three merge into [3,10].
 *
 * Approach: Three-phase linear scan exploiting the pre-sorted, non-overlapping input.
 * Phase 1 — copy all intervals whose end is strictly before newInterval's start (no overlap).
 * Phase 2 — absorb every interval that overlaps newInterval by expanding its boundaries with
 * min/max; add the final merged newInterval.
 * Phase 3 — copy all remaining intervals unchanged. O(n) time, O(n) space.
 */
public class M_InsertInterval {
        public int[][] insert(int[][] intervals, int[] newInterval) {
        int n=intervals.length;
        List<int[]> result  = new ArrayList<>();
        int i=0;

        while(i<n && intervals[i][1]<newInterval[0]){
            result.add(intervals[i]);
            i++;
        }

        while(i<n && intervals[i][0]<=newInterval[1]){
            newInterval[0]=Math.min(newInterval[0],intervals[i][0]);
            newInterval[1]=Math.max(newInterval[1],intervals[i][1]);
            i++;
        }
        result.add(newInterval);

        while(i<n){
            result.add(intervals[i]);
            i++; 
        }


        return result.toArray(new int[result.size()][2]);

    }
}
