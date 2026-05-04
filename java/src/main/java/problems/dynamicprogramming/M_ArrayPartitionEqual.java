package problems.dynamicprogramming;

/**
 * LC: 416
 * https://leetcode.com/problems/partition-equal-subset-sum/
 * Given an integer array nums, return true if you can partition the array into two subsets
 * such that the sum of the elements in both subsets is equal.
 *
 * Example 1:
 *
 * Input: nums = [1,5,11,5]
 * Output: true
 * Explanation: The array can be partitioned as [1, 5, 5] and [11].
 *
 * Example 2:
 *
 * Input: nums = [1,2,3,5]
 * Output: false
 * Explanation: The array cannot be partitioned into two subsets with equal sum.
 *
 * Approach: This is a 0/1 subset sum problem.
 * If the total sum is odd, it is impossible to split it into two equal halves.
 * Otherwise, we try to find a subset with sum equal to totalSum / 2 using bottom-up DP.
 * Tags: DynamicProgramming
 * Tags: Array
 * Tags: Knapsack
 */
public class M_ArrayPartitionEqual {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        // Compute the total sum first; if it is odd, equal partition is impossible.
        for (int num : nums) {
            sum = sum + num;
        }

        if (sum % 2 != 0) {
            return false;
        }

        int target = sum/2;
        boolean[] dp = new boolean[target + 1];
        // Zero sum is always achievable by choosing no elements.
        dp[0] = true;

        for (int num : nums) {
            // Traverse backwards so each number is used at most once.
            for (int j = target; j >= num; j--) {
                // Either we already could make j, or we can make it by using the current number.
                dp[j] = dp[j] || dp[j - num];
            }
        }

        return dp[target];
    }
}
