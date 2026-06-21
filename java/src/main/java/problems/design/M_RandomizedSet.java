package problems.design;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * LC: 380
 * Tags: Design
 * Tags: HashTable
 * Tags: Array
 * https://leetcode.com/problems/insert-delete-getrandom-o1/
 * Implement the RandomizedSet class:
 * - RandomizedSet() initializes the object.
 * - bool insert(int val) inserts an element val into the set if not present. Returns true if
 *   the item was not present, false otherwise.
 * - bool remove(int val) removes an element val from the set if present. Returns true if the
 *   item was present, false otherwise.
 * - int getRandom() returns a random element from the current set of elements. Each element
 *   must have equal probability of being returned.
 * All functions must run in average O(1) time complexity.
 *
 * Constraints:
 * -2^31 <= val <= 2^31 - 1
 * At most 2 * 10^5 calls will be made to insert, remove, and getRandom.
 * There will be at least one element when getRandom is called.
 *
 * Example 1:
 *
 * Input:  ["RandomizedSet","insert","remove","insert","getRandom","remove","insert","getRandom"]
 *         [[],[1],[2],[2],[],[1],[2],[]]
 * Output: [null,true,false,true,2,true,false,2]
 * Explanation:
 * insert(1) → true; remove(2) → false (not present); insert(2) → true;
 * getRandom() → 2 (from {1,2}); remove(1) → true; insert(2) → false (duplicate);
 * getRandom() → 2 (only element).
 *
 * Approach: Pair an ArrayList (O(1) random access by index) with a HashMap (value → index, for
 * O(1) lookup and existence checks). insert appends to the end and records the new index.
 * remove swaps the target with the last element and pops the tail — this keeps the list dense
 * and avoids the O(n) cost of shifting elements. getRandom picks a uniformly random index.
 */
public class M_RandomizedSet {
        List<Integer> list;
    Map<Integer,Integer> map;
    Random rand;

    public M_RandomizedSet() {
        list = new ArrayList<>();
        map = new HashMap<>();
        rand = new Random();
    }
    
    public boolean insert(int val) {
        if(map.containsKey(val)) return false;

        list.add(val);
        map.put(val,list.size()-1);
        return true;
    }
    
    public boolean remove(int val) {
        if(!map.containsKey(val)) return false;

        int pos = map.get(val);
        int lastElement = list.get(list.size()-1);

        // overwrite the target slot with the last element — keeps the list gap-free
        list.set(pos,lastElement);
        // update the map before removing val in case val == lastElement (would erase the entry)
        map.put(lastElement,pos);

        map.remove(val);
        list.remove(list.size()-1);   // O(1) tail removal; no shifting needed
        return true;
    }
    
    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }
}
