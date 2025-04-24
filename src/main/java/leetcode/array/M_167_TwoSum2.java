package leetcode.array;


/**
 https://leetcode.com/problems/two-sum-ii-input-array-is-sorted
 Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order, find two numbers such that they add up to a specific target number. Let these two numbers be numbers[index1] and numbers[index2] where 1 <= index1 < index2 <= numbers.length.

 Return the indices of the two numbers, index1 and index2, added by one as an integer array [index1, index2] of length 2.

 The tests are generated such that there is exactly one solution. You may not use the same element twice.

 Your solution must use only constant extra space.

 Approach: 2 pointer. Traverse the array from left and right. If the curr sum greater than target, r--
 if curr sum less than target sum l++
 */
public class M_167_TwoSum2 {
    public int[] twoSum(int[] numbers, int target) {
        int l =0;
        int r =numbers.length-1;
        while(l<r){
            if(numbers[l]+numbers[r]>target){
                r--;
            } else if(numbers[l]+numbers[r]<target){
                l++;
            } else {
                break;
            }
        }
        return new int[]{l+1,r+1};
    }
}
