package leetcode.tree;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.assertEquals;

class M_662_MaxWidthOfBinaryTreeTest {
    M_662_MaxWidthOfBinaryTree solver = new M_662_MaxWidthOfBinaryTree();

    @Test
    public void testExample1() {
        TreeNode root = buildTree(Arrays.asList(1, 3, 2, 5, 3, null, 9));
        assertEquals(4, solver.widthOfBinaryTree(root));
    }

    @Test
    public void testExample2() {
        TreeNode root = buildTree(Arrays.asList(1, 3, null, 5, 3));
        assertEquals(2, solver.widthOfBinaryTree(root));
    }

    @Test
    public void testExample3() {
        TreeNode root = buildTree(Arrays.asList(1, 3, 2, 5));
        assertEquals(2, solver.widthOfBinaryTree(root));
    }

    @Test
    public void testSingleNode() {
        TreeNode root = new TreeNode(1);
        assertEquals(1, solver.widthOfBinaryTree(root));
    }

    @Test
    public void testEmptyTree() {
        TreeNode root = null;
        assertEquals(0, solver.widthOfBinaryTree(root));
    }

    @Test
    public void testWideAtLowerLevel() {
        TreeNode root = buildTree(Arrays.asList(1, 2, 3, 4, null, null, 5));
        assertEquals(4, solver.widthOfBinaryTree(root));
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