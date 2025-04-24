package leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 https://leetcode.com/problems/n-ary-tree-postorder-traversal
 Given the root of an n-ary tree, return the postorder traversal of its nodes' values.

 Approach 1: Recursion
 Traverse the tree using recusrion. Add the visited node to the result list only AFTER visting all its children

 Approach 2: Stack
 Traverse the tree using interation and stacks. This give the preorder traversal. REVERSE the result before returning


 */
public class E_590_NaryPostorderTraversal {

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
