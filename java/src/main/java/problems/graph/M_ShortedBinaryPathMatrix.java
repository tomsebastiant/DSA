package problems.graph;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * LC: 1091
 * Tags: Graph
 * Tags: BFS
 * Tags: Array
 * https://leetcode.com/problems/shortest-path-in-binary-matrix/
 * Given an n x n binary matrix grid, return the length of the shortest clear path in the matrix.
 * If there is no clear path, return -1.
 *
 * A clear path is a path from the top-left cell (0, 0) to the bottom-right cell (n-1, n-1) such
 * that all visited cells are 0 and all adjacent cells are 8-directionally connected. The length
 * of a clear path is the number of visited cells.
 *
 * Constraints:
 * n == grid.length == grid[i].length
 * 1 <= n <= 100
 * grid[i][j] is 0 or 1
 *
 * Example 1:
 *
 * Input: grid = [[0,1],[1,0]]
 * Output: 2
 *
 * Example 2:
 *
 * Input: grid = [[0,0,0],[1,1,0],[1,1,0]]
 * Output: 4
 *
 * Example 3:
 *
 * Input: grid = [[1,0,0],[1,1,0],[1,1,0]]
 * Output: -1
 *
 * Approach: BFS from (0,0) exploring all 8 directions, tracking path length in the queue. Each
 * visited cell is marked as 1 to prevent revisiting. The first time BFS reaches (n-1, n-1) is
 * guaranteed to be the shortest path.
 */
public class M_ShortedBinaryPathMatrix {
        public int shortestPathBinaryMatrix(int[][] grid) {
        int n =grid.length;

        if(grid[0][0]==1 || grid[n-1][n-1]==1) return -1;

        if(n==1) return 1;

        int[][] dirs={{1,0},{0,1},{-1,0},{0,-1},
                                {1,1},{-1,-1},{-1,1},{1,-1}};

        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{0,0,1});
        grid[0][0]=1;

        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            int row =curr[0];
            int col = curr[1];
            int dist = curr[2];
            for(int[] dir:dirs){
                int newRow = row+dir[0];
                int newCol = col+dir[1];
                
                if(newRow<0 || newRow>=n || newCol<0 || newCol>=n || grid[newRow][newCol]==1) continue;

                if(newRow==n-1 && newCol==n-1) return dist+1;

                grid[newRow][newCol]=1;
                queue.offer(new int[]{newRow,newCol,dist+1});
            }
        }                        
        return -1;
    }
}
