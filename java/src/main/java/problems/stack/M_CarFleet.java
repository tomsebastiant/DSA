package problems.stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * LC: 853
 * Tags: Array
 * Tags: Stack
 * https://leetcode.com/problems/car-fleet/
 * There are n cars traveling to the same destination on a one-lane highway. You are given two
 * arrays of integers position and speed, both of length n, where position[i] is the position of
 * the ith car (in miles) and speed[i] is the speed of the ith car (in miles per hour). The
 * destination is at position target miles. A car cannot pass another car ahead of it; it can only
 * catch up and then drive at the same speed as the car ahead. A car fleet is a non-empty set of
 * cars driving at the same position and speed. If a car catches up to a fleet the moment it
 * reaches the destination, it is part of that fleet. Return the number of car fleets that will
 * arrive at the destination.
 *
 * Constraints:
 * n == position.length == speed.length
 * 1 <= n <= 1000
 * 0 < target <= 1000
 * 0 < speed[i] <= 100
 * 0 <= position[i] < target
 * All values of position are unique.
 *
 * Example 1:
 *
 * Input: target = 10, position = [1,4], speed = [3,2]
 * Output: 1
 * Explanation: The cars starting at 1 (speed 3) and 4 (speed 2) become a fleet, meeting at 10.
 *
 * Example 2:
 *
 * Input: target = 10, position = [4,1,0,7], speed = [2,2,1,1]
 * Output: 3
 * Explanation: Cars at 4 and 7 fleet at 10. Cars at 1 and 0 never catch the car ahead.
 *              Thus 3 fleets arrive at the destination.
 *
 * Approach: Sort cars by position descending so each car is compared against the fleet
 * immediately ahead. A car whose arrival time exceeds the top of the stack cannot catch up and
 * forms a new fleet; otherwise it merges. Stack size equals the number of distinct fleets.
 */
public class M_CarFleet {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;

        // pair each car's position with its speed so we can sort together
        int[][] cars = new int[n][2];
        for (int i = 0; i < n; i++) {
            cars[i] = new int[]{position[i], speed[i]};
        }

        // process cars from closest-to-target to farthest so we always know
        // the arrival time of the car immediately ahead
        Arrays.sort(cars, (a, b) -> (b[0] - a[0]));

        // each entry is the arrival time of one fleet
        Deque<Double> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            double time = (double) (target - cars[i][0]) / cars[i][1];
            // only a strictly slower car (larger time) forms a new fleet;
            // a faster or equal car merges into the fleet already on the stack
            if (stack.isEmpty() || time > stack.peek()) {
                stack.push(time);
            }
        }

        return stack.size();
    }
}
