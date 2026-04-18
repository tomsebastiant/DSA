package problems.linkedlist;

import common.ListNode;

/**
 * LC: 206
 https://leetcode.com/problems/reverse-linked-list
 Given the head of a singly linked list, reverse the list, and return the reversed list.

 Approach: Traverse the linked list, store curr.next as next. Assign curr.next to prev, assign prev to
 curr, assign curr to next

 Tags: LinkedList
 */

public class E_ReverseLinkedList {

    public ListNode reverseList(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;
        while(curr!=null){
            ListNode next = curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;
    }
}




