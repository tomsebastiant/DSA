package leetcode.tree;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class E_94_BinaryTreeInorderTest {
    E_94_BinaryTreeInorder solution = new E_94_BinaryTreeInorder();

    @Test
    void testNullTree() {
        assertEquals(Collections.emptyList(), solution.inorderTraversal(null));
    }

    @Test
    void testSingleNodeTree() {
        TreeNode root = new TreeNode(1);
        assertEquals(List.of(1), solution.inorderTraversal(root));
    }

    @Test
    void testLeftSkewedTree() {
        // Tree:
        //     3
        //    /
        //   2
        //  /
        // 1
        TreeNode root = new TreeNode(3, new TreeNode(2, new TreeNode(1), null), null);
        assertEquals(List.of(1, 2, 3), solution.inorderTraversal(root));
    }

    @Test
    void testRightSkewedTree() {
        // Tree:
        // 1
        //  \
        //   2
        //    \
        //     3
        TreeNode root = new TreeNode(1, null, new TreeNode(2, null, new TreeNode(3)));
        assertEquals(List.of(1, 2, 3), solution.inorderTraversal(root));
    }

    @Test
    void testBalancedTree() {
        // Tree:
        //    2
        //   / \
        //  1   3
        TreeNode root = new TreeNode(2, new TreeNode(1), new TreeNode(3));
        assertEquals(List.of(1, 2, 3), solution.inorderTraversal(root));
    }

    @Test
    void testComplexTree() {
        // Tree:
        //       4
        //      / \
        //     2   6
        //    / \ / \
        //   1  3 5  7
        TreeNode root = new TreeNode(4,
                new TreeNode(2, new TreeNode(1), new TreeNode(3)),
                new TreeNode(6, new TreeNode(5), new TreeNode(7))
        );
        assertEquals(List.of(1, 2, 3, 4, 5, 6, 7), solution.inorderTraversal(root));
    }
}