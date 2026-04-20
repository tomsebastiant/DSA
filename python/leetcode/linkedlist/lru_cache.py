class M_LRUCache:
    """
    LC: 146
    https://leetcode.com/problems/lru-cache
    Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.

    Implement the LRUCache class:
    - LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
    - int get(int key) Return the value of the key if the key exists, otherwise return -1.
    - void put(int key, int value) Update the value of the key if the key exists.
      Otherwise, add the key-value pair to the cache. If the number of keys exceeds the capacity,
      evict the least recently used key.

    Approach: Use a hash map for O(1) lookups and a doubly linked list to maintain recency order.
    Tags: LinkedList
    Tags: Design
    """

    class Node:
        def __init__(self, key=0, val=0):
            self.key = key
            self.val = val
            self.next = None
            self.prev = None

    def __init__(self, capacity):
        self.node_map = {}
        self.cache_capacity = capacity
        self.head = self.Node()
        self.tail = self.Node()
        self.head.next = self.tail
        self.tail.prev = self.head

    def get(self, key):
        node = self.node_map.get(key)
        if node is None:
            return -1

        self._remove(node)
        self._add(node)
        return node.val

    def put(self, key, value):
        node = self.node_map.get(key)
        if node is not None:
            node.val = value
            self._remove(node)
            self._add(node)
            return

        if len(self.node_map) == self.cache_capacity:
            lru = self.tail.prev
            del self.node_map[lru.key]
            self._remove(lru)

        new_node = self.Node(key, value)
        self._add(new_node)
        self.node_map[key] = new_node

    def _add(self, node):
        head_next = self.head.next
        node.next = head_next
        node.prev = self.head
        self.head.next = node
        head_next.prev = node

    def _remove(self, node):
        next_node = node.next
        prev_node = node.prev
        prev_node.next = next_node
        next_node.prev = prev_node

