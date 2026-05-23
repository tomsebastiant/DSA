package problems.dynamicprogramming;

/**
 * LC: 62
 * Tags: DynamicProgramming
 * https://leetcode.com/problems/unique-paths/
 * There is a robot on an m x n grid. The robot is initially located at the top-left corner and
 * tries to move to the bottom-right corner. The robot can only move either down or right at any
 * point in time. Given two integers m and n, return the number of possible unique paths.
 *
 * Example 1:
 *
 * Input: m = 3, n = 7
 * Output: 28
 *
 * Example 2:
 *
 * Input: m = 3, n = 2
 * Output: 3
 * Explanation: From top-left there are exactly three paths: right→down→down, down→right→down,
 * down→down→right.
 *
 * Approach: DP on an m x n grid. The entire first row and column are seeded with 1 (only one
 * way to reach any edge cell). For every interior cell, the number of paths equals the sum of
 * paths from the cell above and the cell to the left. The answer is matrix[m-1][n-1].
 */
public class M_UniquePaths {
        public int uniquePaths(int m, int n) {
        int[][] matrix = new int[m][n];
        matrix[0][0]=1;
        for(int i=1;i<m;i++){
            matrix[i][0]=1;
        }
        for(int j=1;j<n;j++){
            matrix[0][j]=1;
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                matrix[i][j]=matrix[i-1][j]+matrix[i][j-1];
            }
        }
        return matrix[m-1][n-1];
    }
}
