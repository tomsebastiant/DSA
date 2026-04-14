package leetcode.string;

/**
 Tags: Greedy
 https://leetcode.com/problems/is-subsequence
 Given two strings s and t, return true if s is a subsequence of t,
 or false otherwise.

 A subsequence of a string is a new string that is formed from the original
 string by deleting some (can be none) of the characters without disturbing
 the relative positions of the remaining characters. (i.e., "ace" is a
 subsequence of "abcde" while "aec" is not).

 Example 1:

 Input: s = "abc", t = "ahbgdc"
 Output: true
 Example 2:

 Input: s = "axc", t = "ahbgdc"
 Output: false



 Approach:
 Use 2 pointers to traverse s and t. If we find same char, increment both.
 Or increment only tPointer. If sPointer reached the end, return true
 */

public class E_392_IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        int sPointer =0;
        int tPointer =0;
        while(sPointer<s.length() && tPointer<t.length()){
            if(s.charAt(sPointer)==t.charAt(tPointer)){
                sPointer++;
                tPointer++;
            } else {
                tPointer++;
            }
        }
        return sPointer==s.length();
    }
}
