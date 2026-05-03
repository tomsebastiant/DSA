# Dynamic Programming

## When to reach for it
Use dynamic programming when a problem can be broken into overlapping subproblems and the best answer can be built from smaller answers.

**Mental trigger:** am I recomputing the same subproblem more than once?

## Common variants

- 1D DP
- 2D DP
- Knapsack-style transitions
- Sequence alignment / substring-style transitions

## IntelliJ or VS Code search
Search for `Tags: DynamicProgramming`.

## Common dynamic programming problems in this repo

| Problem | File | Variant | Key idea |
|---------|------|---------|----------|
| Longest Common Subsequence | `M_LongestCommonSubsequence` | 2D DP | build the answer from prefixes of both strings |
| Maximum Subarray | `M_MaxSubArray` | 1D DP | keep the best subarray ending at the current index |

## Notes

Dynamic programming often shows up with a table, but it can also be compressed into a single array or even a few variables.
The important part is the recurrence, not the storage shape.
