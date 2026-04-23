package problems.string;

import java.util.HashSet;
import java.util.Set;

/**
 * LC: 3
 * https://leetcode.com/problems/longest-substring-without-repeating-characters
 * Given a string s, find the length of the longest substring without repeating characters.
 *
 * A substring is a contiguous non-empty sequence of characters within a string.
 *
 * Example 1:
 *
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 *
 * Example 2:
 *
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 *
 * Approach: Use a sliding window with a HashSet. Expand the window with the right pointer,
 * and shrink from the left until the window contains only unique characters.
 * Tags: String
 * Tags: SlidingWindow
 * Tags: HashSet
 */
public class M_lengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        if(s ==null || s.length()==0){
            return 0;
        }
        int max =0;
        int left=0;
        Set<Character> set = new HashSet<>();
        for(int right=0;right<s.length();right++){
            Character c = s.charAt(right);
            if(set.contains(c)){
                while(set.contains(c)){
                    set.remove(s.charAt(left));
                    left++;
                }
            }
            set.add(c);
            max = Math.max(max,right-left+1);
        }
        return max;
    }
}
