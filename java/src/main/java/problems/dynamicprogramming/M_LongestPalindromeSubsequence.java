package problems.dynamicprogramming;

/**
 * LC: 516
 * Tags: DynamicProgramming
 * Tags: String
 * https://leetcode.com/problems/longest-palindromic-subsequence/
 * Given a string s, return the length of the longest palindromic subsequence in it. A subsequence
 * is derived by deleting some (or no) characters without changing the relative order of the rest.
 *
 * Constraints:
 * 1 <= s.length <= 1000
 * s consists only of lowercase English letters.
 *
 * Example 1:
 *
 * Input: s = "bbbab"
 * Output: 4
 * Explanation: "bbbb" is the longest palindromic subsequence (skip the 'a').
 *
 * Example 2:
 *
 * Input: s = "cbbd"
 * Output: 2
 * Explanation: "bb" is the longest palindromic subsequence.
 *
 * Approach: Interval DP — dp[i][j] is the length of the longest palindromic subsequence in
 * s[i..j]. Fill by increasing window length so dp[i+1][j-1] is always resolved first.
 * Recurrence:
 *   s[i] == s[j] → dp[i][j] = dp[i+1][j-1] + 2  (both outer chars extend the inner result)
 *   s[i] != s[j] → dp[i][j] = max(dp[i+1][j], dp[i][j-1])  (skip one end, take the better)
 * Base case: dp[i][i] = 1 (every single character is a palindrome of length 1). When len=2
 * and s[i]==s[j], dp[i+1][j-1] is an empty range and is 0 by Java array initialisation → 0+2=2.
 *
 * Contrast with LC 5 / LC 647: those use a boolean dp table for palindromic substrings
 * (contiguous). Here the subsequence allows gaps, so the recurrence carries lengths, not booleans.
 * Alternatively, LPS(s) = LCS(s, reverse(s)), but interval DP avoids creating the reversed string.
 */
public class M_LongestPalindromeSubsequence {
        public int longestPalindromeSubseq(String s) {
        int n= s.length();
        int[][] dp = new int[n][n];
        for(int i=0;i<n;i++){
            dp[i][i]=1;
        } 
        for(int len=2;len<=n;len++){
            for(int i=0;i<=n-len;i++){
                int j=i+len-1;
                if(s.charAt(i)==s.charAt(j)){
                    dp[i][j]=dp[i+1][j-1]+2;
                } else {
                    dp[i][j]=Math.max(dp[i+1][j],dp[i][j-1]);
                }
            }
        }
        return dp[0][n-1];
    }
}
