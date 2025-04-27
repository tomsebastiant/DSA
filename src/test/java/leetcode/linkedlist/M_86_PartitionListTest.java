package leetcode.linkedlist;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class M_86_PartitionListTest {
    M_86_PartitionList partitioner = new M_86_PartitionList();

    @Test
    public void testExample1() {
        ListNode head = buildList(Arrays.asList(1, 4, 3, 2, 5, 2));
        ListNode partitioned = partitioner.partition(head, 3);
        assertEquals(Arrays.asList(1, 2, 2, 4, 3, 5), listToValues(partitioned));
    }

    @Test
    public void testAllSmaller() {
        ListNode head = buildList(Arrays.asList(1, 2, 2));
        ListNode partitioned = partitioner.partition(head, 3);
        assertEquals(Arrays.asList(1, 2, 2), listToValues(partitioned));
    }

    @Test
    public void testAllGreater() {
        ListNode head = buildList(Arrays.asList(5, 6, 7));
        ListNode partitioned = partitioner.partition(head, 3);
        assertEquals(Arrays.asList(5, 6, 7), listToValues(partitioned));
    }

    @Test
    public void testEmptyList() {
        ListNode head = null;
        ListNode partitioned = partitioner.partition(head, 3);
        assertNull(partitioned);
    }

    @Test
    public void testSingleNode() {
        ListNode head = new ListNode(1);
        ListNode partitioned = partitioner.partition(head, 2);
        assertEquals(Arrays.asList(1), listToValues(partitioned));
    }

    @Test
    public void testMultipleSameValueAsX() {
        ListNode head = buildList(Arrays.asList(3, 3, 3));
        ListNode partitioned = partitioner.partition(head, 3);
        assertEquals(Arrays.asList(3, 3, 3), listToValues(partitioned));
    }

    // Helper: Build list from array
    private ListNode buildList(List<Integer> values) {
        if (values == null || values.isEmpty()) return null;
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        for (int val : values) {
            curr.next = new ListNode(val);
            curr = curr.next;
        }
        return dummy.next;
    }

    // Helper: Convert list to array
    private List<Integer> listToValues(ListNode head) {
        List<Integer> result = new ArrayList<>();
        while (head != null) {
            result.add(head.val);
            head = head.next;
        }
        return result;
    }

}