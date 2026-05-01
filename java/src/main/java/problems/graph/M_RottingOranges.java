package problems.graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * LC: 994
 https://leetcode.com/problems/rotting-oranges/
 You are given an m x n grid where each cell can have one of three values:
 0 representing an empty cell,
 1 representing a fresh orange, or
 2 representing a rotten orange.

 Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.
 Return the minimum number of minutes that must elapse until no cell has a fresh orange.
 If this is impossible, return -1.

 Approach: Use multi-source BFS by pushing all initially rotten oranges into a queue.
 Each BFS level represents one minute of rotting.

 Tags: BFS
 Tags: Graph
 */
public class M_RottingOranges {
    public int orangesRotting(int[][] grid) {
        int freshCount = 0;
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    freshCount++;
                } else if (grid[i][j] == 2) {
                    int[] arr = {i, j};
                    queue.offer(arr);
                }
            }
        }
        if (freshCount == 0) return 0;

        int min = 0;
        while (!queue.isEmpty()) {
            min++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] pos = queue.poll();
                freshCount = freshCount - traverse(grid, queue, pos);
            }
            if (freshCount <= 0) break;
        }
        if (freshCount > 0) {
            return -1;
        } else {
            return min;
        }

    }

    public int traverse(int[][] grid, Queue<int[]> queue, int[] pos) {
        int converted = 0;
        int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        for (int[] dir : directions) {
            int newRow = pos[0] + dir[0];
            int newCol = pos[1] + dir[1];
            if (newRow >= 0 && newRow < grid.length && newCol >= 0 && newCol < grid[0].length
                    && grid[newRow][newCol] == 1) {
                grid[newRow][newCol] = 2;
                converted++;
                int[] arr = {newRow, newCol};
                queue.offer(arr);
            }
        }
        return converted;                
    }
}
