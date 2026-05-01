package problems.graph;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * LC: 207
 https://leetcode.com/problems/course-schedule
 There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1.
 You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must
 take course bi first if you want to take course ai.

 Return true if you can finish all courses. Otherwise, return false.

 Examples:
 numCourses = 2, prerequisites = [[1, 0]]
 Output: true
 Explanation: Take course 0 first, then course 1.

 numCourses = 2, prerequisites = [[1, 0], [0, 1]]
 Output: false
 Explanation: Course 0 depends on 1 and course 1 depends on 0, so there is a cycle.

 Approach: Kahn's algorithm (BFS topological sort).
 Build a graph from prerequisite -> course and track each course's indegree.
 Start with all courses whose indegree is 0.
 Repeatedly remove a course, process it, and reduce indegree of its neighbors.
 If a neighbor's indegree becomes 0, add it to the queue.
 If we process all courses, there is no cycle and all courses can be finished.
 Otherwise, a cycle exists, so it is impossible to complete all courses.

 Tags: Graph
 Tags: Topological Sort
 Tags: BFS
 */
public class M_CoursesCanFinish {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        // prerequisite -> course
        for (int[] prerequisite : prerequisites) {
            graph.get(prerequisite[1]).add(prerequisite[0]);
            indegree[prerequisite[0]]++;
        }

        Deque<Integer> queue = new LinkedList<>();
        for (int course = 0; course < numCourses; course++) {
            if (indegree[course] == 0) {
                queue.offer(course);
            }
        }

        int processed = 0;
        while (!queue.isEmpty()) {
            int course = queue.poll();
            processed++;

            for (int nextCourse : graph.get(course)) {
                indegree[nextCourse]--;
                if (indegree[nextCourse] == 0) {
                    queue.offer(nextCourse);
                }
            }
        }

        return processed == numCourses;
    }
}
