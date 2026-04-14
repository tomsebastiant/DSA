package leetcode.linkedlist;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class E_206_E_206_ReverseLinkedListTest {


    E_206_ReverseLinkedList solution = new E_206_ReverseLinkedList();

    private ListNode buildList(int... values) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        for (int val : values) {
            curr.next = new ListNode(val);
            curr = curr.next;
        }
        return dummy.next;
    }

    private int[] toArray(ListNode head) {
        // First, count the number of nodes
        int size = 0;
        ListNode curr = head;
        while (curr != null) {
            size++;
            curr = curr.next;
        }

        // Then, collect the values into an array
        int[] result = new int[size];
        curr = head;
        int i = 0;
        while (curr != null) {
            result[i++] = curr.val;
            curr = curr.next;
        }

        return result;
    }

    @Test
    public void testReverseRegularList() {
        ListNode head = buildList(1, 2, 3, 4, 5);
        ListNode reversed = solution.reverseList(head);
        assertArrayEquals(new int[]{5, 4, 3, 2, 1}, toArray(reversed));
    }

    @Test
    public void testReverseSingleElement() {
        ListNode head = buildList(42);
        ListNode reversed = solution.reverseList(head);
        assertArrayEquals(new int[]{42}, toArray(reversed));
    }

    @Test
    public void testReverseEmptyList() {
        ListNode head = null;
        ListNode reversed = solution.reverseList(head);
        assertNull(reversed);
    }

    @Test
    public void testReverseTwoElements() {
        ListNode head = buildList(7, 9);
        ListNode reversed = solution.reverseList(head);
        assertArrayEquals(new int[]{9, 7}, toArray(reversed));
    }

}