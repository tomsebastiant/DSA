package leetcode.linkedlist;

/**
 Tags:
 https://leetcode.com/problems/partition-list
 Given the head of a linked list and a value x, partition it such that all nodes less
 than x come before nodes greater than or equal to x.

 You should preserve the original relative order of the nodes in each of the two partitions.

 Approach: Keep 2 dummy nodes as first and second. Traverse the master list, if
 the value  is greater than x, attach to first list, else attach to second list.
 attach end of first list to dummy2.next;

 */
public class M_86_PartitionList {
    public ListNode partition(ListNode head, int x) {
        if(head==null) return null;
        ListNode dummy1 = new ListNode(0);
        ListNode dummy2 = new ListNode(0);
        ListNode first = dummy1;
        ListNode second = dummy2;
        while(head!=null){
            if(head.val<x){
                first.next=head;
                first=first.next;
            } else {
                second.next=head;
                second=second.next;
            }
            head=head.next;
        }
        second.next=null;
        first.next=dummy2.next;
        return dummy1.next;
    }
}
