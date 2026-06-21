package problems.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LC: 1192
 * Tags: Graph
 * Tags: DFS
 * https://leetcode.com/problems/critical-connections-in-a-network/
 * There are n servers numbered 0 to n - 1 connected by undirected server-to-server connections
 * forming a network where connections[i] = [ai, bi] represents a connection between servers ai
 * and bi. Any server can reach any other server directly or indirectly through the network.
 * A critical connection is a connection that, if removed, will make some servers unable to reach
 * some other server. Return all critical connections in the network in any order.
 *
 * Constraints:
 * 2 <= n <= 10^5
 * n - 1 <= connections.length <= 10^5
 * 0 <= ai, bi <= n - 1
 * ai != bi
 * There are no repeated connections.
 *
 * Example 1:
 *
 * Input: n = 4, connections = [[0,1],[1,2],[2,3],[3,1]]
 * Output: [[0,1]]
 * Explanation: [0,1] is the only critical connection. The cycle 1-2-3-1 means none of those
 * edges is critical — removing any one of them still leaves the cycle intact.
 *
 * Example 2:
 *
 * Input: n = 3, connections = [[0,1],[1,2]]
 * Output: [[0,1],[1,2]]
 * Explanation: Both edges are bridges in a simple chain — removing either one disconnects a node.
 *
 * Approach: Tarjan's bridge-finding algorithm. A single DFS assigns each node a discovery time
 * (disc) and a low value (the earliest discovery time reachable from the node's subtree via any
 * back edge). An edge (u→v) is a bridge when low[v] > disc[u]: v's subtree has no back edge
 * reaching u or any ancestor of u, so removing (u,v) would disconnect v's component. O(V + E).
 */
public class H_CriticalConnections {
        private List<List<Integer>> graph;
    private int[] disc, low;
    private int timer = 0;
    private List<List<Integer>> bridges;

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        graph = new ArrayList<>();
        for(int i=0;i<n;i++) graph.add(new ArrayList());
        for(List<Integer> conn:connections){
            int u=conn.get(0);
            int v=conn.get(1);
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        disc = new int[n];
        low  = new int[n];
        Arrays.fill(disc, -1);  // -1 = unvisited sentinel
        bridges = new ArrayList();
        for(int i=0;i<n;i++){
            if (disc[i] == -1) {
                dfs(i, -1);
            }
        }
        return bridges;
    }

    public void dfs(int u, int parent){
        // disc = visit order (monotonically increasing); low starts equal, may decrease via back edges
        disc[u] = low[u] = timer++;

        for(int v : graph.get(u)){
            if(v == parent) continue;   // skip the tree edge we arrived on to avoid false back-edge

            if(disc[v] == -1){
                dfs(v, u);
                // pull up the lowest ancestor reachable from v's entire subtree
                low[u] = Math.min(low[u], low[v]);
                // bridge condition: v's subtree cannot reach u or above → (u,v) is a bridge
                if(low[v] > disc[u]){
                    bridges.add(Arrays.asList(u, v));
                }
            } else {
                // back edge to an already-visited ancestor: record how far up u can reach
                low[u] = Math.min(low[u], disc[v]);
            }
        }
    }
}
