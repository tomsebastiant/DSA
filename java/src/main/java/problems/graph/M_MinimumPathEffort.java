package problems.graph;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * LC: 1631
 * Tags: Graph
 * Tags: PriorityQueue
 * https://leetcode.com/problems/path-with-minimum-effort/
 * You are a hiker preparing for an upcoming hike. You are given heights, a 2D array of size
 * rows x columns, where heights[row][col] represents the height of cell (row, col). You are
 * situated in the top-left cell (0, 0) and hope to travel to the bottom-right cell
 * (rows-1, columns-1). You can move up, down, left, or right, and you wish to find a route
 * that requires the minimum effort. A route's effort is the maximum absolute difference in
 * heights between two consecutive cells of the route. Return the minimum effort required to
 * travel from the top-left cell to the bottom-right cell.
 *
 * Constraints:
 * rows == heights.length
 * columns == heights[i].length
 * 1 <= rows, columns <= 100
 * 1 <= heights[i][j] <= 10^6
 *
 * Example 1:
 *
 * Input: heights = [[1,2,2],[3,8,2],[5,3,5]]
 * Output: 2
 * Explanation: The route [1,3,5,3,5] has a maximum absolute difference of 2 in consecutive cells.
 * This is better than route [1,2,2,2,5] with maximum absolute difference of 3.
 *
 * Example 2:
 *
 * Input: heights = [[1,2,3],[3,8,4],[5,3,5]]
 * Output: 1
 * Explanation: The route [1,2,3,4,5] has a maximum absolute difference of 1 in consecutive cells.
 *
 * Approach: Modified Dijkstra where path cost is the maximum (not sum) of edge heights differences.
 * A min-heap ordered by current max-difference greedily settles each cell with its true minimum
 * effort; dp[i][j] records the best known effort to reach (i,j) and gates future enqueues so only
 * improving paths are added.
 */
public class M_MinimumPathEffort {
        public int minimumEffortPath(int[][] heights) {
        int m=heights.length;
        int n=heights[0].length;

        // dp[i][j] = minimum effort (max edge diff) to reach cell (i,j)
        int[][] dp = new int[m][n];
        int[][] dirs= {{1,0},{0,1},{-1,0},{0,-1}};

        for (int[] row : dp) Arrays.fill(row, Integer.MAX_VALUE);
        // min-heap on element [2] = current path effort so far
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->(a[2]-b[2]));
        dp[0][0]=0;
        pq.offer(new int[]{0,0,0});

        while(!pq.isEmpty()){
            int[] curr=pq.poll();
            int i=curr[0];
            int j=curr[1];
            int dist=curr[2];
            // first pop for this cell is always the minimum — subsequent pops are stale
            dp[i][j]=Math.min(dp[i][j],dist);
            for(int[] dir:dirs){
                int ni=i+dir[0];
                int nj=j+dir[1];
                if(ni>=0 && ni<m && nj>=0 && nj<n){
                    // path effort = worst single edge on the entire route, not cumulative sum
                    int newDist=Math.max(dist,Math.abs(heights[i][j]-heights[ni][nj]));
                    // only enqueue if this path improves on the best effort known to (ni,nj)
                    if(newDist<dp[ni][nj]){
                        pq.offer(new int[]{ni,nj,newDist});
                    }
                }
            }
        }
        return dp[m-1][n-1];


    }
}
