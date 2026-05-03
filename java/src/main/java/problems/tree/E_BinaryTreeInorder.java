package problems.tree;

import common.TreeNode;
import java.util.ArrayList;
import java.util.List;

/**
 * LC: 94
 * https://leetcode.com/problems/binary-tree-inorder-traversal
 * Given the root of a binary tree, return the inorder traversal of its nodes' values.
 *
 * Example 1:
 *
 * Input: root = [1,null,2,3]
 * Output: [1,3,2]
 *
 * Approach: Recursion. Traverse the left subtree, then the current node, then the right subtree.
 * Tags: Tree
 * Tags: DFS
 */
public class E_BinaryTreeInorder {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> output = new ArrayList<>();
        inOrder(root,output);
        return output;
    }

    private void inOrder(TreeNode root, List<Integer> output){
        if(root == null) return;

        inOrder(root.left,output);
        output.add(root.val);
        inOrder(root.right,output);
    }
}




