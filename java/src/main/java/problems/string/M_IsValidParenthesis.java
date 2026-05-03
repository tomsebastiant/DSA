package problems.string;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * LC: 20
 * https://leetcode.com/problems/valid-parentheses/
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * An input string is valid if:
 * - Open brackets must be closed by the same type of brackets.
 * - Open brackets must be closed in the correct order.
 * - Every closing bracket has a corresponding opening bracket of the same type.
 *
 * Example 1:
 *
 * Input: s = "()"
 * Output: true
 *
 * Example 2:
 *
 * Input: s = "()[]{}"
 * Output: true
 *
 * Example 3:
 *
 * Input: s = "(]"
 * Output: false
 *
 * Example 4:
 *
 * Input: s = "([)]"
 * Output: false
 *
 * Approach: Use a stack to track opening brackets. For every closing bracket,
 * check that the top of the stack contains the matching opening bracket.
 * Tags: String
 * Tags: Stack
 */
public class M_IsValidParenthesis {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
                continue;
            }
            if (stack.isEmpty()) {
                return false;
            }
            if (c == ')' && stack.peek() != '(') {
                return false;
            }
            if (c == ']' && stack.peek() != '[') {
                return false;
            }
            if (c == '}' && stack.peek() != '{') {
                return false;
            }
            stack.pop();
        }
        if (!stack.isEmpty()) {
            return false;
        }
        return true;
    }
}
