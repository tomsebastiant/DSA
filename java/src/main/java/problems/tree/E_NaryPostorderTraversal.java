package problems.tree;

import common.Node;
import java.util.ArrayList;
import java.util.List;

/**
 * LC: 590
 * https://leetcode.com/problems/n-ary-tree-postorder-traversal
 * Given the root of an n-ary tree, return the postorder traversal of its nodes' values.
 *
 * Example 1:
 *
 * Input: root = [1,null,3,2,4,null,5,6]
 * Output: [5,6,3,2,4,1]
 *
 * Approach: Recursion. Visit all children first, then add the current node.
 * Tags: Tree
 * Tags: DFS
 */
public class E_NaryPostorderTraversal {

    public List<Integer> postorder(Node root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        traversePostorder(root, result);
        return result;
    }

    private void traversePostorder(Node currentNode,List<Integer> postorderList) {
        if (currentNode == null) {
            return;
        }

        // First, visit all children
        if(currentNode.children !=null){
            for (Node childNode : currentNode.children) {
                traversePostorder(childNode, postorderList);
            }
        }
        // Then, add the current node's value
        postorderList.add(currentNode.val);
    }
}




