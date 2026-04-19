from common import ListNode


class LinkedList:
    def __init__(self):
        self.head = None
        self._size = 0

    def get_head(self):
        return self.head

    def size(self):
        return self._size

    def is_empty(self):
        return self._size == 0

    def insert_first(self, val):
        self.head = ListNode(val, self.head)
        self._size += 1

    def insert_last(self, val):
        node = ListNode(val)
        if self.head is None:
            self.head = node
        else:
            curr = self.head
            while curr.next is not None:
                curr = curr.next
            curr.next = node
        self._size += 1

    def insert_at(self, index, val):
        if index <= 0 or self.head is None:
            self.insert_first(val)
            return
        if index >= self._size:
            self.insert_last(val)
            return

        prev = self.head
        for _ in range(1, index):
            prev = prev.next
        prev.next = ListNode(val, prev.next)
        self._size += 1

    def delete_first(self):
        if self.head is None:
            return
        self.head = self.head.next
        self._size -= 1

    def delete_last(self):
        if self.head is None:
            return
        if self.head.next is None:
            self.head = None
            self._size = 0
            return

        prev = self.head
        curr = self.head.next
        while curr.next is not None:
            prev = curr
            curr = curr.next
        prev.next = None
        self._size -= 1

    def delete_by_value(self, val):
        if self.head is None:
            return
        if self.head.val == val:
            self.delete_first()
            return

        prev = self.head
        curr = self.head.next
        while curr is not None:
            if curr.val == val:
                prev.next = curr.next
                self._size -= 1
                return
            prev = curr
            curr = curr.next

    def search(self, val):
        curr = self.head
        while curr is not None:
            if curr.val == val:
                return True
            curr = curr.next
        return False

    def display(self):
        print(self)

    def __str__(self):
        values = []
        curr = self.head
        while curr is not None:
            values.append(str(curr.val))
            curr = curr.next
        return "[]" if not values else " -> ".join(values)

