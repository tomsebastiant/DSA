package problems.dynamicprogramming;

/**
 * LC: 647
 * Tags: String
 * https://leetcode.com/problems/palindromic-substrings/
 * Given a string s, return the number of palindromic substrings in it. A string is a palindrome
 * when it reads the same backward as forward. A substring is a contiguous sequence of characters.
 *
 * Constraints:
 * 1 <= s.length <= 1000
 * s consists of lowercase English letters.
 *
 * Example 1:
 *
 * Input: s = "abc"
 * Output: 3
 * Explanation: Palindromic substrings: "a", "b", "c"
 *
 * Example 2:
 *
 * Input: s = "aaa"
 * Output: 6
 * Explanation: Palindromic substrings: "a"(×3), "aa"(×2), "aaa"(×1)
 *
 * Approach: Expand around center — for each index i, expand odd-length palindromes from (i,i)
 * and even-length from gap (i,i+1). Each step that satisfies s[l]==s[r] is one more palindrome;
 * accumulate the count across all centers. O(n^2) time, O(1) space.
 *
 * NOTE: Same expand-around-center technique as M_LongestPalindrome (LC 5) — counts every
 * palindrome found rather than tracking the longest. File is in dynamicprogramming/ but does
 * not use a DP table; a 2D boolean DP alternative exists at O(n^2) time and space.
 */
public class M_CountPalindrome {
        public int countSubstrings(String s) {
        int count=0;

        for(int i=0;i<s.length();i++){
            count=count+countPalindrome(s,i,i)+countPalindrome(s,i,i+1);
        }
        return count;
    }

    public int countPalindrome(String s,int l, int r){
        int count=0;
        while(l>=0 && r<s.length() && s.charAt(l)==s.charAt(r)){
            count++;
            l--;
            r++;
        }
        return count;
    }

    // -------------------------------------------------------------------------
    // DP alternative — O(n^2) time, O(n^2) space
    //
    // Identical recurrence to M_LongestPalindrome (LC 5):
    //   dp[i][j] = true if s[i..j] is a palindrome.
    //   dp[i][i]   = true                          (single char)
    //   dp[i][i+1] = s[i] == s[i+1]               (pair)
    //   dp[i][j]   = s[i] == s[j] && dp[i+1][j-1] (longer)
    //
    // Difference from LC 5: instead of tracking the longest, increment count
    // every time dp[i][j] is set to true.
    //
    // Must fill by increasing substring length — dp[i][j] depends on
    // dp[i+1][j-1], which is shorter, so it must already be resolved.
    // -------------------------------------------------------------------------
    /*
    public int countSubstringsDP(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int count = 0;

        // base case: every single character is a palindrome
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
            count++;
        }

        // base case: adjacent pairs — dp[i+1][i] would be out of bounds so handle separately
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true;
                count++;
            }
        }

        // fill by increasing length (len=3 upward); dp[i+1][j-1] always resolved first
        for (int len = 3; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]) {
                    dp[i][j] = true;
                    count++;
                }
            }
        }

        return count;
    }
    */
}
