package problems.dynamicprogramming;

/**
 * LC: 72
 * Tags: DynamicProgramming
 * Tags: String
 * https://leetcode.com/problems/edit-distance/
 * Given two strings word1 and word2, return the minimum number of operations required to convert
 * word1 to word2. You have the following three operations permitted on a word:
 * - Insert a character
 * - Delete a character
 * - Replace a character
 *
 * Example 1:
 *
 * Input: word1 = "horse", word2 = "ros"
 * Output: 3
 * Explanation:
 * horse -> rorse (replace 'h' with 'r')
 * rorse -> rose  (delete 'r')
 * rose  -> ros   (delete 'e')
 *
 * Example 2:
 *
 * Input: word1 = "intention", word2 = "execution"
 * Output: 5
 * Explanation:
 * intention -> inention  (delete 't')
 * inention  -> enention  (replace 'i' with 'e')
 * enention  -> exention  (replace 'n' with 'x')
 * exention  -> exection  (replace 'n' with 'c')
 * exection  -> execution (insert 'u')
 *
 * Constraints:
 * 0 <= word1.length, word2.length <= 500
 * word1 and word2 consist of lowercase English letters.
 *
 * Approach: 2D DP where dp[i][j] is the minimum edit distance between the first i characters of
 * word1 and the first j characters of word2. Base cases fill the edges: converting a prefix of
 * length i to an empty string costs i deletions, and converting empty to a prefix of length j
 * costs j insertions. When the current characters match no operation is needed and we carry the
 * diagonal. Otherwise we take 1 + the minimum of three sub-problems: replace (diagonal),
 * delete from word1 (above), or insert into word1 (left).
 */
public class M_EditDistance {
        public int minDistance(String word1, String word2) {
        int m=word1.length();
        int n=word2.length();

        int[][] dp= new int[m+1][n+1];

        // dp[i][0]: delete all i characters of word1 to reach empty string.
        for(int i=0;i<=m;i++) dp[i][0] = i;
        // dp[0][j]: insert all j characters of word2 from empty string.
        for(int j=0;j<=n;j++) dp[0][j] = j;

        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(word1.charAt(i-1)==word2.charAt(j-1)){
                    // Characters match — no operation needed, inherit the cost from both prefixes.
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    // dp[i-1][j-1]+1 = replace, dp[i-1][j]+1 = delete from word1, dp[i][j-1]+1 = insert into word1.
                    dp[i][j] = 1+ Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1]));
                }
            }
        }

        return dp[m][n];
    }
}
