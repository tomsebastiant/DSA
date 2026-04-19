package problems.linkedlist;

import common.ListNode;

/**
 * LC: 141
 * https://leetcode.com/problems/linked-list-cycle
 * Given head, the head of a linked list, determine if the linked list has a cycle in it.
 *
 * There is a cycle in a linked list if there is some node in the list that can be reached
 * again by continuously following the next pointer. Return true if there is a cycle in the linked list. Otherwise, return false.
 *
 * Approach: Use slow and fast pointers. If they meet, a cycle exists.
 * Tags: LinkedList
 */
public class E_LinkedListCycle {

    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
}
