package datastructures;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Graph {

    private final Map<Integer, List<Integer>> adjList = new HashMap<>();

    public void addVertex(int v) {
        adjList.putIfAbsent(v, new ArrayList<>());
    }

    public void addEdge(int u, int v) {
        adjList.putIfAbsent(u, new ArrayList<>());
        adjList.putIfAbsent(v, new ArrayList<>());
        adjList.get(u).add(v);
    }

    /**
     * BFS - level-order traversal from start node.
     * Use when: shortest path in unweighted graph, level-by-level processing.
     */
    public List<Integer> bfs(int start) {
        List<Integer> visited = new ArrayList<>();
        Set<Integer> seen = new HashSet<>();
        Queue<Integer> queue = new ArrayDeque<>();

        queue.offer(start);
        seen.add(start);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            visited.add(node);
            for (int neighbour : adjList.getOrDefault(node, new ArrayList<>())) {
                if (seen.add(neighbour)) {
                    queue.offer(neighbour);
                }
            }
        }
        return visited;
    }

    /**
     * DFS - depth-first traversal from start node (iterative).
     * Use when: cycle detection, connected components, topological sort.
     */
    public List<Integer> dfs(int start) {
        List<Integer> visited = new ArrayList<>();
        Set<Integer> seen = new HashSet<>();
        Deque<Integer> stack = new ArrayDeque<>();

        stack.push(start);

        while (!stack.isEmpty()) {
            int node = stack.pop();
            if (!seen.add(node)) {
                continue;
            }
            visited.add(node);
            for (int neighbour : adjList.getOrDefault(node, new ArrayList<>())) {
                if (!seen.contains(neighbour)) {
                    stack.push(neighbour);
                }
            }
        }
        return visited;
    }
}
