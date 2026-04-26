package problems.array;

/**
 * LC: 1004
 * https://leetcode.com/problems/max-consecutive-ones-iii/
 * Given a binary array nums and an integer k, return the maximum number of consecutive 1's in the array
 * if you can flip at most k 0's.
 *
 * Example 1:
 *
 * Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
 * Output: 6
 * Explanation: [1,1,1,0,0,0,1,1,1,1,0] -> [1,1,1,0,0,1,1,1,1,1,0]
 * The longest subarray with consecutive 1s has length 6.
 *
 * Example 2:
 *
 * Input: nums = [0,0,1,1,1,0,0], k = 0
 * Output: 3
 * Explanation: Since k is 0, we cannot flip any 0s. The longest subarray with consecutive 1s is [1,1,1].
 *
 * Approach: Use a sliding window and keep track of how many 0s are inside the window. Expand the
 * right edge, and while the window contains more than k zeros, shrink it from the left.
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 * Tags: Array
 * Tags: SlidingWindow
 */
public class M_LongestOnes {
    public int longestOnes(int[] nums, int k) {
        int l = 0;
        int max = 0;
        int zeroCount = 0;

        for (int r = 0; r < nums.length; r++) {
            if (nums[r] == 0) {
                zeroCount++;
            }

            while (zeroCount > k) {
                if (nums[l] == 0) {
                    zeroCount--;
                }
                l++;
            }

            max = Math.max(max, r - l + 1);
        }
        return max;
    }
}
