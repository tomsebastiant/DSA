package problems.tree;

import common.TreeNode;

/**
 * LC: 104
 * https://leetcode.com/problems/maximum-depth-of-binary-tree
 * Given the root of a binary tree, return its maximum depth.
 *
 * A binary tree's maximum depth is the number of nodes along the longest
 * path from the root node down to the farthest leaf node.
 *
 * Approach: Recursion. The depth at a current node is 1 + max depth of its left or right subtree.
 * Tags: Tree
 * Tags: DFS
 */
public class E_MaxDepthOfBinaryTree {

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}
