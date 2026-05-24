package problems.priorityqueue;

import java.util.PriorityQueue;

/**
 * LC: 767
 * Tags: String
 * Tags: HashTable
 * Tags: Greedy
 * Tags: PriorityQueue
 * https://leetcode.com/problems/reorganize-string/
 * Given a string s, rearrange the characters of s so that any two adjacent characters are not
 * the same. Return any possible rearrangement of s or return "" if not possible.
 *
 * Constraints:
 * 1 <= s.length <= 500
 * s consists of lowercase English letters.
 *
 * Example 1:
 *
 * Input: s = "aab"
 * Output: "aba"
 *
 * Example 2:
 *
 * Input: s = "aaab"
 * Output: ""
 *
 * Approach: Count character frequencies and load them into a max-heap. Each round, greedily
 * pull the two most frequent characters and place them side by side — this is always safe
 * because the two most frequent chars are guaranteed to differ. If a single character remains
 * with count > 1 it exceeds the ceil(n/2) limit and no valid arrangement exists.
 */
public class M_ReorganizeString {
        public String reorganizeString(String s) {
        int[] freqMap = new int[26];
        for(char c:s.toCharArray()){
            freqMap[c-'a']++;
        }

        // max-heap ordered by frequency so the most-used char is always at the top
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->(b[1]-a[1]));
        for(int i=0;i<26;i++){
            if(freqMap[i]>0){
                pq.offer(new int[]{i,freqMap[i]});
            }
        }

        StringBuilder sb = new StringBuilder();

        while(pq.size()>=2){
            int[] first = pq.poll();
            int[] second = pq.poll();

            // placing the top-2 together guarantees they differ from each other
            // and from the previously placed pair's second character
            sb.append((char)('a'+first[0]));
            sb.append((char)('a'+second[0]));

            if(--first[1]>0) pq.offer(first);
            if(--second[1]>0) pq.offer(second);
        }

        if(!pq.isEmpty()){
            int[] remain = pq.poll();
            // a leftover count > 1 means this char would have to sit adjacent to itself
            if(remain[1]>1) return "";
            sb.append((char)('a'+remain[0]));
        }

        return sb.toString();
    }
}
