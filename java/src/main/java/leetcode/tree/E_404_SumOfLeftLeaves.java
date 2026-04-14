package leetcode.tree;

import java.util.Stack;

/**
 Tags:
 https://leetcode.com/problems/sort-list
 Given the root of a binary tree, return the sum of all left leaves.

 A leaf is a node with no children. A left leaf is a leaf that is the left child of another node.

 Approach: We traverse the tree using a stack and when we reach a left leaf we add it to the sum

 */
public class E_404_SumOfLeftLeaves {
    public int sumOfLeftLeaves(TreeNode root) {
        int sum=0;
        if(root==null){
            return sum;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            if(node.left!=null){
                if(node.left.left==null && node.left.right==null){
                    sum+=node.left.val;
                } else {
                    stack.push(node.left);
                }
            }
            if(node.right!=null){
                stack.push(node.right);
            }
        }
        return sum;
    }
}
