package leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 https://leetcode.com/problems/binary-tree-inorder-traversal
 Given the root of a binary tree, return the inorder traversal of its nodes' values.

 Approach 1 :Recursion
 Traverse using recursion. Traverse left node, add current value, traverse right node

 Approach 2 :Iteration
 In a stack contstantly add the left node, till we reach the end. Add the last node reached.
 Move to the right value after that

 while (curr != null || !stack.isEmpty()) {
     while (curr != null) {
         stack.push(curr);
         curr = curr.left;
     }
     curr = stack.pop();
     res.add(curr.val);
     curr = curr.right;
 }

 */
public class E_94_BinaryTreeInorder {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> output = new ArrayList<>();
        inOrder(root,output);
        return output;
    }

    public void inOrder(TreeNode root, List output){
        if(root == null) return;

        inOrder(root.left,output);
        output.add(root.val);
        inOrder(root.right,output);

    }
}
