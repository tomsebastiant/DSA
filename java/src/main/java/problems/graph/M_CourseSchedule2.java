package problems.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * LC: 210
 * Tags: Graph
 * Tags: TopologicalSort
 * Tags: BFS
 * https://leetcode.com/problems/course-schedule-ii/
 * There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1.
 * You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must
 * take course bi first if you want to take course ai.
 *
 * Return the ordering of courses you should take to finish all courses. If there are many valid
 * answers, return any of them. If it is impossible to finish all courses, return an empty array.
 *
 * Example 1:
 *
 * Input: numCourses = 2, prerequisites = [[1,0]]
 * Output: [0,1]
 * Explanation: To take course 1 you must first finish course 0.
 *
 * Example 2:
 *
 * Input: numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
 * Output: [0,2,1,3]
 * Explanation: One valid ordering is [0,2,1,3]; another is [0,1,2,3].
 *
 * Example 3:
 *
 * Input: numCourses = 1, prerequisites = []
 * Output: [0]
 *
 * Constraints:
 * 1 <= numCourses <= 2000
 * 0 <= prerequisites.length <= numCourses * (numCourses - 1)
 * prerequisites[i].length == 2
 * 0 <= ai, bi < numCourses
 * ai != bi
 * All the pairs [ai, bi] are unique.
 *
 * Approach: Kahn's algorithm — BFS-based topological sort. Build an adjacency list and compute
 * each course's indegree. Seed the queue with all courses whose indegree is 0 (no prerequisites).
 * Repeatedly dequeue a course, record it in the output, and decrement the indegree of every course
 * that depends on it; when a course's indegree reaches 0 all its prerequisites are satisfied and
 * it joins the queue. If the output contains all numCourses the graph is acyclic and the output
 * is a valid ordering; otherwise a cycle exists and no valid ordering is possible.
 */
public class M_CourseSchedule2 {
        public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer,List<Integer>> map = new HashMap<>();
        for(int i=0;i<numCourses;i++){
            map.put(i,new ArrayList<>());
        }

        int[] inDegrees=new int[numCourses];

        for(int[] edge:prerequisites){
            // edge[1] is the prerequisite; edge[0] is the course that depends on it.
            map.get(edge[1]).add(edge[0]);
            inDegrees[edge[0]]++;
        }

        Queue<Integer> queue = new ArrayDeque<>();

        // Courses with no prerequisites can be taken immediately.
        for(int i=0;i<numCourses;i++){
            if(inDegrees[i]==0){
                queue.offer(i);
            }
        }

        List<Integer> output = new ArrayList<>();

        while(!queue.isEmpty()){
            int curr=queue.poll();
            output.add(curr);
            for(Integer course:map.get(curr)){
                inDegrees[course]--;
                // All prerequisites for this course are now done — it is ready to take.
                if(inDegrees[course]==0){
                    queue.offer(course);
                }
            }
        }

        // A cycle leaves some courses with indegree > 0 forever; they never enter the output.
        if(output.size()==numCourses){
           return output.stream().mapToInt(i -> i).toArray();
        }

        return new int[0];
    }
}
