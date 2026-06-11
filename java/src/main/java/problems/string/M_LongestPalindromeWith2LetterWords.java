package problems.string;

import java.util.HashMap;

/**
 * LC: 2131
 * Tags: String
 * Tags: HashTable
 * Tags: Greedy
 * https://leetcode.com/problems/longest-palindrome-by-concatenating-two-letter-words/
 * You are given an array of strings words. Each element of words consists of two lowercase
 * English letters. Create the longest possible palindrome by selecting some elements from words
 * and concatenating them in any order. Each element can be selected at most once. Return the
 * length of the longest palindrome that you can create. If it is impossible to create any
 * palindrome, return 0.
 *
 * Constraints:
 * 1 <= words.length <= 10^5
 * words[i].length == 2
 * words[i] consists of lowercase English letters.
 *
 * Example 1:
 *
 * Input: words = ["lc","cl","gg"]
 * Output: 6
 * Explanation: One longest palindrome is "lc" + "gg" + "cl" = "lcggcl", length 6.
 *
 * Example 2:
 *
 * Input: words = ["ab","ty","yt","lc","cl","ab"]
 * Output: 8
 * Explanation: One longest palindrome is "ty" + "lc" + "cl" + "yt" = "tylcclyt", length 8.
 *
 * Example 3:
 *
 * Input: words = ["cc","ll","xx"]
 * Output: 2
 * Explanation: Only one palindromic word ("cc", "ll", or "xx") can sit at the center.
 *
 * Approach: Count word frequencies with a HashMap, then greedily pair words with their reverses.
 * Self-palindromic words (e.g. "aa") contribute 4 per pair placed symmetrically; one instance
 * with an odd count can occupy the center (worth 2). Non-palindromic mirrors ("lc"/"cl") each
 * matched pair contributes 4. Process each mirror pair once using lexicographic ordering to avoid
 * double-counting.
 */
public class M_LongestPalindromeWith2LetterWords {
        public int longestPalindrome(String[] words) {
        HashMap<String, Integer> map = new HashMap<>();
        for(String word:words){
            map.put(word,map.getOrDefault(word,0)+1);
        }

        int result=0;
        boolean centreFound=false;

        for (String word : map.keySet()) {
            String rev = ""+word.charAt(1)+word.charAt(0);

            if(word.equals(rev)){
                // self-palindromic word (e.g. "aa"): each pair fills one slot on each side → 4 chars
                int pairs = map.get(word)/2;
                result = result+pairs*4;

                // one leftover self-palindromic word can sit at the center of the whole palindrome
                if(!centreFound && map.get(word)%2==1){
                    centreFound=true;
                }
            } else if(word.compareTo(rev)<0 && map.containsKey(rev)){
                // process each mirror pair (e.g. "lc"/"cl") only once via lexicographic guard
                int mirrors = Math.min(map.get(word),map.get(rev));
                result = result+mirrors*4;
            }
        }

        return result + (centreFound ? 2 : 0);
    }
}
