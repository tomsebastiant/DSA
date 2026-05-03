# Sliding Window

## When to reach for it
Use sliding window when you need to process a contiguous subarray or substring without restarting work from scratch.

**Mental trigger:** can I move one boundary at a time and maintain enough state to answer the current window?

## Common variants

- Fixed-size window
- Variable-size window
- Monotonic deque / queue for window maximums

## IntelliJ or VS Code search
Search for `Tags: SlidingWindow` or `Tags: Sliding Window`.
For window-maximum problems, also search for `Tags: Monotonic Queue` or `Tags: Deque`.

## Common sliding window problems in this repo

| Problem | File | Variant | Key idea |
|---------|------|---------|----------|
| Sliding Window Maximum | `H_MaxSlidingWindow` | fixed size + monotonic deque | keep a decreasing deque of indices so the front is always the max |
| Max Consecutive Ones III | `M_LongestOnes` | variable size | grow right, shrink left while zero count exceeds `k` |
| Minimum Size Subarray Sum | `M_MinSubArrayLen` | variable size | expand until sum reaches the target, then shrink to minimize length |
| Fruit Into Baskets | `M_TotalFruit` | variable size | keep at most 2 fruit types in the window using a frequency map |
| Longest Substring Without Repeating Characters | `M_lengthOfLongestSubstring` | variable size | use a set and shrink until the window is unique again |

## Notes

Some window problems are fixed-size and some are flexible-size.
The underlying idea is the same: maintain the current answer incrementally as the window moves.
