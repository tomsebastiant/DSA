package leetcode.tree;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class M_515_LargestValueInTreeRowTest {

    M_515_LargestValueInTreeRow solution = new M_515_LargestValueInTreeRow();


    @Test
    public void testExample1() {
        // Tree:
        //      1
        //     / \
        //    3   2
        //   / \   \
        //  5   3   9
        TreeNode root = new TreeNode (1);
        root.left = new TreeNode (3);
        root.right = new TreeNode (2);
        root.left.left = new TreeNode (5);
        root.left.right = new TreeNode (3);
        root.right.right = new TreeNode (9);

        List<Integer> expected = Arrays.asList(1, 3, 9);
        assertEquals(expected, solution.largestValues(root));
    }

    @Test
    public void testSingleNode () {
        TreeNode root = new TreeNode (42);
        List<Integer> expected = List.of(42);
        assertEquals(expected, solution.largestValues(root));
    }

    @Test
    public void testNegativeValues() {
        // Tree:
        //     -10
        //     /  \
        //   -20  -30
        TreeNode root = new TreeNode (-10);
        root.left = new TreeNode (-20);
        root.right = new TreeNode (-30);

        List<Integer> expected = List.of(-10, -20);
        assertEquals(expected, solution.largestValues(root));
    }

    @Test
    public void testUnbalancedTree() {
        // Tree:
        //    1
        //     \
        //      2
        //       \
        //        3
        TreeNode root = new TreeNode (1);
        root.right = new TreeNode (2);
        root.right.right = new TreeNode (3);

        List<Integer> expected = List.of(1, 2, 3);
        assertEquals(expected, solution.largestValues(root));
    }

    @Test
    public void testEmptyTree() {
        List<Integer> expected = List.of();
        assertEquals(expected, solution.largestValues(null));
    }

}