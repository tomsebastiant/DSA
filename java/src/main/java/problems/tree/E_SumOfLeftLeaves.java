package problems.tree;

import common.TreeNode;
import java.util.Stack;

/**
 * LC: 404
 * https://leetcode.com/problems/sum-of-left-leaves
 * Given the root of a binary tree, return the sum of all left leaves.
 *
 * A leaf is a node with no children. A left leaf is a leaf that is the left child of another node.
 *
 * Approach: Traverse the tree iteratively using a stack. When the top of the stack has a left
 * child that is a leaf, accumulate its value; otherwise push it for further traversal.
 * Tags: Tree
 * Tags: DFS
 */
public class E_SumOfLeftLeaves {
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



