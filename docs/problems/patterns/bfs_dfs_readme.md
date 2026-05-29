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
| Word Ladder | `H_WordLadder` | try every one-letter substitution at each step; BFS guarantees the shortest transformation sequence |
| Keys and Rooms | `M_KeysAndRooms` | walk the reachable rooms with a queue or stack-like traversal |
| Course Schedule | `M_CoursesCanFinish` | use indegrees and Kahn's algorithm to detect cycles |
| Rotting Oranges | `M_RottingOranges` | spread rot one minute at a time with multi-source BFS |
| Find Leftmost Value in Tree | `M_FindLeftmostValueofTree` | record the first node seen at each level |
| Completeness of Binary Tree | `M_CompletenessOfBinaryTree` | stop when a null appears before a non-null |
| Course Schedule II | `M_CourseSchedule2` | Kahn's topological sort; collect a valid ordering and detect cycles via output size |
| Shortest Path in Binary Matrix | `M_ShortedBinaryPathMatrix` | BFS from (0,0) in all 8 directions; mark cells visited in-place; first time (n-1,n-1) is reached is the shortest clear path |

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
| Sum of Left Leaves | `E_SumOfLeftLeaves` | traverse with a stack; add the value when the top node has a left leaf |
| Flatten Binary Tree to Linked List | `M_FlattenBinaryTree` | preorder-style rewiring |
| Build Tree from Inorder and Preorder | `M_BuildTreeFromInorderPreorder` | root comes from preorder, split inorder |
| Distribute Coins in Binary Tree | `M_DistributeCoinsBinaryTree` | return the excess coins up the tree |
| Serialize and Deserialize Binary Tree | `H_TreeSerializeDeserialize` | preorder DFS with null sentinels; shared queue in deserialization restores structure |
| Clone Graph | `M_CloneGraph` | DFS with a hash map to track already-cloned nodes and avoid revisiting |
| Max Area of Island | `M_MaxIslandArea` | sink each visited cell to 0 and accumulate area; track the max across all islands |
| Lowest Common Ancestor | `M_LowestCommonAncestor` | post-order DFS; current node is LCA when both subtrees return non-null |
| Letter Combinations of a Phone Number | `M_LetterCombination` | backtracking DFS; pick one letter per digit, recurse, then undo the choice |
| Kth Smallest Element in BST | `M_KthSmallestBST` | inorder traversal visits values in sorted order; stop at the k-th node |
| Validate Binary Search Tree | `E_ValidateBinarySearchTree` | DFS passing valid min/max bounds down to each node |
| Range Sum of BST | `E_RangeSumOfBST` | DFS pruning branches whose values fall outside the given range |
| Path Sum | `E_PathSum` | DFS subtracting the node value; return true when a leaf with zero remainder is reached |
| Maximum Depth of Binary Tree | `E_MaxDepthOfBinaryTree` | return 1 + max of left and right recursive depths |
| Symmetric Tree | `E_SymmetricTree` | recursively check that left and right subtrees are mirror images |
| Surrounded Regions | `M_SurroundedRegions` | DFS from every border 'O' marks safe cells with a sentinel; a final pass flips remaining 'O's to 'X' and restores sentinels |
| Combination Sum | `M_CombinationSum` | backtracking with a start index to build combinations; reuse allowed so the same candidate can be picked again |

## Notes

This section covers both graph and tree traversal because the same search patterns show up in both places.
Topological sort problems are included here when the implementation uses a BFS queue and indegree counts.
