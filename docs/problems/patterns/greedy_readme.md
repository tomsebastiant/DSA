# Greedy

## When to reach for it
Use greedy when each step can be chosen locally and still lead to a global optimum.

**Mental trigger:** can I make a choice now that I will not need to undo later?

## Core idea
Sort first when needed, then make one pass and keep the best local state.

## IntelliJ or VS Code search
Search for `Tags: Greedy`.

## Common greedy problems in this repo

| Problem | File | Key idea |
|---------|------|----------|
| Best Time to Buy and Sell Stock I | `E_BuySellStock1` | track the minimum price seen so far |
| Best Time to Buy and Sell Stock II | `M_BuySellStock2` | add every positive price gain |
| Assign Cookies | `E_AssignCookies` | match the smallest useful cookie first |
| Can Place Flowers | `E_CanPlaceFlowers` | only place when both neighbours are empty |
| Candy | `H_Candy` | do a left pass and a right pass |
| Gas Station | `M_GasStation` | reset the start when the tank goes negative |
| Queue Reconstruction by Height | `M_QueueBuildWithHeight` | sort tall people first, then insert by `k` |
| Non-overlapping Intervals | `M_NonOverlappingIntervals` | sort by end time and keep the earliest finish |
| Minimum Number of Arrows to Burst Balloons | `M_ArrowsToBurstBalloons` | merge overlapping intervals by end |
| Jump Game | `M_JumpGame` | track the farthest reachable index |
| Jump Game II | `M_JumpGame2` | track the current jump boundary |
| Hand of Straights | `M_HandOfStraights` | always build from the smallest available card |
| Is Subsequence | `E_IsSubsequence` | two pointers, advance on matches only |

## Notes

Some array problems also mix in sorting or two pointer technique. The greedy tag is the main revision hook.
