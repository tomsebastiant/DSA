package problems.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * LC: 785
 * Tags: Graph
 * Tags: BFS
 * https://leetcode.com/problems/is-graph-bipartite/
 * Given an undirected graph with n nodes (0-indexed) represented as an adjacency list, return
 * true if the graph is bipartite. A graph is bipartite if its nodes can be split into two
 * independent sets A and B such that every edge connects a node in A to a node in B — equivalently,
 * the graph can be 2-colored with no two adjacent nodes sharing the same color.
 * The graph may be disconnected. There are no self-edges or parallel edges.
 *
 * Constraints:
 * n == graph.length
 * 1 <= n <= 100
 * 0 <= graph[u].length < n
 * 0 <= graph[u][i] <= n - 1
 * graph[u] does not contain u
 * All values in graph[u] are unique
 * If graph[u] contains v, then graph[v] contains u
 *
 * Example 1:
 *
 * Input: graph = [[1,3],[0,2],[1,3],[0,2]]
 * Output: true
 * Explanation: Nodes form a 4-cycle (square). Partition: A={0,2}, B={1,3} — every edge crosses.
 *
 * Example 2:
 *
 * Input: graph = [[1,2],[0,2],[0,1]]
 * Output: false
 * Explanation: Nodes form a triangle (odd-length cycle). No valid 2-coloring exists.
 *
 * Approach: BFS 2-coloring — seed each unvisited node with color 0 and assign alternating colors
 * (1-color[curr]) to neighbours as they are enqueued. If a neighbour already carries the same
 * color as the current node, a monochromatic edge is found and the graph is not bipartite.
 * The outer for-loop re-seeds BFS from every still-uncolored node, handling disconnected graphs.
 */
public class M_GraphBipartite {
        public boolean isBipartite(int[][] graph) {
        int n=graph.length;
        int[] colors = new int[n];
        Arrays.fill(colors,-1);
        for(int i=0;i<n;i++){
            if(colors[i]!=-1) continue;
            Queue<Integer> queue = new LinkedList<>();
            colors[i]=0;
            queue.add(i);
            while(!queue.isEmpty()){
                int curr=queue.poll();
                for(int neighbour:graph[curr]){
                    if(colors[neighbour]==colors[curr]) return false;
                    if(colors[neighbour]==-1){
                        colors[neighbour]=1-colors[curr];
                        queue.offer(neighbour);
                    }

                }
            }

        }
        return true;
    }
}
