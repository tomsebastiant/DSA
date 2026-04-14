package leetcode.tree;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class M_114_FlattenBinaryTreeTest {
    M_114_FlattenBinaryTree solver = new M_114_FlattenBinaryTree();

    @Test
    public void testExample1() {
        TreeNode root = buildTree(Arrays.asList(1, 2, 5, 3, 4, null, 6));
        solver.flatten(root);
        List<Integer> actual = collectRightNodes(root);
        List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5, 6);
        assertEquals(expected, actual);
    }

    @Test
    public void testSingleNode() {
        TreeNode root = new TreeNode(0);
        solver.flatten(root);
        List<Integer> actual = collectRightNodes(root);
        List<Integer> expected = Arrays.asList(0);
        assertEquals(expected, actual);
    }

    @Test
    public void testEmptyTree() {
        TreeNode root = null;
        solver.flatten(root);
        assertNull(root);
    }

    @Test
    public void testOnlyLeftChildren() {
        TreeNode root = buildTree(Arrays.asList(1, 2, null, 3, null, 4, null));
        solver.flatten(root);
        List<Integer> actual = collectRightNodes(root);
        List<Integer> expected = Arrays.asList(1, 2, 3, 4);
        assertEquals(expected, actual);
    }

    @Test
    public void testOnlyRightChildren() {
        TreeNode root = buildTree(Arrays.asList(1, null, 2, null, 3, null, 4));
        solver.flatten(root);
        List<Integer> actual = collectRightNodes(root);
        List<Integer> expected = Arrays.asList(1, 2, 3, 4);
        assertEquals(expected, actual);
    }

    // Helper: Build a tree from level-order list (null for missing nodes)
    private TreeNode buildTree(List<Integer> values) {
        if (values.isEmpty() || values.get(0) == null) return null;
        TreeNode root = new TreeNode(values.get(0));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int i = 1;
        while (i < values.size()) {
            TreeNode current = queue.poll();
            if (i < values.size() && values.get(i) != null) {
                current.left = new TreeNode(values.get(i));
                queue.add(current.left);
            }
            i++;
            if (i < values.size() && values.get(i) != null) {
                current.right = new TreeNode(values.get(i));
                queue.add(current.right);
            }
            i++;
        }
        return root;
    }

    // Helper: Collect node values following only right pointers (like a linked list)
    private List<Integer> collectRightNodes(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        TreeNode current = root;
        while (current != null) {
            result.add(current.val);
            current = current.right;
        }
        return result;
    }


}