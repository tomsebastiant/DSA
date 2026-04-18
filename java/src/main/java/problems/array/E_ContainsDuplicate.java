package problems.array;


import java.util.HashSet;
import java.util.Set;

/**
 * LC: 217
 Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.

 Approach: Use a HashSet to keep track of unique elements

 Tags: Array
 */

public class E_ContainsDuplicate {

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> unique = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            if(!unique.contains(nums[i])){
                unique.add(nums[i]);
            } else {
                return true;
            }
        }
        return false;
    }
}



