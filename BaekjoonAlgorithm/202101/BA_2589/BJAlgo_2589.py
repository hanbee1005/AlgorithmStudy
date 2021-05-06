from sys import stdin
from collections import deque

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]


def bfs(x, y):
    count = [[-1] * m for _ in range(n)]
    queue.append([x, y])
    count[x][y] = 0
    num = 0

    while queue:
        cx, cy = queue.popleft()

        for d in range(4):
            nx = cx + dx[d]
            ny = cy + dy[d]

            if 0 <= nx < n and 0 <= ny < m:
                if island[nx][ny] == 'L' and count[nx][ny] == -1:
                    count[nx][ny] = count[cx][cy] + 1
                    num = max(num, count[nx][ny])
                    queue.append([nx, ny])

    return num


n, m = map(int, stdin.readline().split())
island = [stdin.readline().strip() for _ in range(n)]
queue = deque()

time = 0

for i in range(n):
    for j in range(m):
        if island[i][j] == 'L':
            time = max(time, bfs(i, j))

print(time)
