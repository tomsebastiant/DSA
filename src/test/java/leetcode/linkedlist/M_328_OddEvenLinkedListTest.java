package leetcode.linkedlist;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class M_328_OddEvenLinkedListTest {
    private ListNode buildList(int... values) {
        if (values.length == 0) return null;
        ListNode head = new ListNode(values[0]);
        ListNode current = head;
        for (int i = 1; i < values.length; i++) {
            current.next = new ListNode(values[i]);
            current = current.next;
        }
        return head;
    }

    private List<Integer> toList(ListNode head) {
        List<Integer> result = new ArrayList<>();
        while (head != null) {
            result.add(head.val);
            head = head.next;
        }
        return result;
    }

    @Test
    public void testExample1() {
        M_328_OddEvenLinkedList solution = new M_328_OddEvenLinkedList();
        ListNode input = buildList(1, 2, 3, 4, 5);
        ListNode output = solution.oddEvenList(input);
        assertEquals(Arrays.asList(1, 3, 5, 2, 4), toList(output));
    }

    @Test
    public void testExample2() {
        M_328_OddEvenLinkedList solution = new M_328_OddEvenLinkedList();
        ListNode input = buildList(2, 1, 3, 5, 6, 4, 7);
        ListNode output = solution.oddEvenList(input);
        assertEquals(Arrays.asList(2, 3, 6, 7, 1, 5, 4), toList(output));
    }

    @Test
    public void testEmptyList() {
        M_328_OddEvenLinkedList solution = new M_328_OddEvenLinkedList();
        ListNode input = null;
        ListNode output = solution.oddEvenList(input);
        assertNull(output);
    }

    @Test
    public void testSingleNode() {
        M_328_OddEvenLinkedList solution = new M_328_OddEvenLinkedList();
        ListNode input = buildList(42);
        ListNode output = solution.oddEvenList(input);
        assertEquals(Arrays.asList(42), toList(output));
    }
}