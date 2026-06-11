package problems.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * LC: 954
 * Tags: Array
 * Tags: HashTable
 * Tags: Greedy
 * https://leetcode.com/problems/array-of-doubled-pairs/
 * Given an integer array of even length arr, return true if it is possible to reorder arr such
 * that arr[2 * i + 1] == 2 * arr[2 * i] for every 0 <= i < len(arr) / 2, else return false.
 *
 * Constraints:
 * 2 <= arr.length <= 3 * 10^4
 * arr.length is even.
 * -10^5 <= arr[i] <= 10^5
 *
 * Example 1:
 *
 * Input: arr = [3,1,3,6]
 * Output: false
 * Explanation: There is no way to reorder arr to satisfy the condition.
 *
 * Example 2:
 *
 * Input: arr = [2,1,2,6]
 * Output: false
 * Explanation: 1 can pair with 2, but the leftover 2 needs a 4 which is absent.
 *
 * Example 3:
 *
 * Input: arr = [4,-2,2,-4]
 * Output: true
 * Explanation: Reorder to [-2,-4,2,4]: (-2,-4) and (2,4) are valid doubled pairs.
 *
 * Approach: Count frequencies with a HashMap, then sort keys by absolute value so smaller
 * magnitudes are processed first. For each key, greedily consume as many key*2 entries as
 * needed; if supply falls short, pairing is impossible. Sorting by absolute value (not raw value)
 * is critical for negatives: -2 must be processed before -4 so it correctly claims -4 as its
 * double rather than searching for -8.
 */
public class M_ReorderDoubled {
        public boolean canReorderDoubled(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : arr)
            map.put(n, map.getOrDefault(n, 0) + 1);

        List<Integer> keys = new ArrayList<>(map.keySet());
        // sort by |abs|: ensures x is paired with 2x (not x/2), handles negatives correctly
        keys.sort((a, b) -> Math.abs(a) - Math.abs(b));

        for (int key : keys) {
            if (map.get(key) == 0) continue;   // already consumed as a double of a smaller key
            int val = map.getOrDefault(key * 2, 0);
            if (val < map.get(key)) return false;
            map.put(key * 2, val - map.get(key));
            map.put(key, 0);
        }

        return true;
    }
}
