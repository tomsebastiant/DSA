package leetcode.tree;

import java.util.HashMap;
import java.util.Map;

/**
 https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal
 Given two integer arrays preorder and inorder where preorder is the preorder traversal
 of a binary tree and inorder is the inorder traversal of the same tree, construct and return the binary tree.

 Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
 Output: [3,9,20,null,null,15,7]


 Approach :Recursion
 In preorder, the first element is always the root.
 In inorder, everything left of the root is the left subtree, and everything right is the right subtree.
 Start from the first preorder element (root), keep track of it
 Use a HashMap to get index of root in the inorder array in O(1) time.
 Build left tree first since we're consuming preorder from the start
 */

public class M_105_BuildTreeFromInorderPreorder {
    int preIndex;
    Map<Integer,Integer> inorderMap;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        preIndex=0;
        inorderMap = new HashMap<>();

        for(int i=0;i<inorder.length;i++){
            inorderMap.put(inorder[i],i);
        }

        return helper(preorder,0,inorder.length-1);
    }

    public TreeNode helper(int[] preorder, int start, int end){
        if(start>end) return null;

        int val = preorder[preIndex++];
        TreeNode root = new TreeNode(val);

        int inorderIndex = inorderMap.get(val);
        root.left=helper(preorder,start,inorderIndex-1);
        root.right=helper(preorder,inorderIndex+1,end);


        return root;
    }
}
