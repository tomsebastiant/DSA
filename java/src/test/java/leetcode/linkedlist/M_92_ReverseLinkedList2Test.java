package leetcode.linkedlist;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class M_92_ReverseLinkedList2Test {
    private ListNode buildList(int... vals) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        for (int val : vals) {
            current.next = new ListNode(val);
            current = current.next;
        }
        return dummy.next;
    }

    private int[] toArray(ListNode head) {
        java.util.List<Integer> result = new java.util.ArrayList<>();
        while (head != null) {
            result.add(head.val);
            head = head.next;
        }
        return result.stream().mapToInt(i -> i).toArray();
    }

    @Test
    public void testReverseMiddleSublist() {
        M_92_ReverseLinkedList2 sol = new M_92_ReverseLinkedList2();
        ListNode head = buildList(1, 2, 3, 4, 5);
        ListNode result = sol.reverseBetween(head, 2, 4);
        assertArrayEquals(new int[]{1, 4, 3, 2, 5}, toArray(result));
    }

    @Test
    public void testReverseFullList() {
        M_92_ReverseLinkedList2 sol = new M_92_ReverseLinkedList2();
        ListNode head = buildList(1, 2, 3);
        ListNode result = sol.reverseBetween(head, 1, 3);
        assertArrayEquals(new int[]{3, 2, 1}, toArray(result));
    }

    @Test
    public void testNoReversalNeeded() {
        M_92_ReverseLinkedList2 sol = new M_92_ReverseLinkedList2();
        ListNode head = buildList(1, 2, 3);
        ListNode result = sol.reverseBetween(head, 2, 2);
        assertArrayEquals(new int[]{1, 2, 3}, toArray(result));
    }

    @Test
    public void testReverseAtHead() {
        M_92_ReverseLinkedList2 sol = new M_92_ReverseLinkedList2();
        ListNode head = buildList(1, 2, 3, 4);
        ListNode result = sol.reverseBetween(head, 1, 2);
        assertArrayEquals(new int[]{2, 1, 3, 4}, toArray(result));
    }

    @Test
    public void testReverseAtTail() {
        M_92_ReverseLinkedList2 sol = new M_92_ReverseLinkedList2();
        ListNode head = buildList(1, 2, 3, 4);
        ListNode result = sol.reverseBetween(head, 3, 4);
        assertArrayEquals(new int[]{1, 2, 4, 3}, toArray(result));
    }

    @Test
    public void testSingleElementList() {
        M_92_ReverseLinkedList2 sol = new M_92_ReverseLinkedList2();
        ListNode head = buildList(1);
        ListNode result = sol.reverseBetween(head, 1, 1);
        assertArrayEquals(new int[]{1}, toArray(result));
    }
}