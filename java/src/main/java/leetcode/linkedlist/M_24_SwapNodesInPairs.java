package leetcode.linkedlist;

/**
 Tags:
 https://leetcode.com/problems/swap-nodes-in-pairs
 Given a linked list, swap every two adjacent nodes and return its head.
 You must solve the problem without modifying the values in the list's nodes
 (i.e., only nodes themselves may be changed.)

 Approach: Use a dummy node, set it as curr. check if curr.next and curr.next.next exists. Then swap
 the nodes. Return dummy.next.

 */
public class M_24_SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy=new ListNode(0);
        dummy.next=head;

        ListNode curr=dummy;

        while(curr.next!= null && curr.next.next != null){
            ListNode first=curr.next;
            ListNode second=curr.next.next;
            first.next=second.next;
            curr.next=second;
            second.next=first;
            curr=first;
        }
        return dummy.next;
    }
}
