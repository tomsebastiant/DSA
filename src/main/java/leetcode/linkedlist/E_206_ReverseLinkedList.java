package leetcode.linkedlist;

import datastructures.linkedlist.ListNode;

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
