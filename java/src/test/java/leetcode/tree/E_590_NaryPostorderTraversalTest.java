package leetcode.tree;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

class E_590_NaryPostorderTraversalTest {
    private Node createTree1() {
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
    void testPostorderExampleTree() {
        E_590_NaryPostorderTraversal sol = new E_590_NaryPostorderTraversal();
        Node root = createTree1();
        List<Integer> expected = Arrays.asList(5, 6, 3, 2, 4, 1);
        assertEquals(expected, sol.postorder(root));
    }

    @Test
    void testNullRoot() {
        E_590_NaryPostorderTraversal sol = new E_590_NaryPostorderTraversal();
        assertEquals(Collections.emptyList(), sol.postorder(null));
    }

    @Test
    void testSingleNode() {
        E_590_NaryPostorderTraversal sol = new E_590_NaryPostorderTraversal();
        Node root = new Node(10);
        assertEquals(List.of(10), sol.postorder(root));
    }

    @Test
    void testTreeWithOnlyChildren() {
        // Tree:
        //    1
        //   / \
        //  2   3
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node root = new Node(1, Arrays.asList(node2, node3));

        E_590_NaryPostorderTraversal sol = new E_590_NaryPostorderTraversal();
        assertEquals(List.of(2, 3, 1), sol.postorder(root));
    }
}