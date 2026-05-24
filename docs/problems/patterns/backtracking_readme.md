# Backtracking

## When to reach for it
Use backtracking when you need to explore all possible combinations, permutations, or configurations and can prune branches early when a partial solution is already invalid.

**Mental trigger:** do I need to build a solution incrementally and undo choices when a path leads nowhere?

## Core idea
Choose → Explore → Undo. At each step, make a choice, recurse into it, then revert the choice before trying the next option. The undo step is what separates backtracking from plain DFS.

## Common variants

- Combination / subset generation
- Permutation generation
- Constraint satisfaction (e.g. valid placements)
- String / sequence building

## IntelliJ or VS Code search
Search for `Tags: DFS` in the `backtracking/` folder.

## Common backtracking problems in this repo

| Problem | File | Key idea |
|---------|------|----------|
| Letter Combinations of a Phone Number | `M_LetterCombination` | at each digit pick one mapped letter, recurse to the next digit, then delete the character to try the next letter |

## The three-step template

```java
void backtrack(state, choices) {
    if (done(state)) {
        record(state);
        return;
    }
    for (choice : choices) {
        apply(choice);        // choose
        backtrack(state, remaining);  // explore
        undo(choice);         // un-choose
    }
}
```

## Notes

The undo step must mirror the apply step exactly — if you appended a character, delete it; if you swapped elements, swap them back.
Pruning (skipping branches that cannot lead to a valid solution) is what makes backtracking practical for large inputs.

## Loop start: permutations vs combinations

- **Permutations** → loop from `0` every time (order matters — `[2,3]` and `[3,2]` are distinct)
- **Combinations** → loop from `start` every time (order doesn't matter — `[2,3]` and `[3,2]` are the same)