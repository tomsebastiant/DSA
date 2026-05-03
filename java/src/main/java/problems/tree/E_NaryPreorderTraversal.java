package problems.tree;

import common.Node;
import java.util.ArrayList;
import java.util.List;

/**
 * LC: 589
 * https://leetcode.com/problems/n-ary-tree-preorder-traversal
 * Given the root of an n-ary tree, return the preorder traversal of its nodes' values.
 *
 * Example 1:
 *
 * Input: root = [1,null,3,2,4,null,5,6]
 * Output: [1,3,5,6,2,4]
 *
 * Approach: Recursion. Visit the current node first, then traverse each child from left to right.
 * Tags: Tree
 * Tags: DFS
 */
public class E_NaryPreorderTraversal {
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
        // First, add the current node's value.
        preorderList.add(currentNode.val);
        // Then, visit all children from left to right.
        if (currentNode.children != null) {
            for (Node childNode : currentNode.children) {
                traversepreorder(childNode, preorderList);
            }
        }
    }
}




