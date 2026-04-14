package leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 https://leetcode.com/problems/n-ary-tree-preorder-traversal
 Given the root of a binary tree, return the inorder traversal of its nodes' values.

 Approach 1 :Recursion
 Traverse using recursion. Add node, the traverse children

 Approach 2 :Iteration

 while (!stack.empty()) {
     root = stack.pop();
     list.add(root.val);
     //Children have to added in reverse to the stack to ensure left to right traversal
     for (int i = root.children.size() - 1; i >= 0; i--)
        stack.add(root.children.get(i));
 }

 */
public class E_589_NaryPreorderTraversal {
    public List<Integer> preorder(Node root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        traversepreorder(root, result);
        return result;
    }

    private void traversepreorder(Node currentNode, List<Integer> preorderList) {
        if (currentNode == null) {
            return;
        }
        // Then, add the current node's value
        preorderList.add(currentNode.val);
        // First, visit all children
        if (currentNode.children != null) {
            for (Node childNode : currentNode.children) {
                traversepreorder(childNode, preorderList);
            }
        }
    }
}
