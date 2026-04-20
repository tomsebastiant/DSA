# DSA - Java

Personal DSA learning and problem practice repo.

## Progress

**Total problems solved**
Java: 50
Python: 19
Build: Maven

## Structure

```text
java/src/main/java/
  basics/           Java fundamentals - arrays, strings, input
  common/           Shared models - ListNode, TreeNode, Node
  algorithms/       Sorting algorithms with complexity notes
  datastructures/   DS implementations - LinkedList, BinaryTree, Graph, HashMap
  problems/         Solutions grouped by topic with searchable headers
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

### By tag
Use Find in Files and search for the tag string:

| Search | Returns |
|--------|---------|
| `Tags: Greedy` | greedy problems |
| `Tags: TwoPointer` | two-pointer problems |
| `Tags: BFS` | breadth-first search problems |
| `Tags: DFS` | depth-first search problems |
| `Tags: Array` | array problems |
| `Tags: LinkedList` | linked list problems |
| `Tags: Tree` | tree problems |

## Problem headers

Problem files use comment metadata like:

```java
/**
 * LC: 94
 * https://leetcode.com/problems/binary-tree-inorder-traversal
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
