package problems.string;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * LC: 394
 * Tags: String
 * Tags: Stack
 * https://leetcode.com/problems/decode-string/
 * Given an encoded string, return its decoded string. The encoding rule is k[encoded_string],
 * where the encoded_string inside the square brackets is repeated exactly k times. Note that k
 * is guaranteed to be a positive integer.
 *
 * You may assume the input is always valid; there are no extra white spaces, square brackets are
 * well-formed, etc. The original data does not contain any digits — all digits are repeat counts.
 * The length of the output will never exceed 10^5.
 *
 * Example 1:
 *
 * Input: s = "3[a]2[bc]"
 * Output: "aaabcbc"
 *
 * Example 2:
 *
 * Input: s = "3[a2[c]]"
 * Output: "accaccacc"
 *
 * Example 3:
 *
 * Input: s = "2[abc]3[cd]ef"
 * Output: "abcabccdcdcdef"
 *
 * Constraints:
 * 1 <= s.length <= 30
 * s consists of lowercase English letters, digits, and square brackets '[]'.
 * All integers in s are in the range [1, 300].
 *
 * Approach: Two stacks — one for repeat counts and one for the string built so far. On '[', push
 * the current count and current string onto their stacks and start fresh. On ']', pop the count
 * and the outer string, repeat the inner string that many times, and append it to the outer.
 * Nesting is handled naturally because each '[' saves the enclosing context before starting a new one.
 */
public class M_DecodeString {
        public String decodeString(String s) {
        Deque<Integer> countStack = new ArrayDeque();
        Deque<StringBuilder> strStack = new ArrayDeque<>();
        StringBuilder curr = new StringBuilder();
        int k=0;
        for(char c:s.toCharArray()){
            if(c>='0' && c<='9'){
                // Accumulate multi-digit numbers (e.g. "12[a]" → k=1 then k=12).
                k=k*10+(c-'0');
            } else if (c=='['){
                // Save the outer context before starting the inner encoded segment.
                countStack.push(k);
                strStack.push(curr);
                curr = new StringBuilder();
                k=0;
            } else if(c==']'){
                // Restore outer string and append the inner segment repeated times times.
                int times = countStack.pop();
                StringBuilder prev = strStack.pop();
                for(int i=0;i<times;i++) prev.append(curr);
                curr = prev;
            } else {
                curr.append(c);
            }
        }
        return curr.toString();

    }
}
