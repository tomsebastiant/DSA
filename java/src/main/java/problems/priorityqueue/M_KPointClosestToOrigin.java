package problems.priorityqueue;

import java.util.PriorityQueue;

/**
 * LC: 973
 * Tags: Array
 * Tags: PriorityQueue
 * https://leetcode.com/problems/k-closest-points-to-origin/
 * Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane and
 * an integer k, return the k closest points to the origin (0, 0). The distance is the Euclidean
 * distance. The answer may be returned in any order.
 *
 * Example 1:
 *
 * Input: points = [[1,3],[-2,2]], k = 1
 * Output: [[-2,2]]
 * Explanation: Distance of [1,3] is sqrt(10), distance of [-2,2] is sqrt(8). Closest is [-2,2].
 *
 * Example 2:
 *
 * Input: points = [[3,3],[5,-1],[-2,4]], k = 2
 * Output: [[3,3],[-2,4]]
 *
 * Approach: Maintain a max-heap of size k ordered by squared distance (no sqrt needed). For each
 * point, add it to the heap and evict the farthest if the heap exceeds k. What remains are the
 * k closest points.
 */
public class M_KPointClosestToOrigin {
        public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> 
                                        ((b[1]*b[1]+b[0]*b[0])-(a[0]*a[0]+a[1]*a[1])));
        for(int[] point:points){
            pq.offer(point);
            if(pq.size()>k){
                pq.poll();
            }
        }

        int[][] result = new int[k][2];
        int i=0;
        while(!pq.isEmpty()){
            result[i++]=pq.poll();
        }
        return result;

    }
}
