package leetcode.tree;

/**
 Tags:
 https://leetcode.com/problems/distribute-coins-in-binary-tree
 You are given the root of a binary tree with n nodes where each node in the
 tree has node.val coins. There are n coins in total throughout the whole tree.

 In one move, we may choose two adjacent nodes and move one coin from one node to
 another. A move may be from parent to child, or from child to parent.

 Return the minimum number of moves required to make every node have exactly one coin.

 Approach: We start from the leaf nodes how to distribute the coins, so we do postorder DFS.
 From each node, one coin has to be left there only and the rest moved to its parent to be distributed

 */

public class M_979_DistributeCoinsBinaryTree {
    int moves;
    public int distributeCoins(TreeNode root) {
        moves=0;
        DFS(root);
        return moves;
    }

    public int DFS(TreeNode root){
        if(root==null) return 0;
        int leftCoins = DFS(root.left);
        int rightCoins = DFS(root.right);

        moves += Math.abs(leftCoins) + Math.abs(rightCoins);

        return root.val -1 + leftCoins + rightCoins;
    }
}
