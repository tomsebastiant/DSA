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
| Climb Stairs | `E_ClimbStairs` | 1D DP | Fibonacci recurrence — ways(n) = ways(n-1) + ways(n-2); roll two variables |
| Unique Paths | `M_UniquePaths` | 2D DP | seed edges with 1; each cell = above + left |
| Minimum Path Sum | `M_MinPathSum` | 2D DP | in-place; each cell = value + min(above, left) |
| Longest Common Subsequence | `M_LongestCommonSubsequence` | 2D DP | build the answer from prefixes of both strings |
| Maximum Subarray | `M_MaxSubArray` | 1D DP | keep the best subarray ending at the current index |
| Coin Change | `M_CoinChange` | 1D DP | fewest coins: for each amount try every coin denomination |
| Word Break | `M_WordBreak` | 1D DP (Boolean) | dp[i] is true if the prefix of length i can be segmented |
| Partition Equal Subset Sum | `M_ArrayPartitionEqual` | Knapsack | can we pick a subset summing to totalSum / 2 |
| Longest Increasing Subsequence | `M_LengthOfLIS` | 1D DP | dp[i] is the LIS length ending at i; scan all j < i and extend when nums[j] < nums[i] |
| Edit Distance | `M_EditDistance` | 2D DP | matching characters carry the diagonal cost; mismatches take 1 + min of replace/delete/insert |
| House Robber | `M_HouseRobber` | 1D DP | 1D DP rolled into two variables; at each house pick the better of skip (keep prev) or rob (current + prev-prev) |

## Notes

Dynamic programming often shows up with a table, but it can also be compressed into a single array or even a few variables.
The important part is the recurrence, not the storage shape.
