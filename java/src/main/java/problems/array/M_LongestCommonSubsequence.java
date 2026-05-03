package problems.array;

/**
 * LC: 1143
 * https://leetcode.com/problems/longest-common-subsequence/
 * Given two strings text1 and text2, return the length of their longest common subsequence.
 * If there is no common subsequence, return 0.
 *
 * Example 1:
 *
 * Input: text1 = "abcde", text2 = "ace"
 * Output: 3
 * Explanation: The longest common subsequence is "ace" and its length is 3.
 *
 * Example 2:
 *
 * Input: text1 = "abc", text2 = "abc"
 * Output: 3
 * Explanation: The longest common subsequence is "abc".
 *
 * Example 3:
 *
 * Input: text1 = "abc", text2 = "def"
 * Output: 0
 * Explanation: There is no common subsequence.
 *
 * Approach: Use dynamic programming where dp[i][j] stores the LCS length for the first i
 * characters of text1 and the first j characters of text2.
 * If the current characters match, extend the previous diagonal result.
 * Otherwise, carry forward the best result from skipping one character from either string.
 *
 * Tags: String
 * Tags: DynamicProgramming
 */
public class M_LongestCommonSubsequence {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    // Matching characters extend the subsequence found without both characters.
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    // Otherwise, drop one character from either string and keep the better answer.
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }
}
