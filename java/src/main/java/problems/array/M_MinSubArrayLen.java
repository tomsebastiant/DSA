package problems.array;

/**
 * LC: 209
 * https://leetcode.com/problems/minimum-size-subarray-sum/
 * Given an array of positive integers nums and a positive integer target, return the minimal length
 * of a subarray whose sum is greater than or equal to target. If there is no such subarray, return 0 instead.
 *
 * Example 1:
 *
 * Input: target = 7, nums = [2,3,1,2,4,3]
 * Output: 2
 * Explanation: The subarray [4,3] has the minimal length under the problem constraint.
 *
 * Example 2:
 *
 * Input: target = 4, nums = [1,4,4]
 * Output: 1
 *
 * Approach: Use a sliding window. Expand the window until the sum reaches the target,
 * then shrink it from the left while maintaining the sum condition to find the minimum length.
 * Tags: Array
 * Tags: SlidingWindow
 */
public class M_MinSubArrayLen {
        public int minSubArrayLen(int target, int[] nums) {
        int l=0;
        int r =0;
        int min =Integer.MAX_VALUE;
        int sum =0;

        for(;r<nums.length;r++){
            sum = sum+ nums[r];
            if(sum>=target){
                while(sum>=target && l <=r){
                    min = Math.min(min,r-l+1);
                    sum = sum - nums[l++];
                }
            }
        }
        return min != Integer.MAX_VALUE ? min : 0;
    }
}
