package problems.tree;

import common.TreeNode;
import java.util.ArrayList;
import java.util.List;

/**
 * LC: 515
 * https://leetcode.com/problems/find-largest-value-in-each-tree-row
 * Given the root of a binary tree, return an array of the largest value in each row of the tree (0-indexed).
 *
 * Example 1:
 *
 * Input: root = [1,3,2,5,3,null,9]
 * Output: [1,3,9]
 *
 * Approach: DFS recursion. Track the current level and update the maximum value seen for that level.
 * Tags: Tree
 * Tags: DFS
 */
public class M_LargestValueInTreeRow {
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



