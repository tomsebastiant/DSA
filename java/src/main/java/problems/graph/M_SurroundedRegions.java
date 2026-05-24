package problems.graph;

/**
 * LC: 130
 * Tags: Array
 * Tags: Graph
 * Tags: DFS
 * https://leetcode.com/problems/surrounded-regions/
 * Given a 2-D matrix containing 'X' and 'O' characters, identify regions of 'O's that are
 * completely enclosed by 'X's through four-directional connectivity. Convert all such surrounded
 * regions to 'X's while modifying the input board in-place. An 'O' region is NOT surrounded if
 * any cell in it touches the border of the board.
 *
 * Constraints:
 * 1 <= board.length, board[i].length <= 200
 * board[i][j] is 'X' or 'O'
 *
 * Example 1:
 *
 * Input: board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]
 * Output:        [["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]
 * Explanation: The 'O' in the bottom-left is connected to the border, so it survives.
 *              The interior 'O' region is fully surrounded and gets flipped to 'X'.
 *
 * Example 2:
 *
 * Input: board = [["X"]]
 * Output:        [["X"]]
 *
 * Approach: Instead of hunting for surrounded O's directly, invert the problem — DFS from every
 * border 'O' and mark reachable O's with a sentinel '#' (meaning "safe, do not flip"). Then a
 * single pass converts all remaining 'O's (surrounded) to 'X' and restores '#' back to 'O'.
 */
public class M_SurroundedRegions {
        public void solve(char[][] board) {
        int m=board.length;
        int n=board[0].length;

        // seed DFS from every 'O' on the left and right borders
        for(int i=0;i<m;i++){
            if(board[i][0]=='O') dfs(board,i,0);
            if(board[i][n-1]=='O') dfs(board,i,n-1);
        }

        // seed DFS from every 'O' on the top and bottom borders
        for(int j=0;j<n;j++){
            if(board[0][j]=='O') dfs(board,0,j);
            if(board[m-1][j]=='O') dfs(board,m-1,j);
        }

        // 'O' = surrounded (never reached from border) → flip to 'X'
        // '#' = safe (border-connected) → restore to 'O'
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]=='O') board[i][j]='X';
                else if(board[i][j]=='#') board[i][j]='O';
            }
        }

    }

    public void dfs(char[][] board, int i, int j){
        if(i<0 || i>=board.length || j<0 || j>=board[0].length) return;
        if(board[i][j]!='O') return;
        board[i][j]='#'; // mark as safe so we don't revisit and don't flip it later
        dfs(board,i+1,j);
        dfs(board,i-1,j);
        dfs(board,i,j+1);
        dfs(board,i,j-1);
    }

}
