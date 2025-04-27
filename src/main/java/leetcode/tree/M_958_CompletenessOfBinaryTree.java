package leetcode.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 Tags:
 https://leetcode.com/problems/check-completeness-of-a-binary-tree
 Given the root of a binary tree, determine if it is a complete binary tree.

 In a complete binary tree, every level, except possibly the last, is completely filled,
 and all nodes in the last level are as far left as possible. It can have between 1 and
 2h nodes inclusive at the last level h.

 Approach: We do BFS using queues. We add its children without checking for null. Once we reach a
 null node, if there are any non null node after that, then its a complete binary tree.

 */

public class M_958_CompletenessOfBinaryTree {
    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean end=false;
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(node==null){
                end=true;
            } else {
                if(end) return false;
                queue.offer(node.left);
                queue.offer(node.right);
            }
        }
        return true;
    }
}
