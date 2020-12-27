from sys import stdin
import heapq

dx = [-2, -2, -1, -1, 1, 1, 2, 2]
dy = [-1, 1, -2, 2, -2, 2, -1, 1]


def bfs(move, x, y):
    queue = []
    heapq.heappush(queue, [move, x, y])
    visited[x][y] = 0

    while queue:
        m, cx, cy = heapq.heappop(queue)

        if cx == ex and cy == ey:
            return m

        for d in range(8):
            nx = cx + dx[d]
            ny = cy + dy[d]

            if 0 <= nx < i and 0 <= ny < i:
                if visited[nx][ny] == -1:
                    heapq.heappush(queue, [m + 1, nx, ny])
                    visited[nx][ny] = m + 1


t = int(stdin.readline())
for _ in range(t):
    i = int(stdin.readline())
    sx, sy = map(int, stdin.readline().split())
    ex, ey = map(int, stdin.readline().split())

    visited = [[-1] * i for _ in range(i)]

    print(bfs(0, sx, sy))
