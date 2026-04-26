package problems.array;

import java.util.HashSet;
import java.util.Set;

/**
 * LC: 128
 * https://leetcode.com/problems/longest-consecutive-sequence/
 * Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
 *
 * You must write an algorithm that runs in O(n) time.
 *
 * Example 1:
 *
 * Input: nums = [100,4,200,1,3,2]
 * Output: 4
 * Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
 *
 * Example 2:
 *
 * Input: nums = [0,3,7,2,5,8,4,6,0,1]
 * Output: 9
 *
 * Example 3:
 *
 * Input: nums = [1,0,1,2]
 * Output: 3
 *
 * Constraints:
 *
 * 0 <= nums.length <= 10^5
 * -10^9 <= nums[i] <= 10^9
 *
 * Approach: Use a HashSet for O(1) average membership checks. Only start counting when a number
 * does not have a predecessor in the set, so each consecutive run is counted exactly once.
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 * Tags: Array
 * Tags: HashTable
 */
public class M_LongestConsecutive {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int max = 0;
        for (int num : set) {
            if (!set.contains(num - 1)) {
                int current = num;
                int streak = 1;
                while (set.contains(current + 1)) {
                    current++;
                    streak++;
                }
                max = Math.max(max, streak);
            }
        }
        return max;
    }
}
