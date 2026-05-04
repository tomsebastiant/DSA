package problems.priorityqueue;

import java.util.Arrays;

/**
 * LC: 621
 * https://leetcode.com/problems/task-scheduler/
 * You are given an array of CPU tasks, each represented by a capital letter from A to Z, and a non-negative integer n.
 * Each CPU cycle can either execute a task or be idle.
 * Tasks need to be scheduled so that identical tasks are separated by at least n intervals.
 *
 * Return the minimum number of CPU intervals needed to complete all tasks.
 *
 * Example 1:
 *
 * Input: tasks = ["A","A","A","B","B","B"], n = 2
 * Output: 8
 * Explanation: One possible schedule is A -> B -> idle -> A -> B -> idle -> A -> B.
 *
 * Example 2:
 *
 * Input: tasks = ["A","C","A","B","D","B"], n = 1
 * Output: 6
 * Explanation: One possible schedule is A -> B -> C -> D -> A -> B.
 *
 * Example 3:
 *
 * Input: tasks = ["A","A","A","B","B","B"], n = 3
 * Output: 10
 * Explanation: One possible schedule is A -> B -> idle -> idle -> A -> B -> idle -> idle -> A -> B.
 *
 * Approach: Count the frequency of each task, then sort the frequency array.
 * The most frequent task determines the number of "buckets" we need.
 * The formula (maxFreq - 1) * (n + 1) builds the skeleton, and maxFreqCount fills the last bucket.
 * The answer is the maximum of that skeleton and the total number of tasks.
 * Tags: PriorityQueue
 * Tags: Greedy
 * Tags: Array
 */
public class M_TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        // Count how many times each task appears.
        for (char c : tasks) {
            freq[c - 'A']++;
        }

        // Sort frequencies so the most frequent task is at the end.
        Arrays.sort(freq);
        int maxFreq = freq[25];
        int maxFreqCount = 0;
        // Count how many tasks share the highest frequency.
        for (int count : freq) {
            if (count == maxFreq) {
                maxFreqCount++;
            }
        }

        // Skeleton size from the most frequent tasks and cooldown slots.
        int ans = (maxFreq - 1) * (n + 1) + maxFreqCount;
        // If there are enough other tasks to fill all idle slots, the answer is just the task count.
        return Math.max(ans, tasks.length);
    }
}
