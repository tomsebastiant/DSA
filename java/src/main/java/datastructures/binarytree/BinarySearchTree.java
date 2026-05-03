package datastructures.binarytree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

import common.TreeNode;

/**
 * Basic Binary Search Tree implementation using the shared TreeNode type.
 */
public class BinarySearchTree {

    private TreeNode root;

    public BinarySearchTree() {
        this.root = null;
    }

    public TreeNode getRoot() {
        return root;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void clear() {
        root = null;
    }

    public void insert(int val) {
        root = insert(root, val);
    }

    private TreeNode insert(TreeNode node, int val) {
        if (node == null) {
            return new TreeNode(val);
        }
        if (val < node.val) {
            node.left = insert(node.left, val);
        } else if (val > node.val) {
            node.right = insert(node.right, val);
        }
        return node;
    }

    public boolean search(int val) {
        return search(root, val) != null;
    }

    private TreeNode search(TreeNode node, int val) {
        while (node != null) {
            if (val < node.val) {
                node = node.left;
            } else if (val > node.val) {
                node = node.right;
            } else {
                return node;
            }
        }
        return null;
    }

    public void delete(int val) {
        root = delete(root, val);
    }

    private TreeNode delete(TreeNode node, int val) {
        if (node == null) {
            return null;
        }

        if (val < node.val) {
            node.left = delete(node.left, val);
        } else if (val > node.val) {
            node.right = delete(node.right, val);
        } else {
            if (node.left == null) {
                return node.right;
            }
            if (node.right == null) {
                return node.left;
            }

            TreeNode successor = minNode(node.right);
            node.val = successor.val;
            node.right = delete(node.right, successor.val);
        }
        return node;
    }

    public int findMin() {
        if (root == null) {
            throw new IllegalStateException("BST is empty");
        }
        return minNode(root).val;
    }

    public int findMax() {
        if (root == null) {
            throw new IllegalStateException("BST is empty");
        }
        return maxNode(root).val;
    }

    private TreeNode minNode(TreeNode node) {
        TreeNode curr = node;
        while (curr != null && curr.left != null) {
            curr = curr.left;
        }
        return curr;
    }

    private TreeNode maxNode(TreeNode node) {
        TreeNode curr = node;
        while (curr != null && curr.right != null) {
            curr = curr.right;
        }
        return curr;
    }

    public int height() {
        return height(root);
    }

    private int height(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return 1 + Math.max(height(node.left), height(node.right));
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
     * Approach: In a BST, inorder traversal visits nodes in sorted ascending order.
     * Tags: Tree
     * Tags: DFS
     */
    public List<Integer> inorder() {
        List<Integer> result = new ArrayList<>();
        inorder(root, result);
        return result;
    }

    private void inorder(TreeNode node, List<Integer> result) {
        if (node == null) {
            return;
        }
        inorder(node.left, result);
        result.add(node.val);
        inorder(node.right, result);
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
     * Approach: Visit the current node first, then the left subtree, then the right subtree.
     * Tags: Tree
     * Tags: DFS
     */
    public List<Integer> preorder() {
        List<Integer> result = new ArrayList<>();
        preorder(root, result);
        return result;
    }

    private void preorder(TreeNode node, List<Integer> result) {
        if (node == null) {
            return;
        }
        result.add(node.val);
        preorder(node.left, result);
        preorder(node.right, result);
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
     * Approach: Visit the left subtree, then the right subtree, then the current node.
     * Tags: Tree
     * Tags: DFS
     */
    public List<Integer> postorder() {
        List<Integer> result = new ArrayList<>();
        postorder(root, result);
        return result;
    }

    private void postorder(TreeNode node, List<Integer> result) {
        if (node == null) {
            return;
        }
        postorder(node.left, result);
        postorder(node.right, result);
        result.add(node.val);
    }

    /**
     * Level-order traversal visits nodes breadth-first, one node at a time.
     * A queue is used to process nodes from top to bottom, left to right.
     */
    public List<Integer> levelOrder() {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            result.add(node.val);
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        return result;
    }
}
