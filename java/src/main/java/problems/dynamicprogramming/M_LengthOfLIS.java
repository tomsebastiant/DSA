package problems.dynamicprogramming;

import java.util.Arrays;

/**
 * LC: 300
 * Tags: DynamicProgramming
 * Tags: Array
 * https://leetcode.com/problems/longest-increasing-subsequence/
 * Given an integer array nums, return the length of the longest strictly increasing subsequence.
 *
 * Example 1:
 *
 * Input: nums = [10,9,2,5,3,7,101,18]
 * Output: 4
 * Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
 *
 * Example 2:
 *
 * Input: nums = [0,1,0,3,2,3]
 * Output: 4
 *
 * Example 3:
 *
 * Input: nums = [7,7,7,7,7,7,7]
 * Output: 1
 *
 * Constraints:
 * 1 <= nums.length <= 2500
 * -10^4 <= nums[i] <= 10^4
 *
 * Approach: 1D DP where dp[i] is the length of the longest increasing subsequence that ends at
 * index i. Every element is at least a subsequence of length 1 on its own. For each i, scan all
 * j < i: if nums[j] < nums[i] the subsequence ending at j can be extended by nums[i], so
 * dp[i] = max(dp[i], dp[j] + 1). The answer is the maximum across all dp entries because the
 * LIS can end at any position. Time: O(n²). An O(n log n) solution using patience sorting exists
 * but this approach is simpler to reason about.
 */
public class M_LengthOfLIS {
        public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        int[] dp = new int[n];
        // Every element is a valid subsequence of length 1 by itself.
        Arrays.fill(dp,1);
        int result =1;

        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(nums[j]<nums[i]){
                    // Extend the best subsequence ending at j by appending nums[i].
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }
            // Track the global max — LIS can end at any index, not just the last one.
            result= Math.max(result,dp[i]);
        }
        return result;
    }
}
