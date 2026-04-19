package datastructures.binarytree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

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


/**
 * A binary tree is a hierarchical data structure where each node has at most two children:
 * a left child and a right child. Unlike a binary search tree, the values do not follow any
 * ordering rule, so traversal and structural helpers are often the main operations.
 */
public class BinaryTree {

    /**
     * Returns the left view of the tree.
     * DFS is used with level tracking so we record the first node seen at each depth.
     */
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
     * Counts the number of nodes in the tree.
     */
    public int size(Node root) {
        if (root == null) {
            return 0;
        }
        return 1 + size(root.left) + size(root.right);
    }

    /**
     * Returns the height of the tree.
     * Height is the number of nodes on the longest path from root to leaf.
     */
    public int height(Node root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(height(root.left), height(root.right));
    }

    /**
     * Counts the number of leaf nodes in the tree.
     */
    public int countLeaves(Node root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        return countLeaves(root.left) + countLeaves(root.right);
    }

    /**
     * Inorder traversal visits nodes in left, root, right order.
     */
    public List<Integer> inorder(Node root) {
        List<Integer> result = new ArrayList<>();
        inorder(root, result);
        return result;
    }

    private void inorder(Node root, List<Integer> result) {
        if (root == null) {
            return;
        }
        inorder(root.left, result);
        result.add(root.data);
        inorder(root.right, result);
    }

    /**
     * Preorder traversal visits nodes in root, left, right order.
     */
    public List<Integer> preorder(Node root) {
        List<Integer> result = new ArrayList<>();
        preorder(root, result);
        return result;
    }

    private void preorder(Node root, List<Integer> result) {
        if (root == null) {
            return;
        }
        result.add(root.data);
        preorder(root.left, result);
        preorder(root.right, result);
    }

    /**
     * Postorder traversal visits nodes in left, right, root order.
     */
    public List<Integer> postorder(Node root) {
        List<Integer> result = new ArrayList<>();
        postorder(root, result);
        return result;
    }

    private void postorder(Node root, List<Integer> result) {
        if (root == null) {
            return;
        }
        postorder(root.left, result);
        postorder(root.right, result);
        result.add(root.data);
    }

    /**
     * Level-order traversal visits nodes breadth-first, level by level.
     */
    public List<Integer> levelOrder(Node root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            result.add(node.data);
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        return result;
    }

    /**
     * Searches the tree for a value using DFS.
     */
    public boolean search(Node root, int target) {
        if (root == null) {
            return false;
        }
        if (root.data == target) {
            return true;
        }
        return search(root.left, target) || search(root.right, target);
    }

    /**
     * Returns the mirror image of the tree.
     */
    public Node mirror(Node root) {
        if (root == null) {
            return null;
        }
        Node mirrored = new Node(root.data);
        mirrored.left = mirror(root.right);
        mirrored.right = mirror(root.left);
        return mirrored;
    }

    /**
     * Mirrors the tree in place by swapping the left and right children of every node.
     */
    public Node mirrorInPlace(Node root) {
        if (root == null) {
            return null;
        }

        Node temp = root.left;
        root.left = mirrorInPlace(root.right);
        root.right = mirrorInPlace(temp);
        return root;
    }
}
