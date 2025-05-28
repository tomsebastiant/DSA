package leetcode.array;

import java.util.Arrays;

/**
 Tags: Greedy
 https://leetcode.com/problems/non-overlapping-intervals
 Given an array of intervals intervals where intervals[i] = [starti, endi],
 return the minimum number of intervals you need to remove to make the rest
 of the intervals non-overlapping.

 Note that intervals which only touch at a point are non-overlapping. For example,
 [1, 2] and [2, 3] are non-overlapping.



 Example 1:

 Input: intervals = [[1,2],[2,3],[3,4],[1,3]]
 Output: 1
 Explanation: [1,3] can be removed and the rest of the intervals are non-overlapping.
 Example 2:

 Input: intervals = [[1,2],[1,2],[1,2]]
 Output: 2
 Explanation: You need to remove two [1,2] to make the rest of the intervals non-overlapping.



 Approach:
 When you're trying to select the maximum number of non-overlapping intervals
 (or minimize something like removals or resources), you should sort intervals by their end time.

 This ensures that:
 You always make the greediest possible choice that leaves the most room for the rest.
 You reduce the chance of overlapping with future intervals.


 Sort by the end times. Check if the end times overlap with the next
 start time. If they do drop it.
 */

public class M_435_NonOverlappingIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a,b) -> Integer.compare(a[1], b[1]));

        int count =0;
        int end=intervals[0][1];

        for(int i=1;i<intervals.length;i++){
            if(intervals[i][0]<end){
                count++;
            } else {
                end = intervals[i][1];
            }
        }
        return count;
    }
}
