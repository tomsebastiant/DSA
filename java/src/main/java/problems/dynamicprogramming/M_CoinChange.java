package problems.dynamicprogramming;

import java.util.Arrays;

/**
 * LC: 322
 * https://leetcode.com/problems/coin-change/
 * Given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money,
 * return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination
 * of the coins, return -1.
 *
 * You may assume that you have an infinite number of each kind of coin.
 *
 * Example 1:
 *
 * Input: coins = [1,2,5], amount = 11
 * Output: 3
 * Explanation: 11 = 5 + 5 + 1
 *
 * Example 2:
 *
 * Input: coins = [2], amount = 3
 * Output: -1
 *
 * Example 3:
 *
 * Input: coins = [1], amount = 0
 * Output: 0
 *
 * Approach: Bottom-up dynamic programming.
 * Let dp[i] be the minimum number of coins needed to make amount i.
 * Try every coin for each amount and reuse previously solved subproblems.
 * Tags: DynamicProgramming
 * Tags: Array
 */
public class M_CoinChange {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp,amount+1);
        dp[0]=0;
        for(int i=1;i<amount+1;i++){
            for(int coin:coins){
                if(coin<=i){
                    dp[i] = Math.min(dp[i],dp[i-coin]+1);
                }
            }
        }
        return dp[amount]<amount+1?dp[amount]:-1;
    }
}
