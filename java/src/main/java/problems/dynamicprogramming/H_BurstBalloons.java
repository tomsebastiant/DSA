package problems.dynamicprogramming;

/**
 * LC: 312
 * Tags: DynamicProgramming
 * Tags: Array
 * https://leetcode.com/problems/burst-balloons/
 * You are given n balloons, indexed from 0 to n-1. Each balloon has a value nums[i]. Burst
 * balloon i to earn nums[i-1] * nums[i] * nums[i+1] coins; out-of-bounds neighbors count as 1.
 * After bursting, the remaining balloons close the gap and become adjacent. Return the maximum
 * coins you can collect by bursting all the balloons in any order.
 *
 * Constraints:
 * n == nums.length
 * 1 <= n <= 300
 * 0 <= nums[i] <= 100
 *
 * Example 1:
 *
 * Input: nums = [3,1,5,8]
 * Output: 167
 * Explanation: Burst in order 1,5,3,8:
 *   3*1*5=15  → [3,5,8]
 *   3*5*8=120 → [3,8]
 *   1*3*8=24  → [8]
 *   1*8*1=8   → []
 *   total = 167
 *
 * Example 2:
 *
 * Input: nums = [1,5]
 * Output: 10
 *
 * Approach: Reverse the framing — instead of picking which balloon to burst first (neighbors
 * change unpredictably), pick which balloon k to burst LAST inside open interval (l, r). When k
 * is the last remaining balloon in (l, r), its only neighbors are the sentinels l and r, so its
 * coin contribution is exactly padded[l]*padded[k]*padded[r]. The total is that value plus the
 * independently optimal sub-results for (l,k) and (k,r). Fill by increasing window length so
 * every sub-interval is solved before it is needed by a larger interval.
 *
 */
public class H_BurstBalloons {
        public int maxCoins(int[] nums) {
        int n=nums.length;

        // Pad with virtual 1-valued sentinels on both sides.
        // Sentinels act as permanent boundaries that are never burst,
        // so the last real balloon always has well-defined neighbors.
        int[] padded = new int[n+2];
        padded[0]=1;
        int m=padded.length;
        padded[m-1]=1;
        for(int i=1;i<m-1;i++){
            padded[i]=nums[i-1];
        }

        // dp[l][r] = max coins from bursting every balloon strictly inside open interval (l, r).
        // l and r are sentinels for that sub-problem — they are NOT burst themselves.
        int[][] dp = new int[m][m];

        // Fill by increasing window length so dp[l][k] and dp[k][r] are always ready.
        // len=2 is the minimum: a window of size 2 has exactly one interior balloon (k = l+1).
        for(int len=2;len<m;len++){
            for(int l=0;l<m-len;l++){
                int r=l+len;
                // Try each k as the LAST balloon burst inside (l, r).
                // Because k is last, l and r are still present when k is burst,
                // making the coin value deterministic: padded[l]*padded[k]*padded[r].
                for(int k=l+1;k<r;k++){
                    int coins = padded[l]*padded[k]*padded[r]+
                                dp[l][k]+dp[k][r]; // optimal left and right sub-intervals
                    dp[l][r] = Math.max(dp[l][r],coins);
                }
            }
        }
        // Answer is the full array with sentinels 0 and m-1 as boundaries
        return dp[0][m-1];
    }
}
