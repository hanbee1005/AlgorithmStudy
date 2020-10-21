from sys import stdin


def bfs(data, start_node):
    visited = list()
    need_visit = [start_node]

    while need_visit:
        node = need_visit.pop(0)

        if node not in visited:
            visited.append(node)
            if node in data:
                need_visit.extend(sorted(data[node]))

    return visited


def dfs(data, start_node):
    visited = list()
    need_visit = [start_node]

    while need_visit:
        node = need_visit.pop()

        if node not in visited:
            visited.append(node)
            if node in data:
                need_visit.extend(sorted(data[node], reverse=True))

    return visited


N, M, V = map(int, stdin.readline().split())
graph = dict()

for _ in range(M):
    n, m = map(int, stdin.readline().split())

    if n in graph:
        graph[n].append(m)
    else:
        graph[n] = [m]

    if m in graph:
        graph[m].append(n)
    else:
        graph[m] = [n]

print(" ".join(map(str, dfs(graph, V))))
print(" ".join(map(str, bfs(graph, V))))