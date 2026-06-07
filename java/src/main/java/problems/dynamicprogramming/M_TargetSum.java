package problems.dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

/**
 * LC: 494
 * Tags: DynamicProgramming
 * Tags: Array
 * https://leetcode.com/problems/target-sum/
 * You are given an integer array nums and an integer target. Assign a '+' or '-' sign to each
 * element of nums and concatenate them into an expression (e.g. +1-2+3). Return the number of
 * different sign assignments whose expression evaluates to target.
 *
 * Constraints:
 * 1 <= nums.length <= 20
 * 0 <= nums[i] <= 1000
 * 0 <= sum(nums[i]) <= 1000
 * -1000 <= target <= 1000
 *
 * Example 1:
 *
 * Input: nums = [1,1,1,1,1], target = 3
 * Output: 5
 * Explanation: Five ways to reach 3 — assign '-' to exactly one element:
 *   -1+1+1+1+1 = +1-1+1+1+1 = +1+1-1+1+1 = +1+1+1-1+1 = +1+1+1+1-1 = 3
 *
 * Example 2:
 *
 * Input: nums = [1], target = 1
 * Output: 1
 *
 * Approach: Top-down memoized recursion. At each index try both + and - for the current
 * element, passing the updated running sum forward. State is (index, runningSum) encoded as
 * a "index,sum" string key; the memo collapses duplicate subproblems from O(2^n) to O(n * S)
 * where S is the range of reachable sums. The commented-out backtracking below is the same
 * logic without memoization — correct but O(2^n).
 */
public class M_TargetSum {
        public int findTargetSumWays(int[] nums, int target) {
        Map<String,Integer> memo = new HashMap<>();
        return dp(nums,0,0,target,memo);
    }

    public int dp(int[] nums, int start, int curr, int target, Map<String,Integer> memo){
        if(start==nums.length){
            return curr==target?1:0;
        }
        String key=start+","+curr;
        if(memo.containsKey(key)) return memo.get(key);

        int result =dp(nums,start+1,curr+nums[start],target,memo)+
                        dp(nums,start+1,curr-nums[start],target,memo);
        memo.put(key,result);
        return result;
    }
    // int count;
    // public int findTargetSumWays(int[] nums, int target) {
    //     count =0;
    //     backtrack(nums,0,0,target);
    //     return count;
    // }

    // public void backtrack(int[] nums, int start, int curr, int target){
    //     if(curr==target && start==nums.length){
    //         count++;
    //         return;
    //     }
    //     if(start>=nums.length) return;
    //     backtrack(nums,start+1,curr+nums[start],target);
    //     backtrack(nums,start+1,curr-nums[start],target);
    // }
}
