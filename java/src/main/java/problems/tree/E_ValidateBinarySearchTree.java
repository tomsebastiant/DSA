package problems.tree;

import common.TreeNode;

/**
 * LC: 98
 * https://leetcode.com/problems/validate-binary-search-tree
 * Given the root of a binary tree, determine if it is a valid binary search tree (BST).
 *
 * A valid BST follows the rule that every node in the left subtree is strictly smaller than the node,
 * and every node in the right subtree is strictly larger than the node.
 *
 * Approach: DFS with a valid value range for every node.
 * Tags: Tree
 * Tags: DFS
 * Tags: Binary Search Tree
 */
public class E_ValidateBinarySearchTree {

    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBST(TreeNode root, long min, long max) {
        if (root == null) {
            return true;
        }

        if (root.val <= min || root.val >= max) {
            return false;
        }

        return isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);
    }
}
