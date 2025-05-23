package leetcode.bfsdfs;

/**
 https://leetcode.com/problems/number-of-islands
 Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water),
 return the number of islands.
 An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
 You may assume all four edges of the grid are all surrounded by water.

 Approach: DFS to fully traverse each island and convert the met islands from 1 to 0.
 */

public class M_200_NumberOfIslands {

    public int numIslands(char[][] grid) {
        int count =0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]=='1'){
                    count++;
                    callDFS(grid,i,j);
                }
            }
        }
        return count;
    }

    private void callDFS(char[][] grid, int i, int j){
        if(i<0 || i>=grid.length || j <0 || j>=grid[i].length || grid[i][j] == '0')
            return;
        grid[i][j] ='0';
        callDFS(grid,i+1,j);
        callDFS(grid,i-1,j);
        callDFS(grid,i,j-1);
        callDFS(grid,i,j+1);
    }

}
