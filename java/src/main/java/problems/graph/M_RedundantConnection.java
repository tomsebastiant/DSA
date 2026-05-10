package problems.graph;

/**
 * LC: 684
 * Tags: Graph
 * https://leetcode.com/problems/redundant-connection/
 * In this problem, a tree is an undirected graph that is connected and has no cycles.
 *
 * You are given a graph that started as a tree with n nodes labeled from 1 to n, with one
 * additional edge added. The added edge has two different vertices chosen from 1 to n, and was
 * not an edge that already existed. The graph is represented as an array edges where
 * edges[i] = [ai, bi] indicates that there is an edge between nodes ai and bi in the graph.
 *
 * Return an edge that can be removed so that the resulting graph is a tree of n nodes. If there
 * are multiple answers, return the answer that occurs last in the input.
 *
 * Example 1:
 *
 * Input: edges = [[1,2],[1,3],[2,3]]
 * Output: [2,3]
 *
 * Example 2:
 *
 * Input: edges = [[1,2],[2,3],[3,4],[1,4],[1,5]]
 * Output: [1,4]
 *
 * Constraints:
 * n == edges.length
 * 3 <= n <= 1000
 * edges[i].length == 2
 * 1 <= ai < bi <= edges.length
 * ai != bi
 * There are no repeated edges.
 * The given graph is connected.
 *
 * Approach: Union-Find with path compression and union by rank. Each node starts as its own
 * component. Process edges in order — if both endpoints already share the same root, adding this
 * edge creates a cycle and it is the redundant edge. Otherwise, union the two components by
 * attaching the lower-rank root under the higher-rank one to keep the tree shallow.
 */
public class M_RedundantConnection {
        int[] parent,rank;
    public int[] findRedundantConnection(int[][] edges) {
        int n=edges.length;
        parent = new int[n+1];
        rank = new int[n+1];

        // Each node is its own component initially.
        for(int i=0;i<=n;i++){
            parent[i]=i;
        }

        for(int[] edge:edges){
            int u=edge[0];
            int v=edge[1];

            // Same root means u and v are already connected — this edge is the redundant one.
            if(find(u)==find(v)) return edge;

            union(u,v);
        }
        return new int[]{};
    }

    public int find(int x){
        if(parent[x]!=x){
            // Path compression: point directly to the root so future finds are O(α).
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    public void union(int x,int y){
        int px=find(x);
        int py=find(y);

        if(rank[px]>rank[py]){
            parent[py]=px;
        } else if (rank[py]>rank[px]){
            parent[px]=py;
        } else {
            parent[py]=px;
            rank[px]++; // NOTE: was `px++` (incremented the local variable, not the rank array).
        }
    }
}
