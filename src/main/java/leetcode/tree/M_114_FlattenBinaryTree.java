package leetcode.tree;

import java.util.Stack;

/**
 Tags:
 https://leetcode.com/problems/flatten-binary-tree-to-linked-list
 Given the root of a binary tree, flatten the tree into a "linked list":

 The "linked list" should use the same TreeNode class where the right child pointer points
 to the next node in the list and the left child pointer is always null.
 The "linked list" should be in the same order as a pre-order traversal of the binary tree.

 Approach: We use a stack and push in the root. In the  while loop, we pop it out,
 push in the RIGHT and LEFT node, then set the left child of the popped node to
 null and right child to the peek of the stack.
 This ensures that pre-order traversal is maintained in the stack

 */
public class M_114_FlattenBinaryTree {
    public void flatten(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        if(root==null){
            return;
        }
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            if(node.right!=null){
                stack.push(node.right);
            }
            if(node.left!=null){
                stack.push(node.left);
            }
            if(!stack.isEmpty()){
                node.right=stack.peek();
            }
            node.left=null;
        }
    }
}
