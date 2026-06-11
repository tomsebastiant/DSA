package problems.string;

/**
 * LC: 2384
 * Tags: String
 * Tags: HashTable
 * Tags: Greedy
 * https://leetcode.com/problems/largest-palindromic-number/
 * You are given a string num consisting of digits only. Return the largest palindromic integer
 * (in the form of a string) that can be formed using digits taken from num. It should not
 * contain leading zeroes. Use at least one digit. Digits can be reused and reordered.
 *
 * Constraints:
 * 1 <= num.length <= 10^5
 * num consists of digits only.
 *
 * Example 1:
 *
 * Input: num = "444947137"
 * Output: "7449447"
 * Explanation: Use digits 4,4,4,4,9,7,7 → place pairs 7,4,4 in first half, 9 in center → "7449447".
 *
 * Example 2:
 *
 * Input: num = "00009"
 * Output: "9"
 * Explanation: No non-zero digit has a pair, so the palindrome is just the center digit "9".
 *
 * Approach: Count digit frequencies in a 10-slot array. Greedily iterate 9→0, appending
 * floor(freq/2) copies of each digit to the first half so larger digits sit closer to the outside.
 * Track the largest odd-frequency digit as the center. A guard at i=0 prevents leading zeros:
 * if no pairs have been placed yet, adding zero pairs would produce an invalid number, so we
 * break early and return only the center (or "0" if none).
 */
public class M_LargestPalindromeNumber {
            public String largestPalindromic(String num) {
        int[] freq = new int[10];
        for (char c : num.toCharArray())
            freq[c - '0']++;

        StringBuilder sb = new StringBuilder();
        String middle = "";

        for (int i = 9; i >= 0; i--) {
            // adding zero pairs when the half is still empty would create a leading-zero number
            if (i == 0 && sb.length() == 0) {
                if (middle.isEmpty()) middle = "0";  // all digits were 0 → return "0"
                break;
            }

            int pairs = freq[i] / 2;
            for (int j = 0; j < pairs; j++)
                sb.append((char)('0' + i));

            // keep only the largest odd-frequency digit for the center
            if (freq[i] % 2 != 0 && middle.isEmpty())
                middle = "" + (char)('0' + i);
        }

        String firstHalf = sb.toString();
        return firstHalf + middle + sb.reverse().toString();
    }
}
