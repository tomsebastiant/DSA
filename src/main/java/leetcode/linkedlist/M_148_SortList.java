package leetcode.linkedlist;

/**
 Tags:
 https://leetcode.com/problems/sort-list
 Given the head of a linked list, return the list after sorting it in ascending order.

 Approach: We effectively use merge sort algorithm to split up the linked list and then sort
 them while merging them

 */

public class M_148_SortList {

    public ListNode sortList(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }

        ListNode temp = head;
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next!=null){
            temp=slow;
            slow=slow.next;
            fast=fast.next.next;
        }

        temp.next=null;
        ListNode left=sortList(head);
        ListNode right=sortList(slow);

        return merge(left,right);
    }

    public ListNode merge(ListNode l1, ListNode l2){
        ListNode temp= new ListNode(0);
        ListNode curr =temp;

        while(l1!= null && l2!=null){
            if(l1.val<l2.val){
                curr.next=l1;
                l1=l1.next;
            } else {
                curr.next=l2;
                l2=l2.next;
            }
            curr = curr.next;
        }

        if(l1!=null){
            curr.next = l1;
        }
        if(l2!=null){
            curr.next = l2;
        }
        return temp.next;
    }
}
