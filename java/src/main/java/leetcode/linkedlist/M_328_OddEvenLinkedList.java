package leetcode.linkedlist;

/**
 https://leetcode.com/problems/odd-even-linked-list
 Given the head of a singly linked list, group all the nodes with odd indices together
 followed by the nodes with even indices, and return the reordered list.

 The first node is considered odd, and the second node is even, and so on.

 Note that the relative order inside both the even and odd groups should remain as it was in the input.

 You must solve the problem in O(1) extra space complexity and O(n) time complexity.

 Approach:  Mark the head as oddHead and second node and evenhead, then traverse through linkedlist
 linking odd and even elements together. Finally link last odd element to even head. return oddHead
 */

public class M_328_OddEvenLinkedList {

    public ListNode oddEvenList(ListNode head) {
        if(head==null){
            return null;
        }
        ListNode even=head.next;
        ListNode evenHead=even;
        ListNode odd=head;
        while(even!=null && even.next!=null){
            odd.next=even.next;
            odd=odd.next;
            even.next=odd.next;
            even=even.next;
        }
        odd.next=evenHead;
        return head;

    }
}
