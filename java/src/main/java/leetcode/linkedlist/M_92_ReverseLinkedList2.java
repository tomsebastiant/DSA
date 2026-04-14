package leetcode.linkedlist;

/**
 https://leetcode.com/problems/reverse-linked-list-ii
 Given the head of a singly linked list and two integers left and right where left <= right,
 reverse the nodes of the list from position left to position right, and return the reversed list.

 Input: head = [1,2,3,4,5], left = 2, right = 4
 Output: [1,4,3,2,5]

 Approach:
 Use a dummy node to simplify list construction. traverse till left and mark the prev and curr.
 Then do a reverseing of the sub list using moving curr ahead, unlinking curr.next and moving it
 back to prev.next
 */

public class M_92_ReverseLinkedList2 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head==null || left==right) return head;
        ListNode dummy=new ListNode(0);
        dummy.next =head;
        ListNode prev = dummy;

        for(int i=1;i<left;i++){
            prev=prev.next;
        }

        ListNode curr=prev.next;
        ListNode next=null;

        for(int i=0;i<right-left;i++){
            next=curr.next;
            curr.next=next.next;
            next.next=prev.next;
            prev.next=next;
        }
        return dummy.next;
    }
}
