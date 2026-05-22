package problems.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * LC: 150
 * Tags: Array
 * Tags: Stack
 * https://leetcode.com/problems/evaluate-reverse-polish-notation/
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation. Valid operators are
 * +, -, *, and /. Each operand may be an integer or another expression. Division between two
 * integers truncates toward zero. The input is guaranteed to represent a valid RPN expression
 * and the answer fits in a 32-bit integer.
 *
 * Example 1:
 *
 * Input: tokens = ["2","1","+","3","*"]
 * Output: 9
 * Explanation: ((2 + 1) * 3) = 9
 *
 * Example 2:
 *
 * Input: tokens = ["4","13","5","/","+"]
 * Output: 6
 * Explanation: (4 + (13 / 5)) = 6
 *
 * Example 3:
 *
 * Input: tokens = ["10","6","9","3","+","-11","*","\/","*","17","+","5","+"]
 * Output: 22
 *
 * Approach: Use a stack. Push operands as integers. On each operator, pop the top two values,
 * apply the operation (noting that the second-popped value is the left operand), and push the
 * result. The final stack element is the answer.
 */
public class M_ReversePolishNotation {
        public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        for(String token:tokens){
            if(token.equals("+")){
                int a = stack.pop();
                int b = stack.pop();
                stack.push(a+b);
            } else if(token.equals("-")){
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b-a);
            } else if(token.equals("*")){
                int a = stack.pop();
                int b = stack.pop();
                stack.push(a*b);
            } else if(token.equals("/")){
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b/a);
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }
}

