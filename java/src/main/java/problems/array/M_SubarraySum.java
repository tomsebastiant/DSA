package problems.array;

import java.util.HashMap;
import java.util.Map;

/**
 * LC: 560
 * https://leetcode.com/problems/subarray-sum-equals-k/
 * Given an array of integers nums and an integer k, return the total number of subarrays
 * whose sum equals to k.
 *
 * A subarray is a contiguous non-empty sequence of elements within an array.
 *
 * Example 1:
 *
 * Input: nums = [1,1,1], k = 2
 * Output: 2
 *
 * Example 2:
 *
 * Input: nums = [1,2,3], k = 3
 * Output: 2
 *
 * Approach: Use prefix sum with a HashMap. For each running sum, count how many previous
 * prefix sums equal sum - k.
 * Tags: Array
 * Tags: HashMap
 * Tags: PrefixSum
 */
public class M_SubarraySum {
    public int subarraySum(int[] nums, int k) {
        int sum = 0;
        int result = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        for (int num : nums) {
            sum += num;
            if (map.get(sum - k) != null) {
                result = result + map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return result;
    }
}
