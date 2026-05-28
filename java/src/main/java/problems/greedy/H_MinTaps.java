package problems.greedy;

import java.util.Arrays;

/**
 * LC: 1326
 * Tags: Array
 * Tags: Greedy
 * https://leetcode.com/problems/minimum-number-of-taps-to-open-to-water-a-garden/
 * There is a one-dimensional garden on the x-axis from point 0 to point n. There are n+1 taps
 * located at points [0, 1, ..., n]. Given an integer n and an integer array ranges of length n+1,
 * ranges[i] means the i-th tap can water the area [i - ranges[i], i + ranges[i]] if it is open.
 * Return the minimum number of taps that should be open to water the whole garden [0, n].
 * If the garden cannot be watered, return -1.
 *
 * Constraints:
 * 1 <= n <= 10^4
 * ranges.length == n + 1
 * 0 <= ranges[i] <= 100
 *
 * Example 1:
 *
 * Input: n = 5, ranges = [3,4,1,1,0,0]
 * Output: 1
 * Explanation: The tap at position 1 covers [-3,5], which waters the entire garden [0,5].
 *
 * Example 2:
 *
 * Input: n = 3, ranges = [0,0,0,0]
 * Output: -1
 * Explanation: Every tap covers only its own point; no part of the garden between points is watered.
 *
 * Approach: Reduce to minimum interval cover (= Jump Game II on intervals). Convert each tap to
 * the interval it covers, clamped to [0, n], then sort by left endpoint. Sweep left to right
 * maintaining curr (the rightmost point currently covered) and greedily picking the tap that
 * extends coverage the farthest. Each time we commit to the best extension we count one tap.
 * If no tap can push past curr the garden is disconnected — return -1.
 */
public class H_MinTaps {
    public int minTaps(int n, int[] ranges) {
        // convert each tap i into the interval [i-ranges[i], i+ranges[i]], clamped to [0,n]
        // clamping avoids considering area outside the garden, which can never help coverage
        int[][] coverage = new int[n+1][2];
        for(int i=0;i<=n;i++){
            coverage[i][0]=Math.max(i-ranges[i],0);
            coverage[i][1]=Math.min(i+ranges[i],n);
        }

        // sort by left endpoint so we always process intervals that touch the current
        // frontier before intervals that start beyond it — same invariant as Jump Game II
        Arrays.sort(coverage,(a,b)->(a[0]-b[0]));

        // curr = rightmost point that is guaranteed to be watered so far
        // max  = farthest right we can reach by opening any tap whose left end <= curr
        // i    = next unvisited interval index (never resets — each interval is visited once)
        int curr=0;
        int count=0;
        int i=0;
        while(curr<n){
            int max=curr;
            // greedily scan every interval that overlaps or abuts the current coverage frontier;
            // among those, pick the one that pushes the right boundary the farthest
            while(i<=n && coverage[i][0]<=curr){
                max=Math.max(max,coverage[i][1]);
                i++;
            }
            // if the best reachable right edge didn't advance past curr, there is a gap in the
            // garden that no available tap can bridge — watering the full garden is impossible
            if(max==curr) return -1;
            // commit: extend coverage to max, count this as one tap opened
            curr=max;
            count++;
        }

        return count;
    }
}
