from collections import deque


class Node:
    def __init__(self, data=0, left=None, right=None):
        self.data = data
        self.left = left
        self.right = right


class BinaryTree:
    def left_view(self, root):
        result = []
        self._left_view(root, 0, result)
        return result

    def _left_view(self, root, level, result):
        if root is None:
            return
        if len(result) == level:
            result.append(root.data)
        self._left_view(root.left, level + 1, result)
        self._left_view(root.right, level + 1, result)

    def size(self, root):
        if root is None:
            return 0
        return 1 + self.size(root.left) + self.size(root.right)

    def height(self, root):
        if root is None:
            return 0
        return 1 + max(self.height(root.left), self.height(root.right))

    def count_leaves(self, root):
        if root is None:
            return 0
        if root.left is None and root.right is None:
            return 1
        return self.count_leaves(root.left) + self.count_leaves(root.right)

    def inorder(self, root):
        result = []
        self._inorder(root, result)
        return result

    def _inorder(self, root, result):
        if root is None:
            return
        self._inorder(root.left, result)
        result.append(root.data)
        self._inorder(root.right, result)

    def preorder(self, root):
        result = []
        self._preorder(root, result)
        return result

    def _preorder(self, root, result):
        if root is None:
            return
        result.append(root.data)
        self._preorder(root.left, result)
        self._preorder(root.right, result)

    def postorder(self, root):
        result = []
        self._postorder(root, result)
        return result

    def _postorder(self, root, result):
        if root is None:
            return
        self._postorder(root.left, result)
        self._postorder(root.right, result)
        result.append(root.data)

    def level_order(self, root):
        result = []
        if root is None:
            return result
        queue = deque([root])
        while queue:
            node = queue.popleft()
            result.append(node.data)
            if node.left is not None:
                queue.append(node.left)
            if node.right is not None:
                queue.append(node.right)
        return result

    def search(self, root, target):
        if root is None:
            return False
        if root.data == target:
            return True
        return self.search(root.left, target) or self.search(root.right, target)

    def mirror(self, root):
        if root is None:
            return None
        mirrored = Node(root.data)
        mirrored.left = self.mirror(root.right)
        mirrored.right = self.mirror(root.left)
        return mirrored

    def mirror_in_place(self, root):
        if root is None:
            return None
        root.left, root.right = self.mirror_in_place(root.right), self.mirror_in_place(root.left)
        return root

