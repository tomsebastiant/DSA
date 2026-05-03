# DSA

Personal DSA learning and problem practice repo with Java solutions, Python practice code, and pattern notes.

## Progress

**Problem solutions**
- Java: 67
- Python LeetCode: 19

**Build**
- Java: Maven

## Structure

```text
java/src/main/java/
  common/           Shared models - ListNode, TreeNode, Node
  problems/         LeetCode-style solutions grouped by topic
docs/problems/      Problem index and pattern revision guides
python/
  basics/           Python fundamentals and input helpers
  algorithms/       Sorting algorithm practice
  common/           Shared Python models
  datastructures/   Python data structure implementations
  leetcode/         Python LeetCode solutions grouped by topic
```

## Platform aliases

Use these short labels in file headers and notes:

| Alias | Platform |
|-------|----------|
| `LC` | LeetCode |
| `HR` | HackerRank |
| `CF` | Codeforces |
| `CC` | CodeChef |

## How to navigate

### By topic
Open any folder under `problems/` to see solutions for that topic.

### By pattern
Open `docs/problems/patterns/` for revision guides:
- `docs/problems/patterns/greedy_readme.md`
- `docs/problems/patterns/two_pointer_readme.md`
- `docs/problems/patterns/bfs_dfs_readme.md`
- `docs/problems/patterns/sliding_window_readme.md`
- `docs/problems/patterns/dynamic_programming_readme.md`

For a complete topic and tag index, open `docs/problems/README.md`.

### By tag
Use Find in Files and search for the tag string:

| Search | Returns |
|--------|---------|
| `Tags: Greedy` | greedy problems |
| `Tags: TwoPointer` | two-pointer problems |
| `Tags: BFS` | breadth-first search problems |
| `Tags: DFS` | depth-first search problems |
| `Tags: SlidingWindow` | sliding window problems |
| `Tags: Sliding Window` | sliding window problems |
| `Tags: BinarySearch` | binary search problems |
| `Tags: DynamicProgramming` | dynamic programming problems |
| `Tags: Array` | array problems |
| `Tags: LinkedList` | linked list problems |
| `Tags: Tree` | tree problems |

## Problem headers

Problem files use comment metadata like:

```java
/**
 * LC: 94
 * https://leetcode.com/problems/binary-tree-inorder-traversal
 * Example: ...
 * Approach: ...
 * Tags: Tree
 * Tags: DFS
 */
```

## Running tests

```bash
cd java
mvn clean test
```

## Adding a new problem

1. Create the file in the correct `problems/<topic>/` folder
2. Use the filename format: `{E|M|H}_{ProblemName}.java`
3. Add `LC: <number>` and the tag lines in the header comment
4. Add the matching test file under `src/test/java/problems/<topic>/`
