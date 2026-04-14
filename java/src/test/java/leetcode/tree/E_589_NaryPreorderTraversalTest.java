package leetcode.tree;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class E_589_NaryPreorderTraversalTest {
    E_589_NaryPreorderTraversal sol = new E_589_NaryPreorderTraversal();

    private Node createExampleTree() {
        // Tree:
        //        1
        //      / | \
        //     3  2  4
        //    / \
        //   5   6
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node3 = new Node(3, Arrays.asList(node5, node6));
        Node node2 = new Node(2);
        Node node4 = new Node(4);
        return new Node(1, Arrays.asList(node3, node2, node4));
    }

    @Test
    void testExampleTree() {
        Node root = createExampleTree();
        List<Integer> expected = Arrays.asList(1, 3, 5, 6, 2, 4);
        assertEquals(expected, sol.preorder(root));
    }

    @Test
    void testNullRoot() {
        assertEquals(Collections.emptyList(), sol.preorder(null));
    }

    @Test
    void testSingleNode() {
        Node root = new Node(10);
        assertEquals(List.of(10), sol.preorder(root));
    }

    @Test
    void testTreeWithOneChild() {
        // Tree: 1 → 2
        Node root = new Node(1, List.of(new Node(2)));
        assertEquals(List.of(1, 2), sol.preorder(root));
    }

    @Test
    void testDeepTree() {
        // Tree: 1 → 2 → 3 → 4
        Node node4 = new Node(4);
        Node node3 = new Node(3, List.of(node4));
        Node node2 = new Node(2, List.of(node3));
        Node root = new Node(1, List.of(node2));
        assertEquals(List.of(1, 2, 3, 4), sol.preorder(root));
    }
}