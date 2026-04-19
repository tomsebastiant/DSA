package problems.tree;

import common.TreeNode;

/**
 * LC: 101
 * https://leetcode.com/problems/symmetric-tree
 * Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).
 *
 * Approach: Recursion. The left subtree must mirror the right subtree at every level.
 * Tags: Tree
 * Tags: DFS
 */
public class E_SymmetricTree {

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isMirror(root.left, root.right);
    }

    private boolean isMirror(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return true;
        }
        if (node1 == null || node2 == null) {
            return false;
        }
        return node1.val == node2.val
                && isMirror(node1.left, node2.right)
                && isMirror(node1.right, node2.left);
    }
}
