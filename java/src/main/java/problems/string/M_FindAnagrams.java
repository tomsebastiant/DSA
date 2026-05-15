package problems.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LC: 438
 * Tags: String
 * Tags: SlidingWindow
 * Tags: HashTable
 * https://leetcode.com/problems/find-all-anagrams-in-a-string/
 * Given two strings s and p, return an array of all the start indices of p's anagrams in s.
 * You may return the answer in any order. An anagram is a string that contains the same
 * characters, only the order of characters can be different.
 *
 * Example 1:
 *
 * Input: s = "cbaebabacd", p = "abc"
 * Output: [0,6]
 * Explanation: The substring at index 0 is "cba" and at index 6 is "bac", both anagrams of "abc".
 *
 * Example 2:
 *
 * Input: s = "abab", p = "ab"
 * Output: [0,1,2]
 *
 * Approach: Use a fixed-size sliding window of length p.length(). Maintain two 26-element
 * frequency arrays — one for p and one for the current window. Slide one character at a time,
 * adding the incoming character and removing the outgoing one, then compare arrays to detect
 * anagrams in O(1) per step.
 */
public class M_FindAnagrams {
        public List<Integer> findAnagrams(String s, String p) {
        int[] pFreq = new int[26];
        int[] wFreq = new int[26];
        int plen = p.length();
        List<Integer> result = new ArrayList<>();
        if(plen>s.length()) return result;        

        for(int i=0;i<p.length();i++){
            pFreq[p.charAt(i)-'a']++;
            wFreq[s.charAt(i)-'a']++;
        }


        if(Arrays.equals(pFreq,wFreq)) result.add(0);

        for(int i=plen;i<s.length();i++){
            wFreq[s.charAt(i)-'a']++;
            wFreq[s.charAt(i-plen)-'a']--;

            if(Arrays.equals(pFreq,wFreq)){
                result.add(i-plen+1);
            }
        }
        return result;
    }
}
