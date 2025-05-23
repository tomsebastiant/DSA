package leetcode.tree;

/**
 Tags:
 https://leetcode.com/problems/binary-tree-pruning
 Given the root of a binary tree, return the same tree where every subtree
 (of the given tree) not containing a 1 has been removed.

 A subtree of a node is node plus every node that is a descendant of node.

 Approach: Using recursion we traverse down. A leaf node is removed if its value is 0. This
 return null back up and it continues back.
 */
public class M_814_BinaryTreePruning {
    public TreeNode pruneTree(TreeNode root) {
        if(root==null) return null;
        root.left=pruneTree(root.left);
        root.right=pruneTree(root.right);
        if(root.left==null && root.right==null && root.val==0){
            return null;
        }
        return root;
    }
}
