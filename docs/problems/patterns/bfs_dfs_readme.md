# BFS and DFS

## When to use BFS
- Shortest path in an unweighted graph
- Level-by-level processing
- Nearest or minimum-step problems

**Data structure:** queue

## When to use DFS
- Exhaustive exploration
- Connected components
- Tree traversals
- Backtracking

**Data structure:** recursion or stack

## IntelliJ or VS Code search
Search for `Tags: BFS` or `Tags: DFS`.

## BFS problems in this repo

| Problem | File | Key idea |
|---------|------|----------|
| Keys and Rooms | `M_KeysAndRooms` | walk the reachable rooms with a queue or stack-like traversal |
| Find Leftmost Value in Tree | `M_FindLeftmostValueofTree` | record the first node seen at each level |
| Sum of Left Leaves | `E_SumOfLeftLeaves` | carry whether the current node is a left child |
| Completeness of Binary Tree | `M_CompletenessOfBinaryTree` | stop when a null appears before a non-null |

## DFS problems in this repo

| Problem | File | Key idea |
|---------|------|----------|
| Number of Islands | `M_NumberOfIslands` | flood fill each island and mark visited cells |
| Binary Tree Inorder Traversal | `E_BinaryTreeInorder` | recurse left, visit node, recurse right |
| N-ary Tree Preorder Traversal | `E_NaryPreorderTraversal` | node first, then children |
| N-ary Tree Postorder Traversal | `E_NaryPostorderTraversal` | children first, then node |
| Merge Two Binary Trees | `E_Merge2BinaryTrees` | recurse both trees together |
| Largest Value in Each Tree Row | `M_LargestValueInTreeRow` | track a maximum for each level |
| Maximum Width of Binary Tree | `M_MaxWidthOfBinaryTree` | keep positional indices while traversing |
| Binary Tree Pruning | `M_BinaryTreePruning` | prune from the leaves upward |
| Flatten Binary Tree to Linked List | `M_FlattenBinaryTree` | preorder-style rewiring |
| Build Tree from Inorder and Preorder | `M_BuildTreeFromInorderPreorder` | root comes from preorder, split inorder |
| Distribute Coins in Binary Tree | `M_DistributeCoinsBinaryTree` | return the excess coins up the tree |

## Notes

This section covers both graph and tree traversal because the same search patterns show up in both places.
