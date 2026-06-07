package problems.dynamicprogramming;

/**
 * LC: 5
 * Tags: String
 * https://leetcode.com/problems/longest-palindromic-substring/
 * Given a string s, return the longest palindromic substring in s. A palindrome reads the same
 * forwards and backwards. If there are multiple answers of equal length, return any one of them.
 *
 * Constraints:
 * 1 <= s.length <= 1000
 * s consists of only digits and English letters.
 *
 * Example 1:
 *
 * Input: s = "babad"
 * Output: "bab"
 * Explanation: "aba" is also a valid answer.
 *
 * Example 2:
 *
 * Input: s = "cbbd"
 * Output: "bb"
 *
 * Approach: Expand around center — for each index i, try two expansions: odd-length (center at i)
 * and even-length (center between i and i+1). Track the longest length seen and recompute the
 * start index as i - (max-1)/2, which works for both parities. O(n^2) time, O(1) space.
 *
 * NOTE: This file is in the dynamicprogramming/ folder but uses expand-around-center, not a DP
 * table. The DP approach (2D boolean table, O(n^2) time and space) is a valid alternative.
 */
public class M_LongestPalindrome {
        public String longestPalindrome(String s) {
        int start =0;
        int max =0;

        for(int i=0;i<s.length();i++){
            int len1=expand(s,i,i);
            int len2=expand(s,i,i+1);
            
            int len = Math.max(len1,len2);

            if(len>max){
                max=len;
                start = i-(max-1)/2;
            }
        }
        return s.substring(start,start+max);
    }

    public int expand(String s,int l,int r){
        while(l>=0 && r<s.length() && s.charAt(l)==s.charAt(r)){
            l--;
            r++;
        }
        return r-l-1;
    }

    // -------------------------------------------------------------------------
    // DP alternative — O(n^2) time, O(n^2) space
    //
    // dp[i][j] = true if s[i..j] is a palindrome.
    //
    // Recurrence:
    //   dp[i][i]   = true                          (single char)
    //   dp[i][i+1] = s[i] == s[i+1]               (pair)
    //   dp[i][j]   = s[i] == s[j] && dp[i+1][j-1] (longer: outer chars match AND inner is palindrome)
    //
    // Must fill by increasing substring length, not by index, because dp[i][j]
    // depends on dp[i+1][j-1] which is a strictly shorter substring.
    // -------------------------------------------------------------------------
    /*
    public String longestPalindromeDP(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int start = 0, maxLen = 1;

        // base case: every single character is a palindrome
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }

        // base case: adjacent pairs
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true;
                start = i;
                maxLen = 2;
            }
        }

        // fill by increasing length (len=3 upward)
        // dp[i+1][j-1] is always filled before dp[i][j] because it is shorter
        for (int len = 3; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]) {
                    dp[i][j] = true;
                    if (len > maxLen) {
                        start = i;
                        maxLen = len;
                    }
                }
            }
        }

        return s.substring(start, start + maxLen);
    }
    */
}
