package problems.tree;

/**
 * LC: 236
 * Tags: Tree
 * Tags: DFS
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes. The LCA is
 * defined as the lowest node that has both p and q as descendants (a node can be a descendant
 * of itself).
 *
 * Example 1:
 *
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * Output: 3
 * Explanation: The LCA of nodes 5 and 1 is 3.
 *
 * Example 2:
 *
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * Output: 5
 * Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself.
 *
 * Example 3:
 *
 * Input: root = [1,2], p = 1, q = 2
 * Output: 1
 *
 * Approach: Post-order DFS — recurse into both subtrees first. If both sides return non-null,
 * the current node straddles p and q and is the LCA. If only one side finds a target, propagate
 * it up. Base case: return the node itself if it is null, p, or q.
 */
public class M_LowestCommonAncestor {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null || root==p || root==q) return root;

        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);

        if(left!=null && right!=null) return root;

        return left!=null?left:right;
    }
}
