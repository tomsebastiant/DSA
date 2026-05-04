package problems.dynamicprogramming;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * LC: 139
 * https://leetcode.com/problems/word-break/
 * Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated
 * sequence of one or more dictionary words.
 *
 * The same word in the dictionary may be reused multiple times in the segmentation.
 *
 * Example 1:
 *
 * Input: s = "leetcode", wordDict = ["leet","code"]
 * Output: true
 *
 * Example 2:
 *
 * Input: s = "applepenapple", wordDict = ["apple","pen"]
 * Output: true
 *
 * Example 3:
 *
 * Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
 * Output: false
 *
 * Approach: Bottom-up dynamic programming.
 * dp[i] tells us whether the prefix s[0..i-1] can be segmented using the dictionary.
 * For each position i, try every split point j before it and check whether the left side is already valid
 * and the right side is a dictionary word.
 * Tags: String
 * Tags: DynamicProgramming
 * Tags: HashSet
 */
public class M_WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>();
        // Store the dictionary in a hash set for O(1) average lookup.
        for (String word : wordDict) {
            set.add(word);
        }

        boolean[] result = new boolean[s.length() + 1];
        // Empty prefix is always segmentable.
        result[0] = true;

        for (int i = 1; i < s.length() + 1; i++) {
            // Try every possible previous cut position.
            for (int j = 0; j < i; j++) {
                // If the prefix up to j is valid and s[j..i) is a dictionary word,
                // then prefix up to i is also valid.
                if (result[j] && set.contains(s.substring(j, i))) {
                    result[i] = true;
                    break;
                }
            }
        }
        return result[s.length()];
    }
}
