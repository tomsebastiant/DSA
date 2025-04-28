package leetcode.tree;

import java.util.HashMap;
import java.util.Map;

/**
 Tags:
 https://leetcode.com/problems/maximum-width-of-binary-tree
 Given the root of a binary tree, return the maximum width of the given tree.

 The maximum width of a tree is the maximum width among all levels.

 The width of one level is defined as the length between the end-nodes (the leftmost  and
 rightmost non-null nodes), where the null nodes between the end-nodes that would be
 present in a complete binary tree extending down to that level are also counted into the length calculation.

 It is guaranteed that the answer will in the range of a 32-bit signed integer.

 Approach: During DFS track the index of each node (left->2*i+1,right->2*i+2) and
 depth. When we reach a new depth, we save the index of the first node as leftmost into
 a map. For the remaining nodes in the same depth we compare with leftmost and find the width

 */

public class M_662_MaxWidthOfBinaryTree {
    int maxWidth;
    public int widthOfBinaryTree(TreeNode root) {
        maxWidth=0;
        Map<Integer,Integer> leftMost = new HashMap<>();
        if(root==null){
            return maxWidth;
        }
        findWidth(root,0,0,leftMost);
        return maxWidth;
    }

    public void findWidth(TreeNode node, int depth, int index, Map<Integer,Integer> leftMost){
        if(node==null){
            return;
        }
        if(!leftMost.containsKey(depth)){
            leftMost.put(depth,index);
        }
        maxWidth=Math.max(maxWidth,index-leftMost.get(depth)+1);

        findWidth(node.left,depth+1,2*index+1,leftMost);
        findWidth(node.right,depth+1,2*index+2,leftMost);
    }
}
