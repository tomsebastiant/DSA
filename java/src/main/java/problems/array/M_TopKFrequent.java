package problems.array;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * LC: 347
 * https://leetcode.com/problems/top-k-frequent-elements/
 * Given an integer array nums and an integer k, return the k most frequent elements.
 * You may return the answer in any order.
 *
 * Example 1:
 *
 * Input: nums = [1,1,1,2,2,3], k = 2
 * Output: [1,2]
 *
 * Example 2:
 *
 * Input: nums = [1], k = 1
 * Output: [1]
 *
 * Approach: Count the frequency of each number and keep a min-heap of size k based on frequency.
 * Tags: Array
 * Tags: HashMap
 * Tags: Heap
 */
public class M_TopKFrequent {
        public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> freqMap = new HashMap();
        for(int num:nums){
            freqMap.put(num,freqMap.getOrDefault(num,0)+1);
        }
        PriorityQueue<Integer> minHeap = new PriorityQueue<>( (a ,b) -> freqMap.get(a)-freqMap.get(b));
        for(int key:freqMap.keySet()){
            minHeap.offer(key);
            if(minHeap.size()>k){
                minHeap.poll();
            }
        }
        int[] result = new int[k];
        for(int i=0;i<k;i++){
            result[i]=minHeap.poll();
        }
        return result;
    }
}
