package problems.string;

/**
 * LC: 1328
 * Tags: String
 * Tags: Greedy
 * https://leetcode.com/problems/break-a-palindrome/
 * Given a palindromic string palindrome of lowercase English letters, replace exactly one
 * character with any lowercase English letter so that the resulting string is not a palindrome
 * and is the lexicographically smallest one possible. Return the resulting string. If there is
 * no way to replace a character to make it not a palindrome, return an empty string.
 *
 * Constraints:
 * 1 <= palindrome.length <= 1000
 * palindrome consists of only lowercase English letters.
 *
 * Example 1:
 *
 * Input: palindrome = "abccba"
 * Output: "aaccba"
 * Explanation: Change 'b' at index 1 to 'a' — first non-'a' in the first half, breaks symmetry.
 *
 * Example 2:
 *
 * Input: palindrome = "a"
 * Output: ""
 * Explanation: A single-character string cannot be made non-palindromic by any replacement.
 *
 * Example 3:
 *
 * Input: palindrome = "aaaaa"
 * Output: "aaaab"
 * Explanation: All first-half characters are 'a'; no character can be lowered, so change the
 * last character to 'b'.
 *
 * Approach: Scan only the first half — the second half mirrors the first, so changing it
 * duplicates a first-half edit without improving lexicographic order. Replace the first non-'a'
 * character with 'a' to get the smallest possible result. If the entire first half is 'a'
 * (nothing can be lowered), change the last character to 'b' as the only valid move.
 */
public class M_BreakPalindrome {
    public String breakPalindrome(String palindrome) {
        int n = palindrome.length();
        if (n == 1) return "";

        char[] arr = palindrome.toCharArray();

        for (int i = 0; i < n / 2; i++) {
            if (arr[i] != 'a') {
                arr[i] = 'a';
                return new String(arr);
            }
        }

        arr[n - 1] = 'b';
        return new String(arr);
    }
}
