package problems.dynamicprogramming;

/**
 * LC: 198
 * Tags: Array
 * Tags: DynamicProgramming
 * https://leetcode.com/problems/house-robber/
 * You are a professional robber planning to rob houses along a street. Each house has a certain
 * amount of money. Adjacent houses have security systems connected, so you cannot rob two
 * adjacent houses. Given an integer array nums representing the amount of money at each house,
 * return the maximum amount you can rob without alerting the police.
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,1]
 * Output: 4
 * Explanation: Rob house 1 (money = 1) then house 3 (money = 3). Total = 4.
 *
 * Example 2:
 *
 * Input: nums = [2,7,9,3,1]
 * Output: 12
 * Explanation: Rob house 1 (money = 2), house 3 (money = 9), house 5 (money = 1). Total = 12.
 *
 * Approach: 1D DP rolled into two variables. At each house the choice is to skip it (keep prev1)
 * or rob it (prev2 + current value). Track only the best totals for the previous two positions,
 * giving O(n) time and O(1) space.
 */
public class M_HouseRobber {
        public int rob(int[] nums) {
        int n=nums.length;
        if(n==1) return nums[0];
        int prev2=nums[0];
        int prev1=Math.max(nums[0],nums[1]);
        for(int i=2;i<n;i++){
            int curr = Math.max(prev1,prev2+nums[i]);
            prev2=prev1;
            prev1=curr;
        }
        return prev1;
    }
}
