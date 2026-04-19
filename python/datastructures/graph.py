from collections import deque


class Graph:
    def __init__(self):
        self.adj_list = {}

    def add_vertex(self, v):
        self.adj_list.setdefault(v, [])

    def add_edge(self, u, v):
        self.adj_list.setdefault(u, [])
        self.adj_list.setdefault(v, [])
        self.adj_list[u].append(v)

    def bfs(self, start):
        visited = []
        seen = {start}
        queue = deque([start])

        while queue:
            node = queue.popleft()
            visited.append(node)
            for neighbour in self.adj_list.get(node, []):
                if neighbour not in seen:
                    seen.add(neighbour)
                    queue.append(neighbour)

        return visited

    def dfs(self, start):
        visited = []
        seen = set()
        stack = [start]

        while stack:
            node = stack.pop()
            if node in seen:
                continue
            seen.add(node)
            visited.append(node)
            for neighbour in self.adj_list.get(node, []):
                if neighbour not in seen:
                    stack.append(neighbour)

        return visited

