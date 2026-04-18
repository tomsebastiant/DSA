# Two pointer

## When to reach for it
Use two pointers when the search space can be reduced from both ends or with a slow/fast pair.

**Mental trigger:** can I shrink the search space by moving two boundaries inward?

## Variants

- Left/right scan
- Slow/fast scan
- Fixed pointer plus moving pointer

## IntelliJ or VS Code search
Search for `Tags: TwoPointer`.

## Common two pointer problems in this repo

| Problem | File | Variant | Key idea |
|---------|------|---------|----------|
| Two Sum II | `M_TwoSum2` | left/right | move the ends based on the current sum |
| Container With Most Water | `M_ContainerWithMostWater` | left/right | move the shorter wall inward |
| 3Sum Closest | `M_3SumClosest` | fixed + left/right | fix one index, sweep the rest |
| Trapping Rain Water | `H_TrappingRainWater` | left/right | keep track of the best wall seen from both sides |

## Related list techniques

The linked list solutions also use pointer movement heavily, especially:

| Problem | File | Pointer idea |
|---------|------|--------------|
| Reverse Linked List | `E_ReverseLinkedList` | pointer reversal |
| Palindrome Linked List | `E_PalindromeLinkedList` | slow/fast midpoint plus reversal |
| Add Two Numbers | `M_AddTwoNumbers` | carry through linked nodes |
| Sort List | `M_SortList` | split with slow/fast, then merge |
| Reverse Linked List II | `M_ReverseLinkedList2` | pointer rewiring in a range |
| Partition List | `M_PartitionList` | build two pointer chains |
| Odd Even Linked List | `M_OddEvenLinkedList` | weave odd and even positions |
| Swap Nodes in Pairs | `M_SwapNodesInPairs` | pairwise pointer rewiring |

## Notes

The linked list files do not all carry a `TwoPointer` tag, but they use the same pointer thinking during review.
