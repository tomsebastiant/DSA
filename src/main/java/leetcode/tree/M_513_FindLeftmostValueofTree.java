package leetcode.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 Tags:
 https://leetcode.com/problems/find-bottom-left-tree-value
 Given the root of a binary tree, return the leftmost value in the last row of the tree.

 Approach: Traverse in BFS using queue. When the queue is started to traversed
 we peek and record the first element and store it as leftMost. The leftMost at the end
 of traversal is the answer

 */
public class M_513_FindLeftmostValueofTree {
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        int leftMost=root.val;
        queue.add(root);
        while(!queue.isEmpty()){
            int width=queue.size();
            TreeNode node=queue.peek();
            leftMost=node.val;
            for(int i=0;i<width;i++){
                node=queue.remove();
                if(node.left!=null){
                    queue.add(node.left);
                }
                if(node.right!=null){
                    queue.add(node.right);
                }
            }
        }
        return leftMost;
    }
}
