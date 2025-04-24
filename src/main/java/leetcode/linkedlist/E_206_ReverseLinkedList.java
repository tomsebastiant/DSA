package leetcode.linkedlist;

/**
 https://leetcode.com/problems/reverse-linked-list
 Given the head of a singly linked list, reverse the list, and return the reversed list.

 Approach: Traverse the linked list, store curr.next as next. Assign curr.next to prev, assign prev to
 curr, assign curr to next
 */

public class E_206_ReverseLinkedList {

    public ListNode reverseList(ListNode head) {
        ListNode node = head;
        ListNode prev = null;
        while(node!=null){
            ListNode next = node.next;
            node.next=prev;
            prev=node;
            node=next;
        }
        return prev;
    }
}
