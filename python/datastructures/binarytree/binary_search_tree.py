from collections import deque

from common import TreeNode


class BinarySearchTree:
    def __init__(self):
        self.root = None

    def get_root(self):
        return self.root

    def is_empty(self):
        return self.root is None

    def clear(self):
        self.root = None

    def insert(self, val):
        self.root = self._insert(self.root, val)

    def _insert(self, node, val):
        if node is None:
            return TreeNode(val)
        if val < node.val:
            node.left = self._insert(node.left, val)
        elif val > node.val:
            node.right = self._insert(node.right, val)
        return node

    def search(self, val):
        return self._search(self.root, val) is not None

    def _search(self, node, val):
        while node is not None:
            if val < node.val:
                node = node.left
            elif val > node.val:
                node = node.right
            else:
                return node
        return None

    def delete(self, val):
        self.root = self._delete(self.root, val)

    def _delete(self, node, val):
        if node is None:
            return None
        if val < node.val:
            node.left = self._delete(node.left, val)
        elif val > node.val:
            node.right = self._delete(node.right, val)
        else:
            if node.left is None:
                return node.right
            if node.right is None:
                return node.left
            successor = self._min_node(node.right)
            node.val = successor.val
            node.right = self._delete(node.right, successor.val)
        return node

    def find_min(self):
        if self.root is None:
            raise ValueError("BST is empty")
        return self._min_node(self.root).val

    def find_max(self):
        if self.root is None:
            raise ValueError("BST is empty")
        return self._max_node(self.root).val

    def _min_node(self, node):
        curr = node
        while curr is not None and curr.left is not None:
            curr = curr.left
        return curr

    def _max_node(self, node):
        curr = node
        while curr is not None and curr.right is not None:
            curr = curr.right
        return curr

    def height(self):
        return self._height(self.root)

    def _height(self, node):
        if node is None:
            return 0
        return 1 + max(self._height(node.left), self._height(node.right))

    def inorder(self):
        result = []
        self._inorder(self.root, result)
        return result

    def _inorder(self, node, result):
        if node is None:
            return
        self._inorder(node.left, result)
        result.append(node.val)
        self._inorder(node.right, result)

    def preorder(self):
        result = []
        self._preorder(self.root, result)
        return result

    def _preorder(self, node, result):
        if node is None:
            return
        result.append(node.val)
        self._preorder(node.left, result)
        self._preorder(node.right, result)

    def postorder(self):
        result = []
        self._postorder(self.root, result)
        return result

    def _postorder(self, node, result):
        if node is None:
            return
        self._postorder(node.left, result)
        self._postorder(node.right, result)
        result.append(node.val)

    def level_order(self):
        result = []
        if self.root is None:
            return result
        queue = deque([self.root])
        while queue:
            node = queue.popleft()
            result.append(node.val)
            if node.left is not None:
                queue.append(node.left)
            if node.right is not None:
                queue.append(node.right)
        return result

