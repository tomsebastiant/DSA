package leetcode.tree;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class M_958_CompletenessOfBinaryTreeTest {
    M_958_CompletenessOfBinaryTree checker = new M_958_CompletenessOfBinaryTree();

    @Test
    public void testExample1() {
        TreeNode root = buildTree(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertTrue(checker.isCompleteTree(root));
    }

    @Test
    public void testExample2() {
        TreeNode root = buildTree(Arrays.asList(1, 2, 3, 4, 5, null, 7));
        assertFalse(checker.isCompleteTree(root));
    }

    @Test
    public void testSingleNode() {
        TreeNode root = new TreeNode(1);
        assertTrue(checker.isCompleteTree(root));
    }

    @Test
    public void testEmptyTree() {
        TreeNode root = null;
        assertTrue(checker.isCompleteTree(root));  // An empty tree is considered complete
    }

    @Test
    public void testLeftChildOnlyInLastLevel() {
        TreeNode root = buildTree(Arrays.asList(1, 2, 3, 4, null, 6, 7));
        assertFalse(checker.isCompleteTree(root));
    }

    @Test
    public void testCompleteButNotPerfectTree() {
        TreeNode root = buildTree(Arrays.asList(1, 2, 3, 4, 5, null, null));
        assertTrue(checker.isCompleteTree(root));
    }

    // Helper: Build a tree from level-order (BFS) list
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
}