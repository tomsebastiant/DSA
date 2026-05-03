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
     * LC: 94
     * https://leetcode.com/problems/binary-tree-inorder-traversal
     * Given the root of a binary tree, return the inorder traversal of its nodes' values.
     *
     * Example 1:
     *
     * Input: root = [1,null,2,3]
     * Output: [1,3,2]
     *
     * Approach: Recursion. Visit the left subtree, then the current node, then the right subtree.
     * Tags: Tree
     * Tags: DFS
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
     * LC: 144
     * https://leetcode.com/problems/binary-tree-preorder-traversal
     * Given the root of a binary tree, return the preorder traversal of its nodes' values.
     *
     * Example 1:
     *
     * Input: root = [1,null,2,3]
     * Output: [1,2,3]
     *
     * Approach: Recursion. Visit the current node first, then the left subtree, then the right subtree.
     * Tags: Tree
     * Tags: DFS
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
     * LC: 145
     * https://leetcode.com/problems/binary-tree-postorder-traversal
     * Given the root of a binary tree, return the postorder traversal of its nodes' values.
     *
     * Example 1:
     *
     * Input: root = [1,null,2,3]
     * Output: [3,2,1]
     *
     * Approach: Recursion. Visit the left subtree, then the right subtree, then the current node.
     * Tags: Tree
     * Tags: DFS
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
     * LC: 102
     * https://leetcode.com/problems/binary-tree-level-order-traversal/
     * Given the root of a binary tree, return the level order traversal of its nodes' values.
     *
     * Example 1:
     *
     * Input: root = [3,9,20,null,null,15,7]
     * Output: [[3],[9,20],[15,7]]
     *
     * Example 2:
     *
     * Input: root = [1]
     * Output: [[1]]
     *
     * Approach: Use breadth-first search with a queue.
     * Process the tree one level at a time by reading the current queue size,
     * collecting the values for that level, and then enqueueing the next level's children.
     * Tags: Tree
     * Tags: BFS
     * Tags: Queue
     */
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> level = new ArrayList<>(levelSize);
            for (int i = 0; i < levelSize; i++) {
                Node node = queue.poll();
                level.add(node.data);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            result.add(level);
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
