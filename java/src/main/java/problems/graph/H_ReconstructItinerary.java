package problems.graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * LC: 332
 * Tags: Graph
 * Tags: DFS
 * https://leetcode.com/problems/reconstruct-itinerary/
 * You are given a list of airline tickets where tickets[i] = [fromi, toi] represent the
 * departure and arrival airports of one flight. Reconstruct the itinerary in order and return it.
 * All of the tickets must be used once and only once. The itinerary must begin with "JFK".
 * If there are multiple valid itineraries, return the itinerary that has the smallest lexical
 * order when read as a single string.
 *
 * Constraints:
 * 1 <= tickets.length <= 300
 * tickets[i].length == 2
 * fromi.length == 3
 * toi.length == 3
 * fromi and toi consist of uppercase English letters.
 * fromi != toi
 * The input data is guaranteed to have a valid itinerary.
 *
 * Example 1:
 *
 * Input: tickets = [["MUC","LHR"],["JFK","MUC"],["SFO","SJC"],["LHR","SFO"]]
 * Output: ["JFK","MUC","LHR","SFO","SJC"]
 *
 * Example 2:
 *
 * Input: tickets = [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
 * Output: ["JFK","ATL","JFK","SFO","ATL","SFO"]
 * Explanation: ["JFK","SFO","ATL","JFK","ATL","SFO"] is also valid but lexicographically larger.
 *
 * Approach: Hierholzer's algorithm for an Eulerian path. Each airport maps to a min-heap of
 * destinations so the lexicographically smallest neighbour is always explored first. DFS exhausts
 * all outgoing edges from a node before prepending it to the result — post-order insertion builds
 * the path in reverse, so dead-end branches naturally end up at the tail of the final list.
 */
public class H_ReconstructItinerary {
        public List<String> findItinerary(List<List<String>> tickets) {
        Map<String,PriorityQueue<String>> graph = new HashMap<>();
        for(List<String> ticket:tickets){
            String from = ticket.get(0);
            String to = ticket.get(1);
            // min-heap per airport guarantees lexicographically smallest destination is picked first
            graph.computeIfAbsent(from,k->new PriorityQueue<>()).offer(to);
        }

        LinkedList<String> result = new LinkedList<>();
        dfs("JFK",graph,result);
        return result;
    }

    public void dfs(String curr,Map<String,PriorityQueue<String>> graph,LinkedList<String> result){
        PriorityQueue<String> destinations = graph.get(curr);
        while(destinations!=null && !destinations.isEmpty()){
            // consume the ticket greedily: smallest destination first, recurse before backtrack
            String next=destinations.poll();
            dfs(next,graph,result);
        }
        // all outgoing edges exhausted — prepend so that dead-ends land at the tail of the path
        result.addFirst(curr);
    }
}
