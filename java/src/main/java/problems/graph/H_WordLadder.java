package problems.graph;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * LC: 127
 * Tags: Graph
 * Tags: BFS
 * Tags: HashSet
 * Tags: String
 * https://leetcode.com/problems/word-ladder/
 * A transformation sequence from word beginWord to word endWord using a dictionary wordList
 * is a sequence of words beginWord -> s1 -> s2 -> ... -> sk such that:
 * - Every adjacent pair of words differs by exactly a single letter.
 * - Every si for 1 <= i <= k is in wordList. Note that beginWord does not need to be in wordList.
 * - sk == endWord
 *
 * Given two words, beginWord and endWord, and a dictionary wordList, return the number of words
 * in the shortest transformation sequence from beginWord to endWord, or 0 if no such sequence exists.
 *
 * Example 1:
 *
 * Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
 * Output: 5
 * Explanation: One shortest transformation sequence is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * which is 5 words long.
 *
 * Example 2:
 *
 * Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]
 * Output: 0
 * Explanation: The endWord "cog" is not in wordList, therefore there is no valid transformation sequence.
 *
 * Constraints:
 * 1 <= beginWord.length <= 10
 * endWord.length == beginWord.length
 * 1 <= wordList.length <= 5000
 * wordList[i].length == beginWord.length
 * beginWord, endWord, and wordList[i] consist of lowercase English letters.
 * beginWord != endWord
 * All the words in wordList are unique.
 *
 * Approach: BFS level-by-level from beginWord. At each position, try substituting every letter a-z
 * to generate all one-edit neighbours. The first time we produce endWord we return the current step
 * count + 1, which is guaranteed to be the shortest path. Removing each visited word from the set
 * immediately prevents revisiting and keeps the BFS acyclic.
 */
public class H_WordLadder {
        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        // If endWord isn't reachable at all, no transformation sequence can exist.
        if(!wordList.contains(endWord)) return 0;
        Queue<String> queue = new ArrayDeque<>();
        queue.offer(beginWord);
        int steps=1;
        while(!queue.isEmpty()){
            // Snapshot the level size so we increment steps once per BFS depth, not per word.
            int size = queue.size();
            for(int i=0;i<size;i++){
                char[] currArray = queue.poll().toCharArray();
                for(int j=0;j<currArray.length;j++){
                    // Save the original character so we can restore it after trying all substitutions.
                    char orig=currArray[j];
                    for(char k='a';k<='z';k++){
                        currArray[j]=k;
                        String newWord = new String(currArray);
                        if(newWord.equals(endWord)) return steps+1;
                        if(set.contains(newWord)){
                            queue.add(newWord);
                            // Remove immediately (not end-of-level) to block duplicate enqueues.
                            set.remove(newWord);
                        }
                    }
                    currArray[j]=orig;
                }
            }
            steps++;
        }
        return 0;
    }
}
