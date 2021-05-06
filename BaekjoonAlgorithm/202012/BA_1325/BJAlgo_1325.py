from sys import stdin
from collections import deque


def bfs(v):
    q = deque([v])
    visited = [False] * (n + 1)
    visited[v] = True
    count = 1
    while q:
        v = q.popleft()
        for e in adj[v]:
            if not visited[e]:
                q.append(e)
                visited[e] = True
                count += 1

    return count


n, m = map(int, stdin.readline().split())
adj = [[] for _ in range(n + 1)]

for _ in range(m):
    a, b = map(int, stdin.readline().split())
    adj[b].append(a)

result = []
max_value = -1

for i in range(1, n + 1):
    c = bfs(i)
    if c > max_value:
        max_value = c
        result = [i]
    elif c == max_value:
        result.append(i)

for r in result:
    print(r, end=" ")
