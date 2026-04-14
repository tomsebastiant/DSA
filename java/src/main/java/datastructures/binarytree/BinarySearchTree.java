package datastructures.binarytree;

import leetcode.tree.TreeNode;

/**
 * A Binary Search Tree (BST) is a type of binary tree where each node has at most two children
 * and satisfies the following properties:
 *
 * 1. The value of each node in the left subtree is less than the node's value.
 * 2. The value of each node in the right subtree is greater than the node's value.
 * 3. Both subtrees of each node are also binary search trees.
 *
 * The BST allows efficient searching, insertion, and deletion operations with an average time complexity
 * of O(log n) for balanced trees. In the worst case, for an unbalanced tree, the time complexity can degrade
 * to O(n). Common operations include:
 * - **Search**: Finds a node by following the BST properties.
 * - **Insert**: Adds a node while maintaining the BST properties.
 * - **Delete**: Removes a node, with specific strategies depending on the number of children the node has.
 *
 * Traversals (in-order, pre-order, post-order) can be used to visit all the nodes in different sequences.
 */

public class BinarySearchTree {
    int rangeSum=0;
    public int rangeSumBST(TreeNode root, int low, int high) {
        DFS(root,low,high);
        return rangeSum;
    }

    public void DFS(TreeNode root, int low, int high){
        if(root==null) return;

        if(root.val>=low && root.val<=high ){
            rangeSum=rangeSum+root.val;
        }
        DFS(root.left,low,high);
        DFS(root.right,low,high);
    }
}
