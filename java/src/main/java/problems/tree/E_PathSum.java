package problems.tree;

import common.TreeNode;

/**
 * LC: 112
 * https://leetcode.com/problems/path-sum
 * Given the root of a binary tree and an integer targetSum, return true if the tree has a root-to-leaf path
 * such that adding up all the values along the path equals targetSum.
 *
 * A leaf is a node with no children.
 *
 * Approach: Recursion. Subtract the current value and continue until a leaf is reached.
 * Tags: Tree
 * Tags: DFS
 */
public class E_PathSum {

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }

        targetSum -= root.val;
        if (root.left == null && root.right == null) {
            return targetSum == 0;
        }

        return hasPathSum(root.left, targetSum) || hasPathSum(root.right, targetSum);
    }
}
