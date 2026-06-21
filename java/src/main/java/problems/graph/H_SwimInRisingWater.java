package problems.graph;

import java.util.PriorityQueue;

/**
 * LC: 778
 * Tags: Graph
 * Tags: PriorityQueue
 * https://leetcode.com/problems/swim-in-rising-water/
 * You are given an n x n integer matrix grid where each value grid[i][j] represents the
 * elevation at that point (i, j). The rain starts to fall. At time t, the depth of the water
 * everywhere is t. You can swim from a square to another 4-directionally adjacent square if and
 * only if the elevation of both squares individually is at most t. You can swim infinite distances
 * in zero time. You must stay within the n x n grid boundaries during your swim. Return the
 * least time until you can reach the bottom right square (n - 1, n - 1) if you start at the
 * top left square (0, 0).
 *
 * Constraints:
 * n == grid.length
 * n == grid[i].length
 * 1 <= n <= 50
 * 0 <= grid[i][j] < n^2
 * Each value in grid is unique.
 *
 * Example 1:
 *
 * Input: grid = [[0,2],[1,3]]
 * Output: 3
 * Explanation: At t=3 all cells are reachable. At t=2 there is no path: (1,0) has elevation 1
 * but to reach (1,1) we'd need to pass through (0,1) with elevation 2 or (1,1) with elevation 3.
 *
 * Example 2:
 *
 * Input: grid = [[0,1,2,3,4],[24,23,22,21,5],[12,13,14,15,16],[11,17,18,19,20],[10,9,8,7,6]]
 * Output: 16
 * Explanation: The optimal path spirals around the grid; the bottleneck cell has elevation 16.
 *
 * Approach: Modified Dijkstra where path cost is the maximum elevation encountered, not a sum.
 * A min-heap ordered by current maximum elevation greedily settles each cell with the least time
 * needed to reach it; the first time (n-1, n-1) is popped from the heap is the answer.
 * See also M_MinimumPathEffort (LC 1631) — identical pattern, different edge-weight semantics.
 */
public class H_SwimInRisingWater {
        public int swimInWater(int[][] grid) {
        int n=grid.length;
        int[][] dirs={{0,1},{0,-1},{1,0},{-1,0}};

        // min-heap on element[0] = current time (max elevation on path so far)
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0]-b[0]);
        boolean[][] visited = new boolean[n][n];

        pq.offer(new int[]{grid[0][0],0,0});

        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int time=curr[0];
            int r=curr[1];
            int c=curr[2];
            if(visited[r][c]) continue;   // first pop is always the minimum time — skip stale entries
            visited[r][c]=true;
            if(r==n-1 && c==n-1) return time;   // Dijkstra guarantee: first arrival = optimal
            for(int[] dir:dirs){
                int nr=r+dir[0];
                int nc=c+dir[1];
                if(nr>=0 && nr<n && nc>=0 && nc<n && !visited[nr][nc]){
                    // must wait until water rises to the neighbour's elevation — can't go back in time
                    int nTime = Math.max(time,grid[nr][nc]);
                    pq.offer(new int[]{nTime,nr,nc});
                }
            }
        }
        return -1;
    }
}
