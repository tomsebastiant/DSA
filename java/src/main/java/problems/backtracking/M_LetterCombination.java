package problems.backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * LC: 17
 * Tags: String
 * Tags: DFS
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 * Given a string containing digits from 2-9, return all possible letter combinations that the
 * number could represent, in any order. The mapping follows a standard telephone keypad.
 *
 * Example 1:
 *
 * Input: digits = "23"
 * Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
 *
 * Example 2:
 *
 * Input: digits = ""
 * Output: []
 *
 * Example 3:
 *
 * Input: digits = "2"
 * Output: ["a","b","c"]
 *
 * Approach: Backtracking — at each index pick every letter mapped to that digit, recurse to the
 * next digit, then undo the choice. When the combination length equals digits.length(), record it.
 * This explores all letter choices depth-first, building combinations character by character.
 */
public class M_LetterCombination {
        private static final Map<Character, String> PAD = Map.of(
        '2', "abc", '3', "def", '4', "ghi", '5', "jkl",
        '6', "mno", '7', "pqrs", '8', "tuv", '9', "wxyz"
    );

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if(digits == null || digits == ""){
            return result;
        }
        backtrack(digits,0,new StringBuilder(),result);
        return result;
    }

    public void backtrack(String digit, int index, StringBuilder curr, List<String> result){
        if(index==digit.length()){
            result.add(curr.toString());
            return;
        }

        for(char c:PAD.get(digit.charAt(index)).toCharArray()){
            curr.append(c);
            backtrack(digit,index+1,curr,result);
            curr.deleteCharAt(curr.length()-1);
        }
    }
}
