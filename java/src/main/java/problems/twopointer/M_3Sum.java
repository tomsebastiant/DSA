package problems.twopointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LC: 15
 * Tags: Array
 * Tags: TwoPointer
 * https://leetcode.com/problems/3sum/
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that
 * i != j, i != k, j != k, and nums[i] + nums[j] + nums[k] == 0. The solution set must not
 * contain duplicate triplets.
 *
 * Example 1:
 *
 * Input: nums = [-1,0,1,2,-1,-4]
 * Output: [[-1,-1,2],[-1,0,1]]
 *
 * Example 2:
 *
 * Input: nums = [0,1,1]
 * Output: []
 *
 * Example 3:
 *
 * Input: nums = [0,0,0]
 * Output: [[0,0,0]]
 *
 * Approach: Sort the array, then fix each element as the first of the triplet and use two
 * pointers on the remaining subarray to find pairs that sum to its negation. Skip duplicate
 * values at both the outer and inner levels to avoid repeated triplets.
 */
public class M_3Sum {
        public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> output = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length-2;i++){
            if (i > 0 && nums[i] == nums[i-1]) continue;
            int l=i+1;
            int r=nums.length-1;
            while(l<r){
                int sum=nums[i]+nums[l]+nums[r];
                if(sum<0){
                    l++;
                } else if (sum>0){
                    r--;
                } else {
                    output.add(List.of(nums[i],nums[l],nums[r]));
                    l++;
                    r--;                    
                    while (l < r && nums[l] == nums[l-1]) l++;
                    while (l < r && nums[r] == nums[r+1]) r--;
                }
            }
        }
        return output;
    }
}

