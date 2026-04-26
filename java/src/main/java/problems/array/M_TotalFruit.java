package problems.array;

import java.util.HashMap;
import java.util.Map;

/**
 * LC: 904
 * https://leetcode.com/problems/fruit-into-baskets/
 * You are visiting a farm that has a row of fruit trees arranged from left to right.
 * The trees are represented by an integer array fruits where fruits[i] is the type of fruit
 * the ith tree produces.
 *
 * You want to collect as much fruit as possible. However, you only have two baskets,
 * and each basket can only hold a single type of fruit. Starting from any tree of your choice,
 * you must pick exactly one fruit from every tree while moving to the right. Once you encounter
 * a tree with fruit that cannot fit into your baskets, you must stop.
 *
 * Return the maximum number of fruits you can pick.
 *
 * Example 1:
 *
 * Input: fruits = [1,2,1]
 * Output: 3
 * Explanation: We can pick from all 3 trees.
 *
 * Example 2:
 *
 * Input: fruits = [0,1,2,2]
 * Output: 3
 * Explanation: We can pick from trees [1,2,2].
 *
 * Example 3:
 *
 * Input: fruits = [1,2,3,2,2]
 * Output: 4
 * Explanation: We can pick from trees [2,3,2,2].
 *
 * Constraints:
 *
 * 1 <= fruits.length <= 10^5
 * 0 <= fruits[i] < fruits.length
 *
 * Approach: Use a sliding window with a frequency map. Expand the right edge, and shrink from
 * the left whenever the window contains more than 2 fruit types.
 * Time Complexity: O(n)
 * Space Complexity: O(1) for the fixed basket limit
 * Tags: Array
 * Tags: HashTable
 * Tags: SlidingWindow
 */
public class M_TotalFruit {
    public int totalFruit(int[] fruits) {
        if (fruits == null || fruits.length == 0) {
            return 0;
        }

        Map<Integer, Integer> map = new HashMap<>();
        int left = 0;
        int max = 0;

        for (int right = 0; right < fruits.length; right++) {
            map.put(fruits[right], map.getOrDefault(fruits[right], 0) + 1);

            while (map.size() > 2) {
                int leftFruit = fruits[left];
                int count = map.get(leftFruit);
                if (count == 1) {
                    map.remove(leftFruit);
                } else {
                    map.put(leftFruit, count - 1);
                }
                left++;
            }

            max = Math.max(max, right - left + 1);
        }

        return max;
    }
}
