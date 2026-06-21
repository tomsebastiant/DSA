package problems.slidingwindow;

/**
 * LC: 424
 * Tags: SlidingWindow
 * Tags: String
 * https://leetcode.com/problems/longest-repeating-character-replacement/
 * You are given a string s and an integer k. You can choose any character of the string and
 * change it to any other uppercase English character. You can perform this operation at most
 * k times. Return the length of the longest substring containing the same letter you can get
 * after performing the above operations.
 *
 * Constraints:
 * 1 <= s.length <= 10^5
 * s consists of only uppercase English letters.
 * 0 <= k <= s.length
 *
 * Example 1:
 *
 * Input: s = "ABAB", k = 2
 * Output: 4
 * Explanation: Replace the two 'A's with 'B's (or vice versa) to get "BBBB" or "AAAA".
 *
 * Example 2:
 *
 * Input: s = "AABABBA", k = 1
 * Output: 4
 * Explanation: Replace the one 'A' in "AABA" to get "AAAA", or the one 'A' in "ABBB" to get
 * "BBBB" — both give length 4.
 *
 * Approach: Sliding window where validity is (window_size - maxFreq) <= k — the number of
 * characters that must be replaced equals the window size minus the count of the most frequent
 * character. maxFreq is never decremented when the window shrinks: we only care about windows
 * strictly larger than the current best, so a stale (over-estimated) maxFreq merely prevents
 * the window from shrinking below the best size already found, never producing a wrong answer.
 */
public class M_LongestRepeatCharReplace {
        public int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        int r=0;
        int l=0;
        int maxFreq=0;
        int result=0;

        for(;r<s.length();r++){
            freq[s.charAt(r)-'A']++;
            maxFreq = Math.max(maxFreq,freq[s.charAt(r)-'A']);

            // replacements needed = window_size - count_of_dominant_char; shrink if over budget
            while((r-l+1)-maxFreq >k){
                freq[s.charAt(l)-'A']--;
                l++;
                // maxFreq is intentionally NOT updated here — we only want to grow beyond the
                // current best, so keeping maxFreq at its peak prevents pointless shrinking
            }
            result = Math.max(result,r-l+1);
        }
        return result;
    }
}
