package leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 Tags:
 https://leetcode.com/problems/find-largest-value-in-each-tree-row
 Given the root of a binary tree, return an array of the largest value in each row of the tree (0-indexed).

 Approach 1: Traverse using DFS recursion and pass in the level index. At each level index compare if the current
 node value is the largest, then assign it.

 Approach 2: Traverse it using BFS using queues. In each iteration compare and find the highest value

 */
public class M_515_LargestValueInTreeRow {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> out = new ArrayList<>();
        DFS(root,out,0);
        return out;
    }

    public void DFS(TreeNode root, List<Integer> out, int level){
        if(root==null)
            return;

        if(level==out.size()){
            out.add(root.val);
        } else {
            out.set(level,Math.max(out.get(level),root.val));
        }

        DFS(root.left,out,level+1);
        DFS(root.right,out,level+1);
    }
}
