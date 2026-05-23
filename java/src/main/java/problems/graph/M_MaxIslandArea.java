package problems.graph;

/**
 * LC: 695
 * Tags: Graph
 * Tags: DFS
 * https://leetcode.com/problems/max-area-of-island/
 * You are given an m x n binary matrix grid. An island is a group of 1s connected 4-directionally
 * (horizontal or vertical). You may assume all four edges of the grid are surrounded by water.
 * Return the maximum area of an island in grid, or 0 if there is no island.
 *
 * Example 1:
 *
 * Input: grid = [[0,0,1,0,0,0,0,1,0,0,0,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],
 *                [0,1,1,0,1,0,0,0,0,0,0,0,0],[0,1,0,0,1,1,0,0,1,0,1,0,0],
 *                [0,1,0,0,1,1,0,0,1,1,1,0,0],[0,0,0,0,0,0,0,0,0,0,1,0,0],
 *                [0,0,0,0,0,0,0,1,1,1,0,0,0],[0,0,0,0,0,0,0,1,1,0,0,0,0]]
 * Output: 6
 *
 * Example 2:
 *
 * Input: grid = [[0,0,0,0,0,0,0,0]]
 * Output: 0
 *
 * Approach: For each unvisited land cell, trigger a recursive DFS that sinks visited cells to 0
 * (marking them visited in-place) and returns the cumulative area of the island. Track the
 * maximum area seen across all islands.
 */
public class M_MaxIslandArea {
        public int maxAreaOfIsland(int[][] grid) {
        int max=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    int area=calculateArea(grid,i,j);
                    max=Math.max(area,max);
                }
            }
        }
        return max;
    }

    public int calculateArea(int[][] grid, int i, int j){
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length || grid[i][j]==0){
            return 0;
        }
        grid[i][j]=0;
        return 1+calculateArea(grid,i+1,j)+calculateArea(grid,i-1,j)
                    +calculateArea(grid,i,j+1)+calculateArea(grid,i,j-1);
    }
}
