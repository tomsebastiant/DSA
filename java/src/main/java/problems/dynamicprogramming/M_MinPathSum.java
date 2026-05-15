package problems.dynamicprogramming;

/**
 * LC: 64
 * Tags: Array
 * Tags: DynamicProgramming
 * https://leetcode.com/problems/minimum-path-sum/
 * Given an m x n grid filled with non-negative numbers, find a path from the top-left to the
 * bottom-right corner which minimizes the sum of all numbers along the path. You can only move
 * either down or right at any point in time.
 *
 * Example 1:
 *
 * Input: grid = [[1,3,1],[1,5,1],[4,2,1]]
 * Output: 7
 * Explanation: The path 1 → 3 → 1 → 1 → 1 minimizes the sum.
 *
 * Example 2:
 *
 * Input: grid = [[1,2,3],[4,5,6]]
 * Output: 12
 *
 * Approach: In-place DP. Seed the first column and first row with their cumulative sums since
 * there is only one direction to reach each. For every interior cell, overwrite it with its value
 * plus the minimum of the cell above and the cell to the left. The bottom-right cell holds the
 * answer.
 */
public class M_MinPathSum {
        public int minPathSum(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;

        for(int i=1;i<m;i++){
            grid[i][0] += grid[i-1][0];
        }

        for(int j=1;j<n;j++){
            grid[0][j]+=grid[0][j-1];
        }

        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                grid[i][j]=grid[i][j]+Math.min(grid[i-1][j],grid[i][j-1]);
            }
        }
        return grid[m-1][n-1];
    }
}
