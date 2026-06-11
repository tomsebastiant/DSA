package problems.string;

/**
 * LC: 409
 * Tags: String
 * Tags: HashTable
 * Tags: Greedy
 * https://leetcode.com/problems/longest-palindrome/
 * Given a string s which consists of lowercase or uppercase letters, return the length of the
 * longest palindrome that can be built with those letters. Letters are case-sensitive, so "Aa"
 * is not a palindrome.
 *
 * Constraints:
 * 1 <= s.length <= 2000
 * s consists of lowercase and/or uppercase English letters only.
 *
 * Example 1:
 *
 * Input: s = "abccccdd"
 * Output: 7
 * Explanation: One longest palindrome that can be built is "dccaccd", whose length is 7.
 *
 * Example 2:
 *
 * Input: s = "a"
 * Output: 1
 * Explanation: The longest palindrome is "a" itself.
 *
 * Approach: Count character frequencies in a 52-slot array (a-z at 0–25, A-Z at 26–51). Every
 * character contributes floor(freq/2) pairs, each filling one slot on each side of the palindrome.
 * If any character has an odd frequency, one instance can sit at the center, adding 1 to the total.
 */
public class E_LongestPalindrome {
        public int longestPalindrome(String s) {
        int[] freq = new int[52];
        for (char c : s.toCharArray()) {
            if (Character.isLowerCase(c))
                freq[c - 'a']++;
            else
                freq[c - 'A' + 26]++;
        }

        int pairs = 0;
        boolean hasOdd = false;

        for (int f : freq) {
            pairs += f / 2;
            if (f % 2 != 0) hasOdd = true;
        }

        return pairs * 2 + (hasOdd ? 1 : 0);        
    }
}
