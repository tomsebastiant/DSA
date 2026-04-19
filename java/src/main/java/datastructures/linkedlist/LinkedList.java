package datastructures.linkedlist;

import common.ListNode;

public class LinkedList {

    private ListNode head;
    private int size;

    public LinkedList() {
        this.head = null;
        this.size = 0;
    }

    public ListNode getHead() {
        return head;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void insertFirst(int val) {
        head = new ListNode(val, head);
        size++;
    }

    public void insertLast(int val) {
        ListNode node = new ListNode(val);
        if (head == null) {
            head = node;
        } else {
            ListNode curr = head;
            while (curr.next != null) {
                curr = curr.next;
            }
            curr.next = node;
        }
        size++;
    }

    public void insertAt(int index, int val) {
        if (index <= 0 || head == null) {
            insertFirst(val);
            return;
        }
        if (index >= size) {
            insertLast(val);
            return;
        }

        ListNode prev = head;
        for (int i = 1; i < index; i++) {
            prev = prev.next;
        }
        prev.next = new ListNode(val, prev.next);
        size++;
    }

    public void deleteFirst() {
        if (head == null) {
            return;
        }
        head = head.next;
        size--;
    }

    public void deleteLast() {
        if (head == null) {
            return;
        }
        if (head.next == null) {
            head = null;
            size = 0;
            return;
        }

        ListNode prev = head;
        ListNode curr = head.next;
        while (curr.next != null) {
            prev = curr;
            curr = curr.next;
        }
        prev.next = null;
        size--;
    }

    public void deleteByValue(int val) {
        if (head == null) {
            return;
        }

        if (head.val == val) {
            deleteFirst();
            return;
        }

        ListNode prev = head;
        ListNode curr = head.next;
        while (curr != null) {
            if (curr.val == val) {
                prev.next = curr.next;
                size--;
                return;
            }
            prev = curr;
            curr = curr.next;
        }
    }

    public boolean search(int val) {
        ListNode curr = head;
        while (curr != null) {
            if (curr.val == val) {
                return true;
            }
            curr = curr.next;
        }
        return false;
    }

    public void display() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        ListNode curr = head;
        while (curr != null) {
            builder.append(curr.val);
            if (curr.next != null) {
                builder.append(" -> ");
            }
            curr = curr.next;
        }
        if (builder.length() == 0) {
            return "[]";
        }
        return builder.toString();
    }
}
