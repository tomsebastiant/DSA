package datastructures.linkedlist;


import leetcode.linkedlist.ListNode;

public class LinkedList {

    /**
     https://leetcode.com/problems/linked-list-cycle
     Given head, the head of a linked list, determine if the linked list has a cycle in it.

     There is a cycle in a linked list if there is some node in the list that can be reached
     again by continuously following the next pointer. Return true if there is a cycle in the linked list. Otherwise, return false.

     Approach:  Use slow and fast pointers. If they meet cycle exists
     */

    public boolean hasCycle(ListNode head) {
        if(head==null){
            return false;
        }
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(fast==slow){
                return true;
            }
        }
        return false;
    }

    /**
     https://leetcode.com/problems/merge-two-sorted-lists
     You are given the heads of two sorted linked lists list1 and list2.

     Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.

     Return the head of the merged linked list.

     Approach:  Use a dummy node to start, traverse both lists and keep adding to new list the lower value.
     One list may not be fully traversed. Add its elements also to the merged list
     */

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode merged=dummy;
        while(list1!=null && list2!=null){
            if(list1.val<list2.val){
                merged.next=list1;
                list1=list1.next;
            } else {
                merged.next=list2;
                list2=list2.next;
            }
            merged=merged.next;
        }
        if(list1!=null){
            merged.next=list1;
        }
        if(list2!=null){
            merged.next=list2;
        }
        return dummy.next;
    }
}
