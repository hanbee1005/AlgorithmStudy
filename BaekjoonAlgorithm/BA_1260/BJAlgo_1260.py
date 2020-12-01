from sys import stdin


def dfs(node_list, start_node):
    need_visit = list()
    visited = list()

    need_visit.append(start_node)

    while need_visit:
        node = need_visit.pop()
        if node not in visited:
            visited.append(node)
            if node in node_list:
                need_visit.extend(sorted(node_list[node], reverse=True))

    return visited


def bfs(node_list, start_node):
    need_visit = list()
    visited = list()

    need_visit.append(start_node)

    while need_visit:
        node = need_visit.pop(0)
        if node not in visited:
            visited.append(node)
            if node in node_list:
                need_visit.extend(sorted(node_list[node]))

    return visited


n, m, v = map(int, stdin.readline().split())
nodes = dict()

for _ in range(m):
    n1, n2 = map(int, stdin.readline().split())
    if n1 in nodes:
        nodes[n1].append(n2)
    else:
        nodes[n1] = [n2]

    if n2 in nodes:
        nodes[n2].append(n1)
    else:
        nodes[n2] = [n1]

result = " ".join(map(str, dfs(nodes, v)))
result += "\n"
result += " ".join(map(str, bfs(nodes, v)))

print(result)
