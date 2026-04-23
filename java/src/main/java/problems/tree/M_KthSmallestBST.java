package problems.tree;

import java.util.ArrayList;
import java.util.List;

import common.TreeNode;

/**
 * LC: 230
 * https://leetcode.com/problems/kth-smallest-element-in-a-bst/
 * Given the root of a binary search tree, and an integer k, return the kth smallest value
 * (1-indexed) of all the values of the nodes in the tree.
 *
 * Example 1:
 *
 * Input: root = [3,1,4,null,2], k = 1
 * Output: 1
 *
 * Example 2:
 *
 * Input: root = [5,3,6,2,4,null,null,1], k = 3
 * Output: 3
 *
 * Approach: Perform an inorder traversal of the BST, which visits values in sorted order,
 * and return the element at index k - 1.
 * Tags: Tree
 * Tags: DFS
 * Tags: BinarySearchTree
 */
public class M_KthSmallestBST {
        public int kthSmallest(TreeNode root, int k) {
        List<Integer> list = new ArrayList();
        inorder(root,list);
        return list.get(k-1);
    }

    public void inorder(TreeNode root, List list){
        if(root==null){
            return;
        }

        inorder(root.left,list);
        list.add(root.val);
        inorder(root.right,list);
    }
}
