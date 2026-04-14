package leetcode.linkedlist;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class M_148_SortListTest {

    M_148_SortList solver = new M_148_SortList();

    @Test
    public void testExample1() {
        ListNode head = buildList(Arrays.asList(4, 2, 1, 3));
        ListNode sorted = solver.sortList(head);
        List<Integer> actual = toList(sorted);
        List<Integer> expected = Arrays.asList(1, 2, 3, 4);
        assertEquals(expected, actual);
    }

    @Test
    public void testExample2() {
        ListNode head = buildList(Arrays.asList(-1, 5, 3, 4, 0));
        ListNode sorted = solver.sortList(head);
        List<Integer> actual = toList(sorted);
        List<Integer> expected = Arrays.asList(-1, 0, 3, 4, 5);
        assertEquals(expected, actual);
    }

    @Test
    public void testEmptyList() {
        ListNode head = null;
        ListNode sorted = solver.sortList(head);
        assertNull(sorted);
    }

    @Test
    public void testSingleElement() {
        ListNode head = buildList(Arrays.asList(10));
        ListNode sorted = solver.sortList(head);
        List<Integer> actual = toList(sorted);
        List<Integer> expected = Arrays.asList(10);
        assertEquals(expected, actual);
    }

    @Test
    public void testAlreadySorted() {
        ListNode head = buildList(Arrays.asList(1, 2, 3, 4, 5));
        ListNode sorted = solver.sortList(head);
        List<Integer> actual = toList(sorted);
        List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5);
        assertEquals(expected, actual);
    }

    @Test
    public void testAllSameElements() {
        ListNode head = buildList(Arrays.asList(7, 7, 7, 7));
        ListNode sorted = solver.sortList(head);
        List<Integer> actual = toList(sorted);
        List<Integer> expected = Arrays.asList(7, 7, 7, 7);
        assertEquals(expected, actual);
    }

    // Helper: Build a linked list from list of integers
    private ListNode buildList(List<Integer> values) {
        if (values.isEmpty()) return null;
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        for (int val : values) {
            current.next = new ListNode(val);
            current = current.next;
        }
        return dummy.next;
    }

    // Helper: Convert linked list to list of integers
    private List<Integer> toList(ListNode head) {
        List<Integer> result = new ArrayList<>();
        ListNode current = head;
        while (current != null) {
            result.add(current.val);
            current = current.next;
        }
        return result;
    }

}