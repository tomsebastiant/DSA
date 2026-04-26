package problems.array;

import java.util.ArrayList;
import java.util.List;

/**
 * LC: 442
 * https://leetcode.com/problems/find-all-duplicates-in-an-array/
 * Given an integer array nums of length n where all the integers of nums are in the range [1, n]
 * and each integer appears once or twice, return an array of all the integers that appears twice.
 *
 * You must write an algorithm that runs in O(n) time and uses only constant extra space.
 *
 * Example 1:
 *
 * Input: nums = [4,3,2,7,8,2,3,1]
 * Output: [2,3]
 *
 * Example 2:
 *
 * Input: nums = [1,1,2]
 * Output: [1]
 *
 * Approach: Mark the index corresponding to each value as negative. If we see a value whose index
 * is already negative, that value is a duplicate.
 * Tags: Array
 * Tags: InPlace
 */
public class M_FindDuplicates {
        public List<Integer> findDuplicates(int[] nums) {
        List<Integer> output = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(nums[Math.abs(nums[i])-1]<0){
                output.add(Math.abs(nums[i]));
            }else {
                nums[Math.abs(nums[i])-1] = -1*nums[Math.abs(nums[i])-1];
            }
        }
        return output;
    }
}
