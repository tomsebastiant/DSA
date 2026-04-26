package problems.array;

/**
 * LC: 53
 * https://leetcode.com/problems/maximum-subarray/
 * Given an integer array nums, find the subarray with the largest sum, and return its sum.
 *
 * Example 1:
 *
 * Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * Output: 6
 * Explanation: The subarray [4,-1,2,1] has the largest sum 6.
 *
 * Example 2:
 *
 * Input: nums = [1]
 * Output: 1
 *
 * Example 3:
 *
 * Input: nums = [5,4,-1,7,8]
 * Output: 23
 *
 * Constraints:
 *
 * 1 <= nums.length <= 10^5
 * -10^4 <= nums[i] <= 10^4
 *
 * Approach: Kadane's algorithm keeps track of the best subarray sum ending at the current index
 * and the best sum seen overall. At each step, either extend the previous subarray or start fresh.
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 * Tags: Array
 * Tags: DynamicProgramming
 */
public class M_MaxSubArray {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int max = nums[0];
        int curr = nums[0];
        for (int i = 1; i < nums.length; i++) {
            curr = Math.max(nums[i], curr + nums[i]);
            max = Math.max(max, curr);
        }
        return max;
    }    
}
