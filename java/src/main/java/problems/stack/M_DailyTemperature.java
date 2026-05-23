package problems.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * LC: 739
 * Tags: Array
 * Tags: Stack
 * https://leetcode.com/problems/daily-temperatures/
 * Given an array of integers temperatures representing daily temperatures, return an array answer
 * such that answer[i] is the number of days you have to wait after the ith day to get a warmer
 * temperature. If there is no future day with a warmer temperature, keep answer[i] == 0.
 *
 * Example 1:
 *
 * Input: temperatures = [73,74,75,71,69,72,76,73]
 * Output: [1,1,4,2,1,1,0,0]
 *
 * Example 2:
 *
 * Input: temperatures = [30,40,50,60]
 * Output: [1,1,1,0]
 *
 * Example 3:
 *
 * Input: temperatures = [30,60,90]
 * Output: [1,1,0]
 *
 * Approach: Monotonic decreasing stack of indices. For each day, pop all indices whose recorded
 * temperature is lower than today's and record the gap (i - idx) as their wait. Push the current
 * index. Indices remaining in the stack at the end never see a warmer day and stay 0.
 */
public class M_DailyTemperature {
        public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> stack = new ArrayDeque<>();
        int[] result = new int[temperatures.length];

        for(int i=0;i<temperatures.length;i++){
            while(!stack.isEmpty() && temperatures[i]>temperatures[stack.peek()]){
                int idx=stack.pop();
                result[idx]=i-idx;
            }
            stack.push(i);
        }
        return result;
    }
}
