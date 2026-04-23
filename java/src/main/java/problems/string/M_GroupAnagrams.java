package problems.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * LC: 49
 * https://leetcode.com/problems/group-anagrams/
 * Given an array of strings strs, group the anagrams together. You can return the answer in any order.
 *
 * An anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
 * typically using all the original letters exactly once.
 *
 * Example 1:
 *
 * Input: strs = ["eat","tea","tan","ate","nat","bat"]
 * Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
 *
 * Example 2:
 *
 * Input: strs = [""]
 * Output: [[""]]
 *
 * Approach: Sort the characters of each string and use the sorted string as the hash map key.
 * Strings with the same sorted key are anagrams and belong to the same group.
 * Tags: String
 * Tags: HashMap
 * Tags: Sorting
 */
public class M_GroupAnagrams {
        public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> anagramMap = new HashMap<>();
        for(String str:strs){
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            if(anagramMap.containsKey(key)){
                List<String> list = anagramMap.get(key);
                list.add(str);
                anagramMap.put(key,list);
            } else {
                List<String> list = new ArrayList<>();
                list.add(str);
                anagramMap.put(key,list);
            }
        }
        List<List<String>> output = new ArrayList<>(anagramMap.values());
        return output;

    }
}
