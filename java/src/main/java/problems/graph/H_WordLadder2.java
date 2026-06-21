package problems.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * LC: 126
 * Tags: Graph
 * Tags: BFS
 * Tags: DFS
 * https://leetcode.com/problems/word-ladder-ii/
 * A transformation sequence from word beginWord to word endWord using a dictionary wordList is a
 * sequence beginWord -> s1 -> s2 -> ... -> sk such that every adjacent pair differs by a single
 * letter, and every si (1 <= i <= k) is in wordList. Given beginWord, endWord, and wordList,
 * return all the shortest transformation sequences from beginWord to endWord, or an empty list if
 * no such sequence exists. Each sequence should be returned as a list of the words in the sequence.
 *
 * Constraints:
 * 1 <= beginWord.length <= 5
 * endWord.length == beginWord.length
 * 1 <= wordList.length <= 500
 * wordList[i].length == beginWord.length
 * beginWord, endWord, and wordList[i] consist of lowercase English letters.
 * beginWord != endWord
 * All words in wordList are unique.
 *
 * Example 1:
 *
 * Input: beginWord = "hit", endWord = "cog",
 *        wordList = ["hot","dot","dog","lot","log","cog"]
 * Output: [["hit","hot","dot","dog","cog"],["hit","hot","lot","log","cog"]]
 *
 * Example 2:
 *
 * Input: beginWord = "hit", endWord = "cog",
 *        wordList = ["hot","dot","dog","lot","log"]
 * Output: []
 * Explanation: endWord "cog" is not in wordList, so no valid transformation exists.
 *
 * Approach: Two-phase BFS + backtracking. BFS expands level-by-level and builds a parents map
 * (word → all predecessors one level above) so that every shortest path is captured. Removing
 * the entire current level from wordSet before exploring the next level prevents same-level nodes
 * from becoming each other's parents while still letting multiple current-level words share the
 * same next-level neighbour. Once endWord is reached the BFS stops; a DFS backtrack then traces
 * all paths from endWord to beginWord through the parents map and reverses each to get the
 * forward sequence.
 */
public class H_WordLadder2 {
        public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>();
        for(String word:wordList){
            wordSet.add(word);
        }
        List<List<String>> result = new ArrayList<>();
        if(!wordSet.contains(endWord)) return result;

        // parents.get(w) = all words one BFS level above w that can transform into w
        Map<String,List<String>> parents = new HashMap<>();
        Set<String> currLevel = new HashSet<>();
        currLevel.add(beginWord);
        boolean found=false;

        while(!currLevel.isEmpty() && !found){
            // remove the whole level before expanding so no same-level word is used as a parent
            for(String w:currLevel){
                wordSet.remove(w);
            }

            Set<String> nextLevel = new HashSet<>();

            for(String word:currLevel){
                char[] wordArray = word.toCharArray();
                for(int i=0;i<word.length();i++){
                    char orig=wordArray[i];
                    for(char j='a';j<='z';j++){
                        wordArray[i]=j;
                        String next = new String(wordArray);
                        if(wordSet.contains(next)){
                            // set found but keep finishing this level — other words may also reach endWord
                            if(next.equals(endWord)) found=true;
                            nextLevel.add(next);
                            // a word can have multiple parents when several shortest paths converge
                            parents.computeIfAbsent(next,k->new ArrayList<>()).add(word);
                        }
                    }
                    wordArray[i]=orig;
                }

            }
            currLevel=nextLevel;
        }

        List<String> currLadder = new ArrayList<>();
        currLadder.add(endWord);
        // backtrack traces endWord → beginWord through parents; each complete path is reversed to restore forward order
        backtrack(endWord,currLadder,beginWord,parents,result);
        return result;
    }

    // currWord: current position tracing backward; endWord param is actually beginWord — termination when reached
    public void backtrack(String currWord,List<String> currLadder,String endWord,Map<String,List<String>> parents,List<List<String>> result ){
        if(currWord.equals(endWord)){
            List<String> ladder = new ArrayList<>(currLadder);
            Collections.reverse(ladder);
            result.add(ladder);
            return;
        }

        List<String> ps = parents.get(currWord);
        if(ps == null) return;
        for(String parent:ps){
            currLadder.add(parent);
            backtrack(parent,currLadder,endWord,parents,result);
            currLadder.remove(currLadder.size()-1);
        }

    }
}
