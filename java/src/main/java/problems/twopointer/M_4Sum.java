package problems.twopointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LC: 18
 * Tags: Array
 * Tags: TwoPointer
 * https://leetcode.com/problems/4sum/
 * Given an array nums of n integers and an integer target, return all unique quadruplets
 * [nums[a], nums[b], nums[c], nums[d]] such that a, b, c, d are distinct indices and
 * nums[a] + nums[b] + nums[c] + nums[d] == target. The solution set must not contain duplicates.
 *
 * Example 1:
 *
 * Input: nums = [1,0,-1,0,-2,2], target = 0
 * Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
 *
 * Example 2:
 *
 * Input: nums = [2,2,2,2,2], target = 8
 * Output: [[2,2,2,2]]
 *
 * Approach: Sort, then fix two outer indices i and j with nested loops, and use two pointers
 * l and r on the remaining subarray to find pairs that complete the target sum. Skip duplicate
 * values at all four levels to avoid repeated quadruplets.
 */
public class M_4Sum {
        public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        int n=nums.length;
        Arrays.sort(nums);
        for(int i=0;i<n-3;i++){
            if(i>0 && nums[i]==nums[i-1]) continue;
            for(int j=i+1;j<n-2;j++){
                if(j>i+1 && nums[j]==nums[j-1]) continue;
                int l=j+1;
                int r=n-1;
                while(l<r){
                    long sum= (long) nums[i]+nums[j]+nums[l]+nums[r];
                    if(sum<target){
                        l++;
                    } else if (sum>target){
                        r--;
                    } else {
                        result.add(List.of(nums[i],nums[j],nums[l],nums[r]));
                        l++;
                        r--;
                        while(l<r && nums[l]==nums[l-1]) l++;
                        while(l<r && nums[r]==nums[r+1]) r--;
                    }
                }
            }
        }
        return result;
        
    }
}
