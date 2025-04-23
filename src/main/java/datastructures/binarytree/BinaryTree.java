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
}
