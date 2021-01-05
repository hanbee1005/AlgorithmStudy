from sys import stdin
from collections import deque


def bfs(start):
    queue = deque()
    queue.append(start)
    visited[start][0] = 0

    while deque:
        current = queue.popleft()

        if current == k:
            return visited[current][0]

        for np in (current * 2, current + 1, current - 1):
            if 0 <= np < 100001 and visited[np][0] == -1:
                visited[np][0] = visited[current][0] + 1
                visited[np][1] = current
                queue.append(np)


n, k = map(int, stdin.readline().split())
visited = [[-1, -1] for _ in range(100001)]  # [해당 인덱스까지 이동하는데 걸린 시간, 바로 이전에 방문했던 위치 인덱스]

print(bfs(n))

result = deque()
result.append(k)
while visited[k][1] != -1:
    result.appendleft(visited[k][1])
    k = visited[k][1]

print(" ".join(map(str, result)))
