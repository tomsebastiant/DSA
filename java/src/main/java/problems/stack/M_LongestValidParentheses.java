package problems.stack;

/**
 * LC: 32
 * Tags: String
 * Tags: Stack
 * Tags: DynamicProgramming
 * https://leetcode.com/problems/longest-valid-parentheses/
 * Given a string containing just the characters '(' and ')', return the length of the longest
 * valid (well-formed) parentheses substring.
 *
 * Constraints:
 * 0 <= s.length <= 3 * 10^4
 * s[i] is '(' or ')'
 *
 * Example 1:
 *
 * Input: s = "(()"
 * Output: 2
 * Explanation: The longest valid parentheses substring is "()".
 *
 * Example 2:
 *
 * Input: s = ")()())"
 * Output: 4
 * Explanation: The longest valid parentheses substring is "()()".
 *
 * Example 3:
 *
 * Input: s = ""
 * Output: 0
 *
 * NOTE: Filename prefix is M_ but this is a Hard problem on LeetCode.
 *
 * Approach: Seed the stack with sentinel index -1 so the base of any valid substring is always
 * available via stack.peek(). Push '(' indices; on ')' pop the top — if the stack is then empty
 * there is no anchor, so push the current index as the new sentinel. Otherwise the distance from
 * the current index to the new top gives the length of the valid substring ending here.
 */
import java.util.ArrayDeque;
import java.util.Deque;

public class M_LongestValidParentheses {
        public int longestValidParentheses(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        int max=0;
        stack.push(-1); // sentinel: base index before the string starts
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(c=='('){
                stack.push(i);
            } else {
                stack.pop(); // consume the matching '(' (or the sentinel)
                if(stack.isEmpty()){
                    stack.push(i); // unmatched ')' becomes the new sentinel
                } else {
                    max=Math.max(max,i-stack.peek()); // distance to last unmatched index
                }
            }
        }
        return max;
    }
}
