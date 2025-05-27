package leetcode.linkedlist;

/**
 https://leetcode.com/problems/add-two-numbers
 You are given two non-empty linked lists representing two non-negative integers.
 The digits are stored in reverse order, and each of their nodes contains a single
 \digit. Add the two numbers and return the sum as a linked list.

 You may assume the two numbers do not contain any leading zero, except the number 0 itself.

 Approach:
 Use a dummy node to simplify list construction. Traverse both linked lists and keep track of the carry.
 For each digit, compute the sum of the digits and carry, and create a new node with the result.
 Continue until both lists are exhausted and there is no carry left.
 */

public class M_2_AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode sum = dummy;
        int carry=0;
        while(l1!=null || l2!=null || carry!=0){
            int val1=0;
            int val2=0;
            if(l1!=null){
                val1=l1.val;
                l1=l1.next;
            }
            if(l2!=null){
                val2=l2.val;
                l2=l2.next;
            }
            int total=val1+val2+carry;
            carry=total/10;
            sum.next = new ListNode(total%10);
            sum=sum.next;
        }
        return dummy.next;
    }
}
