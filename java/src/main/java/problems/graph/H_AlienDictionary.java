package problems.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * LC: 269
 * Tags: Graph
 * Tags: BFS
 * Tags: TopologicalSort
 * https://leetcode.com/problems/alien-dictionary/
 * There is an alien language that uses the English alphabet but with a different character order.
 * You are given a list of strings words from the alien language's dictionary, where the strings
 * are sorted lexicographically according to this unknown order. Derive the character ordering and
 * return any valid ordering as a string. Return "" if the ordering is invalid or contains a cycle.
 *
 * Constraints:
 * 1 <= words.length <= 100
 * 1 <= words[i].length <= 100
 * words[i] consists of only lowercase English letters.
 *
 * Example 1:
 *
 * Input: words = ["wrt","wrf","er","ett","rftt"]
 * Output: "wertf"
 * Explanation: from adjacent pairs: t→f, w→e, r→t, e→r  →  topological order: w,e,r,t,f
 *
 * Example 2:
 *
 * Input: words = ["z","x"]
 * Output: "zx"
 *
 * Example 3:
 *
 * Input: words = ["z","x","z"]
 * Output: ""
 * Explanation: z→x and x→z is a cycle; no valid ordering exists.
 *
 * Approach: Build a directed character-precedence graph by comparing each adjacent word pair —
 * the first differing character gives one edge; break immediately after. Run Kahn's BFS
 * topological sort seeded with all zero-indegree nodes. Two invalid states return "": (1) a
 * longer word strictly precedes its own prefix, and (2) the BFS result is shorter than the
 * total character count, indicating a cycle.
 *
 * NOTE: Missing import java.util.LinkedList was added — without it the file does not compile.
 */
public class H_AlienDictionary {
    
    public String alienOrder(String[] words) {
        // Step 1: Initialize adjacency list and indegree for all unique chars
        Map<Character, Set<Character>> adj = new HashMap<>();
        Map<Character, Integer> indegree = new HashMap<>();

        for (String word : words) {
            for (char c : word.toCharArray()) {
                adj.putIfAbsent(c, new HashSet<>());
                indegree.putIfAbsent(c, 0);
            }
        }

        // Step 2: Build graph by comparing adjacent word pairs
        for (int i = 0; i < words.length - 1; i++) {
            String w1 = words[i];
            String w2 = words[i + 1];
            int minLen = Math.min(w1.length(), w2.length());

            // Edge case: w1 is longer than w2 but w2 is a prefix of w1
            if (w1.length() > w2.length() && w1.startsWith(w2)) {
                return "";
            }

            for (int j = 0; j < minLen; j++) {
                char c1 = w1.charAt(j);
                char c2 = w2.charAt(j);
                if (c1 != c2) {
                    // Only add edge if not already present (avoid duplicate indegree increment)
                    if (!adj.get(c1).contains(c2)) {
                        adj.get(c1).add(c2);
                        indegree.put(c2, indegree.get(c2) + 1);
                    }
                    break; // Only first differing char gives us info
                }
            }
        }

        // Step 3: Kahn's BFS — start with all nodes of indegree 0
        Queue<Character> queue = new LinkedList<>();
        for (char c : indegree.keySet()) {
            if (indegree.get(c) == 0) {
                queue.offer(c);
            }
        }

        StringBuilder result = new StringBuilder();
        while (!queue.isEmpty()) {
            char c = queue.poll();
            result.append(c);
            for (char neighbor : adj.get(c)) {
                indegree.put(neighbor, indegree.get(neighbor) - 1);
                if (indegree.get(neighbor) == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        // Step 4: Cycle check — if not all chars are in result, cycle exists
        if (result.length() != indegree.size()) {
            return "";
        }

        return result.toString();
    }
}
