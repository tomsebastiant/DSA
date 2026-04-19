package problems.linkedlist;

import common.ListNode;

/**
 * LC: 21
 * https://leetcode.com/problems/merge-two-sorted-lists
 * You are given the heads of two sorted linked lists list1 and list2.
 *
 * Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.
 *
 * Return the head of the merged linked list.
 *
 * Approach: Use a dummy node and keep appending the smaller node from either list.
 * Tags: LinkedList
 */
public class E_MergeTwoSortedLists {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode merged = dummy;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                merged.next = list1;
                list1 = list1.next;
            } else {
                merged.next = list2;
                list2 = list2.next;
            }
            merged = merged.next;
        }

        if (list1 != null) {
            merged.next = list1;
        }
        if (list2 != null) {
            merged.next = list2;
        }
        return dummy.next;
    }
}
