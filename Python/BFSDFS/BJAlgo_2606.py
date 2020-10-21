from sys import stdin


def dfs(data, start_node):
    visited = list()
    stack = [start_node]

    while stack:
        node = stack.pop()

        if node not in visited:
            visited.append(node)
            if node in data:
                stack.extend(data[node])

    return len(visited) - 1 if len(visited) - 1 > 0 else 0


computers = int(stdin.readline())
networks = int(stdin.readline())
graph = dict()

for _ in range(networks):
    n, m = map(int, stdin.readline().split())

    if n in graph:
        graph[n].append(m)
    else:
        graph[n] = [m]

    if m in graph:
        graph[m].append(n)
    else:
        graph[m] = [n]

print(dfs(graph, 1))