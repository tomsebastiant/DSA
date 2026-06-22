package problems.backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * LC: 140
 * Tags: DynamicProgramming
 * Tags: DFS
 * https://leetcode.com/problems/word-break-ii/
 * Given a string s and a dictionary of strings wordDict, add spaces in s to construct a sentence
 * where each word is a valid dictionary word. Return all such possible sentences in any order.
 * Note that the same word in the dictionary may be reused multiple times in the segmentation.
 *
 * Constraints:
 * 1 <= s.length <= 20
 * 1 <= wordDict.length <= 1000
 * 1 <= wordDict[i].length <= 10
 * s and wordDict[i] consist of only lowercase English letters.
 * All strings of wordDict are unique.
 *
 * Example 1:
 *
 * Input: s = "catsanddog", wordDict = ["cat","cats","and","sand","dog"]
 * Output: ["cats and dog","cat sand dog"]
 *
 * Example 2:
 *
 * Input: s = "pineapplepenapple",
 *        wordDict = ["apple","pen","applepen","pine","pineapple"]
 * Output: ["pine apple pen apple","pineapple pen apple","pine applepen apple"]
 *
 * Example 3:
 *
 * Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
 * Output: []
 *
 * Approach: DFS over the string with memoization by start index (top-down DP). At each position,
 * try every prefix that exists in the dictionary, then recursively collect all sentences for the
 * remaining suffix. Caching results by start index avoids recomputing the same suffix multiple
 * times when different prefixes lead to the same remainder position.
 */
public class H_WordBreak2 {
        Map<Integer,List<String>> memo = new HashMap<>();
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict);
        return dfs(s,0,dict);
    }

    public List<String> dfs(String word, int start, Set<String> dict){
        if(memo.containsKey(start)){
            return memo.get(start);
        }

        List<String> result = new ArrayList<>();

        if(start == word.length()){
            // sentinel: returning [""] lets the caller prepend its word with a space separator
            result.add("");
            return result;
        }

        for(int j=start+1;j<=word.length();j++){
            String curr=word.substring(start,j);
            if(dict.contains(curr)){
                List<String> rest = dfs(word,j,dict);
                for(String sentence:rest){
                    // skip the leading space when sentence is the sentinel empty string
                    result.add(curr + (sentence.isEmpty()?"": " "+sentence));
                }
            }
        }
        memo.put(start,result);
        return result;
    }
}
