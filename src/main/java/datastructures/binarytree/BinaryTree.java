package datastructures.binarytree;

import java.util.ArrayList;

class Node {
    int data;
    Node left;
    Node right;

    public Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}


public class BinaryTree {

//    To check if a Tree is Binary Search Tree
//    Left Subtree: All the nodes in the left subtree of a node have keys less than the node's key.
//    Right Subtree: All the nodes in the right subtree of a node have keys greater than the node's key.
//    This rule applies recursively to every subtree in the tree.

//    Start with a range defined by a very large minimum and maximum value (initially set to negative and positive infinity).
//    For each node, check if its value is within the valid range.
//    Recursively check the left and right subtrees with updated bounds:
//    The left subtree should have all values less than the current node’s value.
//    The right subtree should have all values greater than the current node’s value.
//    If any node violates the BST property, return false.

    boolean isBST(Node root) {
        int MIN = Integer.MIN_VALUE;
        int MAX = Integer.MAX_VALUE;
        return isBSTUtil(root,MIN,MAX);
    }

    public boolean isBSTUtil(Node root, int min, int max){
        if(root == null){
            return true;
        }

        if(root.data<min || root.data>max){
            return false;
        }

        return isBSTUtil(root.left,min,root.data) && isBSTUtil(root.right,root.data,max);
    }

//    Consider the following binary tree:
//
//              1
//            /   \
//            2     3
//           / \   / \
//          4   5 6   7
//               /
//              8
//    Left View of this tree would be: [1, 2, 4, 8].
//      Breadth First Search (BFS), where we process nodes level by level using a queue. At each level,
//      we enqueue all the nodes, but only add the first node at each level to the result list.
//
//      •Steps:
//
//            1.Use a queue to perform level order traversal.
//            2.For each level, add the first node to the result list.
//            3.Enqueue left and right children of the current node in that order to maintain the correct sequence.

    ArrayList<Integer> leftView(Node root) {
        ArrayList<Integer> result = new ArrayList<>();
        leftViewUtil(root,0,result);
        return result;
    }

    void leftViewUtil(Node root,int level, ArrayList<Integer> result){
        if(root == null)
            return;

        if(result.size() == level){
            result.add(root.data);
        }

        leftViewUtil(root.left,level+1,result);
        leftViewUtil(root.right,level+1,result);
    }

/**
 https://leetcode.com/problems/maximum-depth-of-binary-tree
 Given the root of a binary tree, return its maximum depth.

 A binary tree's maximum depth is the number of nodes along the longest
 path from the root node down to the farthest leaf node.

 Approach :Recursion
 The depth at a current level is 1 + max depth of your left or right tree
 */

    public int maxDepth(Node root) {
        if(root==null){
            return 0;
        }
        return 1+Math.max(maxDepth(root.left),maxDepth(root.right));
    }

    /**
     https://leetcode.com/problems/symmetric-tree
     Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).

     Approach :Recursion
     As we traverse down, the mirror of the tree should be same, that makes it symmetric
     */

    public boolean isSymmetric(Node root) {
        return isMirror(root.left,root.right);
    }

    public boolean isMirror(Node node1,Node node2){
        if(node1==null && node2==null){
            return true;
        }
        if(node1==null || node2==null){
            return false;
        }
        return node1.data==node2.data && isMirror(node1.left,node2.right) && isMirror(node1.right,node2.left);
    }

    /**
     https://leetcode.com/problems/path-sum
     Given the root of a binary tree and an integer targetSum, return true
     if the tree has a root-to-leaf path such that adding up all the values
     along the path equals targetSum.

     A leaf is a node with no children.

     Approach :Recursion
     We recurse down tree and check the sum only at leafs. If we're not at leaf, we traverse further down
     */

    public boolean hasPathSum(Node root, int targetSum) {
        if(root==null){
            return false;
        }

        targetSum-=root.data;
        if(root.left==null && root.right==null && targetSum==0){
            return true;
        }

        return hasPathSum(root.left,targetSum) || hasPathSum(root.right,targetSum);
    }
}
