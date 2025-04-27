package leetcode.tree;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class M_814_BinaryTreePruningTest {

    M_814_BinaryTreePruning pruner = new M_814_BinaryTreePruning();

    @Test
    public void testExample1() {
        TreeNode root = buildTree(Arrays.asList(1, null, 0, 0, 1));
        TreeNode pruned = pruner.pruneTree(root);
        assertEquals(Arrays.asList(1, null, 0, null, 1), treeToList(pruned));
    }

    @Test
    public void testAllZeroTree() {
        TreeNode root = buildTree(Arrays.asList(0, 0, 0));
        TreeNode pruned = pruner.pruneTree(root);
        assertNull(pruned);
    }

    @Test
    public void testSingleOneNode() {
        TreeNode root = new TreeNode(1);
        TreeNode pruned = pruner.pruneTree(root);
        assertEquals(1, pruned.val);
        assertNull(pruned.left);
        assertNull(pruned.right);
    }

    @Test
    public void testTreeWithMixedOnesAndZeros() {
        TreeNode root = buildTree(Arrays.asList(1, 0, 1, 0, 0, 0, 1));
        TreeNode pruned = pruner.pruneTree(root);
        assertEquals(Arrays.asList(1, null, 1, null, 1), treeToList(pruned));
    }

    // Helper: Build binary tree from level order list (nulls allowed)
    private TreeNode buildTree(List<Integer> values) {
        if (values.isEmpty() || values.get(0) == null) return null;
        TreeNode root = new TreeNode(values.get(0));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int i = 1;
        while (i < values.size()) {
            TreeNode curr = queue.poll();
            if (i < values.size() && values.get(i) != null) {
                curr.left = new TreeNode(values.get(i));
                queue.add(curr.left);
            }
            i++;
            if (i < values.size() && values.get(i) != null) {
                curr.right = new TreeNode(values.get(i));
                queue.add(curr.right);
            }
            i++;
        }
        return root;
    }

    // Helper: Convert binary tree to level-order list with nulls
    private List<Integer> treeToList(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null) {
                result.add(node.val);
                queue.add(node.left);
                queue.add(node.right);
            } else {
                result.add(null);
            }
        }
        // Remove trailing nulls
        int last = result.size() - 1;
        while (last >= 0 && result.get(last) == null) last--;
        return result.subList(0, last + 1);
    }

}