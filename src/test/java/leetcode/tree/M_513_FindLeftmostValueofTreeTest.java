package leetcode.tree;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.assertEquals;

class M_513_FindLeftmostValueofTreeTest {

    M_513_FindLeftmostValueofTree finder = new M_513_FindLeftmostValueofTree();

    @Test
    public void testExample1() {
        TreeNode root = buildTree(Arrays.asList(2, 1, 3));
        assertEquals(1, finder.findBottomLeftValue(root));
    }

    @Test
    public void testLeftHeavyTree() {
        TreeNode root = buildTree(Arrays.asList(1, 2, null, 3, null, 4));
        assertEquals(4, finder.findBottomLeftValue(root));
    }

    @Test
    public void testSingleElement() {
        TreeNode root = new TreeNode(10);
        assertEquals(10, finder.findBottomLeftValue(root));
    }

    @Test
    public void testBalancedTree() {
        TreeNode root = buildTree(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
        assertEquals(4, finder.findBottomLeftValue(root));
    }

    @Test
    public void testSkewedRightTree() {
        TreeNode root = buildTree(Arrays.asList(1, null, 2, null, 3, null, 4));
        assertEquals(4, finder.findBottomLeftValue(root));
    }

    // Helper: Build tree from level-order (BFS) list
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