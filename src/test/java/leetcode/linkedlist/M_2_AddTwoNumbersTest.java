package leetcode.linkedlist;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class M_2_AddTwoNumbersTest {
    private ListNode buildList(int... digits) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        for (int digit : digits) {
            current.next = new ListNode(digit);
            current = current.next;
        }
        return dummy.next;
    }

    private int[] listToArray(ListNode node) {
        java.util.List<Integer> result = new java.util.ArrayList<>();
        while (node != null) {
            result.add(node.val);
            node = node.next;
        }
        return result.stream().mapToInt(i -> i).toArray();
    }

    @Test
    public void testAddTwoNumbers() {
        M_2_AddTwoNumbers solution = new M_2_AddTwoNumbers();

        ListNode l1 = buildList(2, 4, 3); // Represents 342
        ListNode l2 = buildList(5, 6, 4); // Represents 465
        ListNode result = solution.addTwoNumbers(l1, l2); // Should be 807 → [7, 0, 8]

        int[] expected = {7, 0, 8};
        assertArrayEquals(expected, listToArray(result));
    }

    @Test
    public void testDifferentLengths() {
        M_2_AddTwoNumbers solution = new M_2_AddTwoNumbers();

        ListNode l1 = buildList(9, 9);     // 99
        ListNode l2 = buildList(1);        // 1
        ListNode result = solution.addTwoNumbers(l1, l2); // Should be 100 → [0, 0, 1]

        int[] expected = {0, 0, 1};
        assertArrayEquals(expected, listToArray(result));
    }

    @Test
    public void testCarryOver() {
        M_2_AddTwoNumbers solution = new M_2_AddTwoNumbers();

        ListNode l1 = buildList(5);        // 5
        ListNode l2 = buildList(5);        // 5
        ListNode result = solution.addTwoNumbers(l1, l2); // Should be 10 → [0, 1]

        int[] expected = {0, 1};
        assertArrayEquals(expected, listToArray(result));
    }
}