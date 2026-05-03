package problems.tree;

import common.TreeNode;
import java.util.HashMap;
import java.util.Map;

/**
 * LC: 105
 * https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal
 * Given two integer arrays preorder and inorder where preorder is the preorder traversal
 * of a binary tree and inorder is the inorder traversal of the same tree, construct and return the binary tree.
 *
 * Example 1:
 *
 * Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
 * Output: [3,9,20,null,null,15,7]
 *
 * Approach: Recursion. The first preorder value is the root, and the inorder split tells us the left and right subtrees.
 * Use a HashMap to find each root value in the inorder array in O(1) time.
 * Tags: Tree
 * Tags: DFS
 */

public class M_BuildTreeFromInorderPreorder {
    int preIndex;
    Map<Integer,Integer> inorderMap;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        preIndex = 0;
        inorderMap = new HashMap<>();

        // Store each value's inorder position so we can split left/right subtrees in O(1).
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }

        // The whole inorder range is available at the start.
        return helper(preorder, 0, inorder.length - 1);
    }

    public TreeNode helper(int[] preorder, int start, int end) {
        // No inorder elements left in this range, so this subtree is empty.
        if (start > end) return null;

        // Preorder always visits the root before its subtrees.
        int val = preorder[preIndex++];
        TreeNode root = new TreeNode(val);

        int inorderIndex = inorderMap.get(val);
        // Everything left of root in inorder belongs to the left subtree.
        root.left = helper(preorder, start, inorderIndex - 1);
        // Everything right of root in inorder belongs to the right subtree.
        root.right = helper(preorder, inorderIndex + 1, end);

        return root;
    }
}




