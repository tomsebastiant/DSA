package leetcode.array;

/**
 Tags: Greedy
 https://leetcode.com/problems/jump-game
 You are given an integer array nums. You are initially positioned
 at the array's first index, and each element in the array represents
 your maximum jump length at that position.

 Return true if you can reach the last index, or false otherwise.



 Example 1:

 Input: nums = [2,3,1,1,4]
 Output: true
 Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
 Example 2:

 Input: nums = [3,2,1,0,4]
 Output: false
 Explanation: You will always arrive at index 3 no matter what. Its maximum
 jump length is 0, which makes it impossible to reach the last index.


 Approach:
 Set the first max jump. Iterate through the array. If your max jump
 allows you to reach there, continue and calculate new max jump distance if
 exists. Otherwise return false;
 Ifg the iteration is completed, return true;
 */

public class M_55_JumpGame {
    public boolean canJump(int[] nums) {
        int max=nums[0];
        for(int i=1;i<nums.length;i++){
            if(i<=max){
                int curr = i+nums[i];
                max=Math.max(curr,max);
            } else {
                return false;
            }
        }
        return true;
    }
}
