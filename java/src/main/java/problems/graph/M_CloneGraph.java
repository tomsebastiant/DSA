package problems.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}


/**
 * LC: 133
 * https://leetcode.com/problems/clone-graph/
 * Given a reference of a node in a connected undirected graph, return a deep copy (clone) of the graph.
 *
 * Each node in the graph contains a value and a list of its neighbors.
 *
 * Example 1:
 *
 * Input: adjList = [[2,4],[1,3],[2,4],[1,3]]
 * Output: [[2,4],[1,3],[2,4],[1,3]]
 *
 * Example 2:
 *
 * Input: adjList = [[]]
 * Output: [[]]
 *
 * Example 3:
 *
 * Input: adjList = []
 * Output: []
 *
 * Approach: Use DFS with a hash map to remember already-cloned nodes.
 * For each original node, create its clone once and recursively clone all neighbors.
 * Tags: Graph
 * Tags: DFS
 * Tags: HashMap
 */
public class M_CloneGraph {
    Map<Node, Node> visited = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        if (visited.containsKey(node)) {
            return visited.get(node);
        }

        Node clone = new Node(node.val);
        visited.put(node, clone);

        for (Node neighbour : node.neighbors) {
            clone.neighbors.add(cloneGraph(neighbour));
        }
        return clone;
    }
}
