# Stack

## When to reach for it
Use a stack when you need to process elements in last-in-first-out order, or when the answer for the current element depends on the nearest previous element that satisfies some condition.

**Mental trigger:** do I need to remember things in reverse order, or find the nearest greater/smaller element?

## Common variants

- Bracket / delimiter matching
- Monotonic stack (nearest greater or smaller element)
- Stack-based expression evaluation
- Design problems requiring O(1) access to an aggregate (min, max)

## IntelliJ or VS Code search
Search for `Tags: Stack`.

## Common stack problems in this repo

| Problem | File | Variant | Key idea |
|---------|------|---------|----------|
| Valid Parentheses | `M_IsValidParenthesis` | bracket matching | push opening brackets; on a closer, check the top matches |
| Min Stack | `M_MinStack` | design | keep a parallel min-stack that tracks the current minimum at every depth |
| Evaluate Reverse Polish Notation | `M_ReversePolishNotation` | expression evaluation | push operands; on an operator pop two, apply it, push the result |
| Decode String | `M_DecodeString` | nested parsing | two stacks — one for repeat counts, one for the string built so far; push on `[`, pop and expand on `]` |
| Daily Temperatures | `M_DailyTemperature` | monotonic stack | maintain a decreasing stack of indices; pop when a warmer day is found and record the gap |

## Notes

The monotonic stack pattern (Daily Temperatures) generalises to any "next greater element" or "next smaller element" problem.
For bracket problems the key invariant is: the top of the stack is always the most recent unmatched opener.
