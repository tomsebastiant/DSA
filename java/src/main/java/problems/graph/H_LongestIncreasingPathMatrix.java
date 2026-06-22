package problems.graph;

/**
 * LC: 329
 * Tags: Graph
 * Tags: DFS
 * Tags: DynamicProgramming
 * https://leetcode.com/problems/longest-increasing-path-in-a-matrix/
 * Given an m x n integers matrix, return the length of the longest increasing path in matrix.
 * From each cell, you can either move in four directions: left, right, up, or down. You may not
 * move diagonally or move outside the boundary (i.e., wrap-around is not allowed).
 *
 * Constraints:
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 200
 * 0 <= matrix[i][j] <= 2^31 - 1
 *
 * Example 1:
 *
 * Input: matrix = [[9,9,4],[6,6,8],[2,1,1]]
 * Output: 4
 * Explanation: The longest increasing path is [1, 2, 6, 9].
 *
 * Example 2:
 *
 * Input: matrix = [[3,4,5],[3,2,6],[2,2,1]]
 * Output: 4
 * Explanation: The longest increasing path is [3, 4, 5, 6]. Moving diagonally is not allowed.
 *
 * Example 3:
 *
 * Input: matrix = [[1]]
 * Output: 1
 *
 * Approach: DFS from every cell; memoize the longest increasing path starting at each (i, j).
 * Strict inequality (neighbours must be strictly greater) guarantees the dependency graph is a
 * DAG — no cell can be its own ancestor — so memoization is valid and no visited set is needed.
 * The global answer is the maximum across all starting cells.
 */
public class H_LongestIncreasingPathMatrix {
    int[][] memo;
    int[][] dirs= {{1,0},{0,1},{-1,0},{0,-1}};
    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        memo = new int[m][n];
        int result =0;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                result = Math.max(result,dfs(i,j,matrix));
            }
        }
        return result;
    }

    public int dfs(int i,int j,int[][] matrix){
        // 0 is safe as a sentinel because best is initialised to 1 and only grows
        if(memo[i][j]!=0) return memo[i][j];
        int m = matrix.length;
        int n = matrix[0].length;

        int best=1;
        for(int[] dir:dirs){
            int ni=i+dir[0];
            int nj=j+dir[1];
            // strict > creates a DAG: a cell can never circle back to itself, so no cycle detection needed
            if(ni>=0 && ni<m && nj>=0 && nj<n && matrix[ni][nj]>matrix[i][j]){
                best = Math.max(best,1+dfs(ni,nj,matrix));
            }
        }
        memo[i][j]=best;
        return best;
    }
}
