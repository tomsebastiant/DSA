package problems.design;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

/**
 * LC: 460
 * Tags: Design
 * Tags: HashTable
 * https://leetcode.com/problems/lfu-cache/
 * Design a data structure for a Least Frequently Used (LFU) cache. Implement LFUCache(capacity),
 * get(key), and put(key, value). get returns the value if the key exists, else -1, and counts as
 * a use. put inserts or updates the key; when at capacity, evict the least frequently used key
 * before inserting. Ties in frequency are broken by evicting the least recently used key.
 * Both get and put must run in O(1) average time.
 *
 * Constraints:
 * 1 <= capacity <= 10^4
 * 0 <= key <= 10^5
 * 0 <= value <= 10^9
 * At most 2 * 10^5 calls will be made to get and put.
 *
 * Example 1:
 *
 * Input:  ["LFUCache","put","put","get","put","get","get","put","get","get","get"]
 *         [[2],[1,1],[2,2],[1],[3,3],[2],[3],[4,4],[1],[3],[4]]
 * Output: [null,null,null,1,null,-1,3,null,-1,3,4]
 * Explanation:
 * lfu.put(1,1); // cache={1:1},          cnt(1)=1, minFreq=1
 * lfu.put(2,2); // cache={1:1,2:2},      cnt(1)=1, cnt(2)=1
 * lfu.get(1);   // return 1,             cnt(1)=2, minFreq=1 (key 2 still at freq 1)
 * lfu.put(3,3); // evict key 2 (LFU, freq=1), cache={1:1,3:3}, cnt(3)=1
 * lfu.get(2);   // return -1 (evicted)
 * lfu.get(3);   // return 3,             cnt(3)=2
 * lfu.put(4,4); // evict key 1 (LRU among tied freq=2), cache={3:3,4:4}
 * lfu.get(1);   // return -1 (evicted)
 * lfu.get(3);   // return 3
 * lfu.get(4);   // return 4
 *
 * Approach: Three maps: keyToValue, keyToFreq, and freqToKeys (freq → LinkedHashSet, which
 * preserves insertion order for O(1) LRU eviction within a frequency bucket). A minFreq counter
 * tracks the eviction target without scanning. Every get/put calls increaseFreq to move the key
 * to the next frequency bucket and update minFreq only when the vacated bucket was the minimum.
 *
 * ⚠ BUG in increaseFreq: minFreq is double-incremented when a bucket empties. See inline note.
 */
public class H_LFUCache {
    private final int capacity;
    private int minFreq;
    private final Map<Integer,Integer> keyToValue;
    private final Map<Integer,Integer> keyToFreq;
    // LinkedHashSet gives O(1) add/remove AND preserves insertion order →
    // iterator().next() always yields the LRU key within a frequency bucket
    private final Map<Integer,LinkedHashSet<Integer>> freqToKeys;

    public H_LFUCache(int capacity) {
        this.capacity=capacity;
        minFreq=0;
        keyToValue=new HashMap<>();
        keyToFreq=new HashMap<>();
        freqToKeys=new HashMap<>();
    }

    public int get(int key) {
        if(!keyToValue.containsKey(key)) return -1;
        increaseFreq(key);
        return keyToValue.get(key);
    }

    public void put(int key, int value) {
        if(capacity<=0) return;

        if(keyToValue.containsKey(key)){
            increaseFreq(key);          // update frequency before overwriting value
            keyToValue.put(key,value);
            return;
        }

        if(keyToValue.size()>=capacity){
            evict();
        }

        keyToValue.put(key,value);
        keyToFreq.put(key,1);
        freqToKeys.computeIfAbsent(1,k->new LinkedHashSet<>()).add(key);
        minFreq=1;                      // a new key always enters at frequency 1
    }

    public void increaseFreq(int key){
        int freq = keyToFreq.get(key);
        keyToFreq.put(key,freq+1);
        freqToKeys.get(freq).remove(key);

        if(freqToKeys.get(freq).isEmpty()){
            if(minFreq == freq) minFreq++;  // correct: vacated bucket was the min
        }

        freqToKeys.computeIfAbsent(freq+1,k->new LinkedHashSet<>()).add(key);
    }

    public void evict(){
        LinkedHashSet<Integer> minKeys = freqToKeys.get(minFreq);
        int evictKey = minKeys.iterator().next(); // LRU key in the lowest-freq bucket
        minKeys.remove(evictKey);
        if(minKeys.isEmpty()){
            freqToKeys.remove(minFreq);
        }
        keyToValue.remove(evictKey);
        keyToFreq.remove(evictKey);
    }
}
