package problems.string;

import java.util.ArrayList;
import java.util.List;

/**
 * LC: 68
 * Tags: String
 * https://leetcode.com/problems/text-justification/
 * Given an array of strings words and a width maxWidth, format the text such that each line has
 * exactly maxWidth characters and is fully (left and right) justified. Pack as many words as you
 * can in each line. Pad extra spaces ' ' when necessary so that each line has exactly maxWidth
 * characters. Extra spaces between words should be distributed as evenly as possible. If the
 * number of spaces on a line does not divide evenly between words, the empty slots on the left
 * will be assigned more spaces than the slots on the right. For the last line of text, it should
 * be left-justified and no extra space is inserted between words.
 *
 * Constraints:
 * 1 <= words.length <= 300
 * 1 <= words[i].length <= 20
 * words[i] consists of only English letters and symbols.
 * 1 <= maxWidth <= 100
 * words[i].length <= maxWidth
 *
 * Example 1:
 *
 * Input: words = ["This","is","an","example","of","text","justification."], maxWidth = 16
 * Output: ["This    is    an","example  of text","justification.  "]
 *
 * Example 2:
 *
 * Input: words = ["What","must","be","acknowledgment","shall","be"], maxWidth = 16
 * Output: ["What   must   be","acknowledgment  ","shall be        "]
 * Explanation: "acknowledgment" fills an entire line alone — treated as single-word, left-justified.
 * The last line "shall be" is also left-justified with trailing spaces.
 *
 * Approach: Two-phase simulation. Phase 1 greedily packs words into lines (counting one mandatory
 * space between each pair). Phase 2 (buildLine) formats each line: the last line and single-word
 * lines are left-justified with trailing spaces; all others distribute spaces evenly across gaps,
 * giving one extra space to the leftmost gaps when the total does not divide evenly.
 */
public class H_TextJustification {
        public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int i=0;
        int n= words.length;

        while(i<n){
            int lineLen = words[i].length();
            int j=i+1;
            // +1 accounts for the minimum one space separator between consecutive words
            while(j<n && lineLen+1+words[j].length()<=maxWidth){
                lineLen=lineLen+1+words[j].length();
                j++;
            }

            result.add(buildLine(i,j,words,maxWidth));
            i=j;
        }
        return result;
    }

    public String buildLine(int start, int end, String[] words, int maxWidth){
        int size=end-start;
        int totalChars=0;
        for(int k=start;k<end;k++) totalChars+=words[k].length();

        StringBuilder sb = new StringBuilder();
        sb.append(words[start]);

        // last line (end==words.length) and single-word lines must be left-justified
        if(end == words.length || size==1){
            for(int k=start+1;k<end;k++){
                sb.append(' ').append(words[k]);
            }
            while(sb.length()<maxWidth) sb.append(' ');
            return sb.toString();
        }

        int gaps = size-1;
        int totalSpaces = maxWidth-totalChars;
        int gapSize = totalSpaces/gaps;   // base spaces every gap receives
        int extra = totalSpaces%gaps;     // first `extra` gaps each get one additional space

        for(int k=start+1;k<end;k++){
            // k-start is the 1-based gap index; gaps 1..extra are the leftmost and get the extra space
            int spaces = gapSize + (k-start<=extra ? 1 : 0);
            for(int t=0;t<spaces;t++) sb.append(' ');
            sb.append(words[k]);
        }
        return sb.toString();
    }
}
