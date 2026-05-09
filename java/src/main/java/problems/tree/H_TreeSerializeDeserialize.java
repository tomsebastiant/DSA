package problems.tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * LC: 297
 * Tags: Tree
 * Tags: DFS
 * Tags: Design
 * Tags: String
 * https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
 * Serialization is the process of converting a data structure or object into a sequence of bits so
 * that it can be stored in a file or memory buffer, or transmitted across a network connection link
 * to be reconstructed later in the same or another computer environment.
 *
 * Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how
 * your serialization/deserialization algorithm should work. You just need to ensure that a binary
 * tree can be serialized to a string and this string can be deserialized to the original tree structure.
 *
 * Example 1:
 *
 * Input: root = [1,2,3,null,null,4,5]
 * Output: [1,2,3,null,null,4,5]
 *
 * Example 2:
 *
 * Input: root = []
 * Output: []
 *
 * Constraints:
 * The number of nodes in the tree is in the range [0, 10^4].
 * -1000 <= Node.val <= 1000
 *
 * Approach: Serialize with preorder DFS — write each node's value then recursively its left and
 * right subtrees, using "null" as a sentinel for absent nodes. Deserialize by splitting on commas
 * into a queue and consuming values in the same preorder order: each recursive call pops the front
 * token and either returns null (sentinel) or builds a node and attaches its left and right children.
 * The shared queue naturally advances across all recursive calls without any index tracking.
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class H_TreeSerializeDeserialize {
    public String serialize(TreeNode root) {
        if (root == null)
            return "null";
        // Preorder: current value first, then left subtree, then right subtree.
        return root.val + "," + serialize(root.left) + "," + serialize(root.right);
    }

    public TreeNode deserialize(String data) {
        // Split into a queue so each recursive call can consume the next token in sequence.
        Queue<String> q = new LinkedList<>(Arrays.asList(data.split(",")));
        return build(q);
    }

    public TreeNode build(Queue<String> queue) {
        String curr = queue.poll();
        // Sentinel value marks where a subtree is absent — mirrors the null written during serialize.
        if (curr.equals("null"))
            return null;
        TreeNode node = new TreeNode(Integer.parseInt(curr));
        // Left child must be built before right to match the preorder serialization order.
        node.left = build(queue);
        node.right = build(queue);
        return node;
    }
}
