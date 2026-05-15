package problems.dynamicprogramming;

/**
 * LC: 70
 * Tags: DynamicProgramming
 * https://leetcode.com/problems/climbing-stairs/
 * You are climbing a staircase. It takes n steps to reach the top. Each time you can either
 * climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 *
 * Example 1:
 *
 * Input: n = 2
 * Output: 2
 * Explanation: Two ways: (1+1) or (2).
 *
 * Example 2:
 *
 * Input: n = 3
 * Output: 3
 * Explanation: Three ways: (1+1+1), (1+2), (2+1).
 *
 * Approach: The number of ways to reach step n equals ways(n-1) + ways(n-2) — the Fibonacci
 * recurrence. Track only the two previous values instead of a full array, giving O(n) time
 * and O(1) space.
 */
public class E_ClimbStairs {
        public int climbStairs(int n) {
        if(n<=2) return n;
        int prev1 = 2;
        int prev2 =1;

        for(int i=2;i<n;i++){
            int curr = prev1+prev2;
            prev2=prev1;
            prev1=curr;
        }

        return prev1;
        
    }
}
