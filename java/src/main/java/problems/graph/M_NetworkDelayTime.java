package problems.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * LC: 743
 * Tags: Graph
 * Tags: PriorityQueue
 * https://leetcode.com/problems/network-delay-time/
 * You are given a network of n nodes, labeled from 1 to n. You are also given times, a list of
 * travel times as directed edges times[i] = (ui, vi, wi), where ui is the source node, vi is the
 * target node, and wi is the time it takes for a signal to travel from source to target.
 *
 * We will send a signal from a given node k. Return the minimum time it takes for all n nodes to
 * receive the signal. If it is impossible for all n nodes to receive the signal, return -1.
 *
 * Example 1:
 *
 * Input: times = [[2,1,1],[2,3,1],[3,4,1]], n = 4, k = 2
 * Output: 2
 *
 * Example 2:
 *
 * Input: times = [[1,2,1]], n = 2, k = 2
 * Output: -1
 *
 * Constraints:
 * 1 <= k <= n <= 100
 * 1 <= times.length <= 6000
 * times[i].length == 3
 * 1 <= ui, vi <= n
 * ui != vi
 * 0 <= wi <= 100
 * All pairs (ui, vi) are unique.
 *
 * Approach: Dijkstra from source k. Build an adjacency list, initialise all distances to MAX_VALUE
 * except dist[k] = 0, then greedily relax edges via a min-heap ordered by tentative distance.
 * Stale heap entries (where a shorter path was already settled) are skipped on pop. The answer is
 * the maximum of all shortest distances — the last node to receive the signal — or -1 if any node
 * remains unreachable.
 */
public class M_NetworkDelayTime {
        public int networkDelayTime(int[][] times, int n, int k) {
        // Size n+1 because nodes are 1-indexed; index 0 is unused.
        List<List<int[]>> adj = new ArrayList<>();
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }

        for(int[] time:times){
            // time[0]=src, time[1]=dst, time[2]=weight
            adj.get(time[0]).add(new int[]{time[1],time[2]});
        }

        int[] dist = new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[k] = 0;

        // Min-heap on [distance, node]; processes the closest unsettled node first.
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0]-b[0]);
        pq.offer(new int[]{0,k});

        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int time = curr[0];
            int node = curr[1];

            // A shorter path to this node was already settled — this entry is outdated.
            if(time>dist[node]) continue;
            for(int[] neighbour:adj.get(node)){
                int newDist = time+neighbour[1];
                int newNode = neighbour[0];

                if(newDist<dist[newNode]){
                    dist[newNode]=newDist;
                    pq.offer(new int[]{newDist,newNode});
                }
            }
        }

        // The signal reaches all nodes when the slowest (max shortest-path) node is reached.
        int max=0;
        for(int i=1;i<=n;i++){
            if(dist[i]==Integer.MAX_VALUE) return -1;
            max=Math.max(max,dist[i]);
        }
        return max;
    }
}
