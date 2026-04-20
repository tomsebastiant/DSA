package problems.linkedlist;

import java.util.HashMap;
import java.util.Map;

/**
 * LC: 146
 * https://leetcode.com/problems/lru-cache
 * Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.
 *
 * Implement the LRUCache class:
 * - LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
 * - int get(int key) Return the value of the key if the key exists, otherwise return -1.
 * - void put(int key, int value) Update the value of the key if the key exists.
 *   Otherwise, add the key-value pair to the cache. If the number of keys exceeds the capacity,
 *   evict the least recently used key.
 *
 * Approach: Use a hash map for O(1) lookups and a doubly linked list to maintain recency order.
 * Tags: LinkedList
 * Tags: Design
 */
public class M_LRUCache {

    private static class Node {
        int key;
        int val;
        Node next;
        Node prev;
    }

    private final Node head = new Node();
    private final Node tail = new Node();
    private final Map<Integer, Node> nodeMap;
    private final int cacheCapacity;

    public M_LRUCache(int capacity) {
        this.nodeMap = new HashMap<>(capacity);
        this.cacheCapacity = capacity;
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        Node node = nodeMap.get(key);
        if (node == null) {
            return -1;
        }

        remove(node);
        add(node);
        return node.val;
    }

    public void put(int key, int value) {
        Node node = nodeMap.get(key);
        if (node != null) {
            node.val = value;
            remove(node);
            add(node);
            return;
        }

        if (nodeMap.size() == cacheCapacity) {
            Node lru = tail.prev;
            nodeMap.remove(lru.key);
            remove(lru);
        }

        Node newNode = new Node();
        newNode.key = key;
        newNode.val = value;
        add(newNode);
        nodeMap.put(key, newNode);
    }

    // add always adds to the front of the linkedlist
    private void add(Node node) {
        Node headNext = head.next;
        node.next = headNext;
        node.prev = head;
        head.next = node;
        headNext.prev = node;
    }

    private void remove(Node node) {
        Node nextNode = node.next;
        Node prevNode = node.prev;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }
}
