package problems.linkedlist;

import java.util.PriorityQueue;

import common.ListNode;

/**
 * LC: 23
 * https://leetcode.com/problems/merge-k-sorted-lists/
 * You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
 * Merge all the linked-lists into one sorted linked-list and return it.
 *
 * Example 1:
 *
 * Input: lists = [[1,4,5],[1,3,4],[2,6]]
 * Output: [1,1,2,3,4,4,5,6]
 *
 * Example 2:
 *
 * Input: lists = []
 * Output: []
 *
 * Approach: Use a min-heap to always pick the smallest current node among the k lists.
 * Push the head of each non-empty list into the priority queue.
 * Repeatedly pop the smallest node, append it to the merged list, and push its next node if present.
 *
 * Tags: LinkedList
 * Tags: Heap
 * Tags: PriorityQueue
 */
public class H_MergeLists {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);

        // Seed the heap with the current head of each list.
        for (ListNode node : lists) {
            if (node != null) pq.offer(node);
        }

        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        while (!pq.isEmpty()) {
            // Always take the smallest available node.
            curr.next = pq.poll();
            curr=curr.next;

            // Add the next node from the list we just consumed.
            if (curr.next != null) pq.offer(curr.next);

            // Detach the appended node from its old next pointer chain.
            curr.next = null;
        }
        return dummy.next;
    }
}
