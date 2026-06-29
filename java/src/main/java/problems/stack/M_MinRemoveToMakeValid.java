/**
 * LC: 1249
 * Tags: String
 * Tags: Stack
 * https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/
 * Given a string s of '(' , ')' and lowercase English characters, remove the minimum number of
 * parentheses so that the resulting parentheses string is valid and return any valid string.
 * A string is valid if: it is empty, contains only lowercase characters, can be written as AB
 * where A and B are valid strings, or can be written as (A) where A is a valid string.
 *
 * Constraints:
 * 1 <= s.length <= 10^5
 * s consists of '(' , ')' and lowercase English letters
 *
 * Example 1:
 *
 * Input: s = "lee(t(c)o)de)"
 * Output: "lee(t(c)o)de"
 * Explanation: "lee(t(co)de)" and "lee(t(c)ode)" are also valid answers.
 *
 * Example 2:
 *
 * Input: s = "a)b(c)d"
 * Output: "ab(c)d"
 *
 * Example 3:
 *
 * Input: s = "))(("
 * Output: ""
 * Explanation: An empty string is also valid.
 *
 * Approach: Push indices of '(' onto a stack; when a matching ')' is found pop the stack, otherwise
 * mark the ')' index for removal. After the scan, any indices still on the stack are unmatched '('
 * and are also marked. Rebuild the string skipping all marked indices.
 */
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public class M_MinRemoveToMakeValid {
        public String minRemoveToMakeValid(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(c!=')' && c!='('){
                continue;
            }
            if(c=='('){
                stack.push(i);
            } else if (c == ')'){
                if(!stack.isEmpty()){
                    stack.pop();
                } else {
                    set.add(i);
                }
            }
        }
        while(!stack.isEmpty()){
            set.add(stack.pop());
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length();i++){
            if(!set.contains(i)) sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}
