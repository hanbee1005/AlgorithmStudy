from sys import stdin


def bfs(node_list, start):
    need_visit = list()
    visited = list()

    need_visit.append(start)
    while need_visit:
        node = need_visit.pop(0)
        if node not in visited:
            visited.append(node)
            if node in node_list:
                need_visit.extend(node_list[node])

    return len(visited) - 1


n = int(stdin.readline())
v = int(stdin.readline())

nodes = dict()
for _ in range(v):
    a, b = map(int, stdin.readline().split())

    if a in nodes:
        nodes[a].append(b)
    else:
        nodes[a] = [b]

    if b in nodes:
        nodes[b].append(a)
    else:
        nodes[b] = [a]

print(bfs(nodes, 1))
