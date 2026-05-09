package problems.string;

import java.util.HashMap;
import java.util.Map;

/**
 * LC: 76
 * Tags: String
 * Tags: SlidingWindow
 * Tags: HashTable
 * https://leetcode.com/problems/minimum-window-substring/
 * Given two strings s and t of lengths m and n, return the minimum window substring of s such
 * that every character in t (including duplicates) is included in the window. If there is no
 * such substring, return the empty string "".
 *
 * The test cases are generated such that the answer is unique.
 *
 * Example 1:
 *
 * Input: s = "ADOBECODEBANC", t = "ABC"
 * Output: "BANC"
 * Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
 *
 * Example 2:
 *
 * Input: s = "a", t = "a"
 * Output: "a"
 *
 * Example 3:
 *
 * Input: s = "a", t = "aa"
 * Output: ""
 * Explanation: Both 'a's from t must be included. The largest window of s only has one 'a'.
 *
 * Constraints:
 * m == s.length
 * n == t.length
 * 1 <= m, n <= 10^5
 * s and t consist of uppercase and lowercase English letters.
 *
 * Approach: Build a frequency map of t and track how many distinct character types still need
 * to be satisfied (required). Expand the right pointer, decrementing each char's count in the
 * map — when a count hits exactly 0 that char type is fully covered and required decreases.
 * Once required == 0 the window is valid; shrink from the left to minimise it, incrementing
 * counts back — when a count rises back to 1 the char is no longer covered and required increases.
 * The map is allowed to go negative for surplus characters; only the 0-boundary matters.
 */
public class H_MinWindowSubstring {
        public String minWindow(String s, String t) {
        Map<Character,Integer> fMap = new HashMap<>();
        for(char c:t.toCharArray()){
            fMap.put(c,fMap.getOrDefault(c,0)+1);
        }
        // Counts distinct char types still needed, not total characters.
        int required=fMap.size();
        int l=0;
        int r=0;
        int min=Integer.MAX_VALUE;
        String result="";
        while(r<s.length()){
            if(fMap.containsKey(s.charAt(r))){
                int newVal=fMap.get(s.charAt(r))-1;
                // Exactly 0 means this char type's demand is just met — surplus goes negative, ignored.
                if(newVal==0){
                    required--;
                }
                fMap.put(s.charAt(r),newVal);
            }
            while(l<=r && required==0){
                if(r-l+1<min){
                    min=r-l+1;
                    result=s.substring(l,r+1);
                }
                if(fMap.containsKey(s.charAt(l))){
                    int newVal=fMap.get(s.charAt(l))+1;
                    // Rising back to 1 means we've lost the last copy of this char — window invalid.
                    if(newVal==1){
                        required++;
                    }
                    fMap.put(s.charAt(l),newVal);
                }
                l++;
            }
            r++;
        }
        return result;
    }
}
