package leetcode.tree;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class E_617_Merge2BinaryTreesTest {
    E_617_Merge2BinaryTrees solution = new E_617_Merge2BinaryTrees();

    private TreeNode buildTree(Integer... values) {
        if (values.length == 0 || values[0] == null) return null;

        TreeNode root = new TreeNode(values[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int i = 1;

        while (i < values.length) {
            TreeNode current = queue.poll();
            if (i < values.length && values[i] != null) {
                current.left = new TreeNode(values[i]);
                queue.add(current.left);
            }
            i++;
            if (i < values.length && values[i] != null) {
                current.right = new TreeNode(values[i]);
                queue.add(current.right);
            }
            i++;
        }
        return root;
    }

    private List<Integer> inorder(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorderHelper(root, result);
        return result;
    }

    private void inorderHelper(TreeNode node, List<Integer> result) {
        if (node == null) return;
        inorderHelper(node.left, result);
        result.add(node.val);
        inorderHelper(node.right, result);
    }

    @Test
    void testMergeNormalTrees() {
        TreeNode t1 = buildTree(1, 3, 2, 5);
        TreeNode t2 = buildTree(2, 1, 3, null, 4, null, 7);
        TreeNode merged = solution.mergeTrees(t1, t2);

        // Merged tree should be: [3, 4, 5, 5, 4, null, 7]
        assertEquals(List.of(5, 4, 4, 3, 5, 7), inorder(merged)); // Checking inorder traversal
    }

    @Test
    void testMergeWithNullLeftTree() {
        TreeNode t1 = null;
        TreeNode t2 = buildTree(1, 2, 3);
        TreeNode merged = solution.mergeTrees(t1, t2);
        assertEquals(List.of(2, 1, 3), inorder(merged));
    }

    @Test
    void testMergeWithNullRightTree() {
        TreeNode t1 = buildTree(1, 2, 3);
        TreeNode t2 = null;
        TreeNode merged = solution.mergeTrees(t1, t2);
        assertEquals(List.of(2, 1, 3), inorder(merged));
    }

    @Test
    void testMergeBothNull() {
        TreeNode merged = solution.mergeTrees(null, null);
        assertNull(merged);
    }

    @Test
    void testMergeSingleNodes() {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode merged = solution.mergeTrees(t1, t2);
        assertEquals(3, merged.val);
        assertNull(merged.left);
        assertNull(merged.right);
    }

}