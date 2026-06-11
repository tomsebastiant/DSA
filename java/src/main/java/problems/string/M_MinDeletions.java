package problems.string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * LC: 1647
 * Tags: String
 * Tags: HashTable
 * Tags: Greedy
 * https://leetcode.com/problems/minimum-deletions-to-make-character-frequencies-unique/
 * A string s is called good if there are no two different characters in s that have the same
 * frequency. Given a string s, return the minimum number of characters you need to delete to
 * make s good.
 *
 * Constraints:
 * 1 <= s.length <= 10^5
 * s contains only lowercase English letters.
 *
 * Example 1:
 *
 * Input: s = "aab"
 * Output: 0
 * Explanation: 'a' appears 2 times, 'b' 1 time — all frequencies already unique.
 *
 * Example 2:
 *
 * Input: s = "aaabbbcc"
 * Output: 2
 * Explanation: Frequencies: a=3, b=3, c=2. Delete one 'b' (b→2) and one 'c' (c→1) → [3,2,1].
 *
 * Example 3:
 *
 * Input: s = "ceabaacb"
 * Output: 2
 * Explanation: Frequencies sorted: [3,2,2,1]. Second 2 conflicts: decrement to 1, but 1 is taken
 * too, decrement to 0 — 2 total deletions.
 *
 * Approach: Sort character frequencies descending so higher counts get first pick of each slot.
 * For each frequency, repeatedly decrement (each step = one deletion) until reaching an unclaimed
 * value or 0; track claimed values in a HashSet to detect collisions in O(1).
 */
public class M_MinDeletions {
        public int minDeletions(String s) {
        int[] freq = new int[26];
        for (char c : s.toCharArray())
            freq[c - 'a']++;

        List<Integer> freqs = new ArrayList<>();
        for (int f : freq)
            if (f > 0) freqs.add(f);

        Collections.sort(freqs, Collections.reverseOrder());

        Set<Integer> seen = new HashSet<>();
        int deletions = 0;

        for (int f : freqs) {
            while (f > 0 && seen.contains(f)) {
                f--;
                deletions++;
            }
            if (f > 0) seen.add(f);
        }

        return deletions;        
    }
}
