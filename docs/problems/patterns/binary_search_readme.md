# Binary Search

## When to reach for it
Use binary search when the search space is sorted or monotonic — meaning you can always discard half of it based on a condition.

**Mental trigger:** can I answer "is this value too small or too large?" in O(1) or O(n), reducing the space in half each time?

## Common variants

- Classic sorted array search
- Search on a rotated sorted array
- Search on the answer space (binary search on the value, not the index)

## IntelliJ or VS Code search
Search for `Tags: BinarySearch`.

## Common binary search problems in this repo

| Problem | File | Variant | Key idea |
|---------|------|---------|----------|
| Search in Rotated Sorted Array | `M_RotatedBinarySearch` | rotated array | determine which half is still sorted on every iteration; target must lie in the sorted half |
| Find Minimum in Rotated Sorted Array | `M_MinSortedRotatedArray` | rotated array | if nums[mid] > nums[r] the minimum is in the right half; otherwise shrink right to mid |
| Search a 2D Matrix | `M_SearchMatrix` | 2D array | eliminate rows using the last-element upper bound, then binary search within the candidate row |
| Koko Eating Bananas | `M_KokoCanEatBanana` | answer space | binary search speeds in [1, max(piles)]; check feasibility with ceiling division |
| Split Array Largest Sum | `H_CanSplitMinSum` | answer space | binary search the minimum possible largest sum; greedy counts the splits needed for a given limit |
| Kth Smallest Element in BST | `M_KthSmallestBST` | BST | inorder traversal visits BST values in sorted order; stop at the k-th node |

## Notes

Answer-space binary search is the hardest variant to recognise. The signal is a minimise/maximise problem where the feasibility of a candidate value can be checked greedily in one pass.
Rotated-array problems require checking which half is sorted before deciding where the target can be.
