package datastructures;

import java.util.HashMap;
import java.util.Map;

/**
 * HashMapNotes - common HashMap patterns for DSA problems.
 *
 * Pattern 1: Frequency count
 *   Use when: finding duplicates, majority element, anagram check.
 *
 * Pattern 2: Two-sum lookup
 *   Use when: finding a pair that sums to target in O(n).
 *
 * Pattern 3: Prefix sum with HashMap
 *   Use when: subarray sum equals target.
 *
 * Pattern 4: Index storage
 *   Use when: need to know where you last saw a value (sliding window).
 */
public class HashMapNotes {

    /**
     * Pattern 1 - Frequency count
     * Count occurrences of each element.
     */
    public Map<Integer, Integer> frequencyCount(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int n : nums) {
            freq.put(n, freq.getOrDefault(n, 0) + 1);
        }
        return freq;
    }

    /**
     * Pattern 2 - Two-sum lookup
     * Find indices of two numbers that add up to target.
     * Time: O(n)   Space: O(n)
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> seen = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (seen.containsKey(complement)) {
                return new int[]{seen.get(complement), i};
            }
            seen.put(nums[i], i);
        }
        return new int[]{};
    }

    /**
     * Pattern 3 - Prefix sum with HashMap
     * Count subarrays whose sum equals target.
     * Time: O(n)   Space: O(n)
     */
    public int subarraySum(int[] nums, int target) {
        Map<Integer, Integer> prefixCount = new HashMap<>();
        prefixCount.put(0, 1);
        int sum = 0;
        int count = 0;
        for (int n : nums) {
            sum += n;
            count += prefixCount.getOrDefault(sum - target, 0);
            prefixCount.put(sum, prefixCount.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}
