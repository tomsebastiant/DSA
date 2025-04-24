package leetcode.linkedlist;

/**
 https://leetcode.com/problems/palindrome-linked-list
 Given the head of a singly linked list, return true if it is a palindrome or false otherwise.

 Approach:
 Constant space
 Traverse the linked list till mid using slow and fast pointer. From the slow pointer reverse
 half the LinkedList. Then traverse the 2 half linkedlists to check if they're the same

 Extra space
 Add all elements of the linkedlist to a stack. Then traverse the linkedlist, pop the elements from
 the stack and compare to check if its a palindrome
 */
public class E_234_PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode revHead = reverseList(slow);
        while(head!=null && revHead!=null){
            if(head.val!=revHead.val)
                return false;
            head=head.next;
            revHead=revHead.next;
        }
        return true;

    }

    public ListNode reverseList(ListNode head){
        ListNode prev=null;
        while(head!=null){
            ListNode next=head.next;
            head.next=prev;
            prev=head;
            head=next;
        }
        return prev;
    }
}
