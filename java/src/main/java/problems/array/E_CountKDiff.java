package problems.array;

import java.util.HashMap;
import java.util.Map;

/**
 * LC: 2006
 * Tags: Array
 * Tags: HashTable
 * https://leetcode.com/problems/count-number-of-pairs-with-absolute-difference-k/
 * Given an integer array nums and an integer k, return the number of pairs (i, j) where i < j
 * such that |nums[i] - nums[j]| == k.
 *
 * Example 1:
 *
 * Input: nums = [1,2,2,1], k = 1
 * Output: 4
 * Explanation: The pairs with an absolute difference of 1 are: (0,1), (0,2), (3,1), (3,2).
 *
 * Example 2:
 *
 * Input: nums = [1,3], k = 3
 * Output: 0
 *
 * Example 3:
 *
 * Input: nums = [3,2,1,5,4], k = 2
 * Output: 3
 *
 * Approach: Build a frequency map left to right. For each number, look up how many previously
 * seen values equal num-k or num+k — both directions cover |diff|=k. Adding to the map after
 * the lookup ensures each pair is counted exactly once.
 */
public class E_CountKDiff {
        public int countKDifference(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        int count=0;
        for(int num:nums){
            count = count + map.getOrDefault(num-k,0);
            count = count + map.getOrDefault(num+k,0);

            map.put(num,map.getOrDefault(num,0)+1);
        }
        return count;
    }
}
