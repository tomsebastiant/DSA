package leetcode.array;

import java.util.Arrays;

/**
 Tags: #TwoPointer
 https://leetcode.com/problems/3sum-closest
 Given an integer array nums of length n and an integer target, find three
 integers in nums such that the sum is closest to target.

 Return the sum of the three integers.

 You may assume that each input would have exactly one solution.

 Approach: We sort the array. Then we keep the first element as fixed, then we two pointer between the next
 element and the last one and traverse to see what is the closest sum we have got.
 */

public class M_16_3SumClosest {
    public int threeSumClosest(int[] nums, int target) {
        int n=nums.length;
        Arrays.sort(nums);
        int close = nums[0]+nums[1]+nums[n-1];
        for(int i=0;i<n-2;i++){
            int i_val=nums[i];
            int j =i+1;
            int k =n-1;
            while(j<k){
                int temp=i_val+nums[j]+nums[k];
                if(temp<target){
                    j++;
                } else {
                    k--;
                }
                if(Math.abs(target-temp)<Math.abs(target-close)){
                    close=temp;
                }

            }
        }
        return close;
    }
}
