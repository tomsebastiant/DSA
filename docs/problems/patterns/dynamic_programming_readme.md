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
| Target Sum | `M_TargetSum` | Knapsack | assign + or − to each number; equivalent to finding a subset summing to (total + target) / 2; backtracking DFS also included |
| Longest Palindromic Substring | `M_LongestPalindrome` | Interval DP | primary solution uses expand-around-center O(n²); DP version fills dp[i][j] (is s[i..j] a palindrome) by window length |
| Palindromic Substrings | `M_CountPalindrome` | Interval DP | count all palindromic substrings; same expand-around-center approach; DP version also included as comment |
| Burst Balloons | `H_BurstBalloons` | Interval DP | dp[i][j] = max coins from the balloons between i and j; choose the last balloon to burst to remove dependency on already-burst neighbours |
| Longest Palindromic Subsequence | `M_LongestPalindromeSubsequence` | Interval DP | dp[i][j] = LPS length of s[i..j]; fill by window length; extend by 2 when ends match, otherwise take the better single-end drop |

## Notes

Dynamic programming often shows up with a table, but it can also be compressed into a single array or even a few variables.
The important part is the recurrence, not the storage shape.
