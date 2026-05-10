package problems.string;

/**
 * LC: 208
 * Tags: String
 * Tags: Design
 * https://leetcode.com/problems/implement-trie-prefix-tree/
 * A trie (pronounced as "try") or prefix tree is a tree data structure used to efficiently store
 * and retrieve keys in a dataset of strings. There are various applications of this data structure,
 * such as autocomplete and spellchecker.
 *
 * Implement the Trie class:
 * - Trie() initializes the trie object.
 * - void insert(String word) inserts the string word into the trie.
 * - boolean search(String word) returns true if word is in the trie, false otherwise.
 * - boolean startsWith(String prefix) returns true if any inserted word has the given prefix.
 *
 * Example 1:
 *
 * Input: ["Trie","insert","search","search","startsWith","insert","search"]
 *        [[],["apple"],["apple"],["app"],["app"],["app"],["app"]]
 * Output: [null,null,true,false,true,null,true]
 * Explanation:
 * Trie trie = new Trie();
 * trie.insert("apple");    // Inserts "apple"
 * trie.search("apple");    // return true
 * trie.search("app");      // return false, "app" was not inserted
 * trie.startsWith("app");  // return true
 * trie.insert("app");
 * trie.search("app");      // return true
 *
 * Constraints:
 * 1 <= word.length, prefix.length <= 2000
 * word and prefix consist only of lowercase English letters.
 * At most 3 * 10^4 calls in total will be made to insert, search, and startsWith.
 *
 * Approach: Each TrieNode holds a 26-slot children array (one per lowercase letter) and an isEnd
 * flag. insert walks character by character, creating nodes on demand, and marks the final node.
 * search traverses the same path and returns true only if the traversal completes AND the last
 * node is marked isEnd. startsWith is identical but returns true on any complete prefix traversal
 * regardless of isEnd — the only difference between a prefix match and a full-word match.
 */
public class M_Trie {
        private TrieNode root;
    private static class TrieNode{
        TrieNode[] children = new TrieNode[26];
        boolean isEnd = false;
    }
    public M_Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode curr =root;
        for(char c:word.toCharArray()){
            int idx=c-'a';
            if(curr.children[idx]==null){
                curr.children[idx]=new TrieNode();
            }
            curr=curr.children[idx];
        }
        // Mark the terminal node so search can distinguish a full word from a prefix.
        curr.isEnd=true;
    }

    public boolean search(String word) {
        TrieNode curr = root;
        for(char c:word.toCharArray()){
            int idx=c-'a';
            if(curr.children[idx]==null) return false;
            curr=curr.children[idx];
        }
        return curr.isEnd;
    }

    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for(char c:prefix.toCharArray()){
            int idx=c-'a';
            if(curr.children[idx]==null) return false;
            curr=curr.children[idx];
        }
        // Any reachable node means the prefix exists — isEnd is irrelevant here.
        return true;
    }
}
