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
| Container With Most Water | `M_ContainerWithMostWater` | move the shorter wall inward and keep the best area |
| Is Subsequence | `E_IsSubsequence` | two pointers, advance on matches only |
| Task Scheduler | `M_TaskScheduler` | frequency-based bucket formula; answer is max of skeleton size and total task count |
| Split Array Largest Sum | `H_CanSplitMinSum` | binary search on the feasible answer range; greedy check counts minimum splits for a given limit |
| Reorganize String | `M_ReorganizeString` | count character frequencies and use a max-heap to always place the two most frequent remaining characters side by side |
| Video Stitching | `M_VideoStitching` | sort clips by start; two-tier greedy loop extends the coverage frontier to the farthest clip reachable from the current boundary |
| Minimum Number of Taps to Open to Water a Garden | `H_MinTaps` | convert each tap to its watering interval, then apply the same interval-cover greedy as Jump Game II; return -1 if no tap bridges a gap |
| Longest Palindrome | `E_LongestPalindrome` | count character frequencies; every pair contributes 2 to the length; one odd-frequency character can sit at the center |
| Longest Palindrome by Concatenating Two Letter Words | `M_LongestPalindromeWith2LetterWords` | pair each word with its reverse; self-palindromic words (e.g. "aa") place pairs symmetrically, one leftover can be the center |
| Largest Palindromic Number | `M_LargestPalindromeNumber` | count digit frequencies; greedily place largest digit pairs first (outer positions); fallback to 'b' at the end when all digits are 'a' |
| Minimum Deletions to Make Frequencies Unique | `M_MinDeletions` | sort frequencies descending; for each, decrement until an unclaimed slot is found — each decrement is one deletion |
| Break a Palindrome | `M_BreakPalindrome` | replace the first non-'a' in the first half with 'a'; if the whole first half is 'a', change the last character to 'b' |
| Array of Doubled Pairs | `M_ReorderDoubled` | sort keys by absolute value; greedily consume key*2 entries for each key; absolute-value sort handles negatives correctly |

## Notes

Some array problems also mix in sorting or two pointer technique. The greedy tag is the main revision hook.
`Container With Most Water` is a good example of a problem that appears in both the greedy and two pointer buckets.
