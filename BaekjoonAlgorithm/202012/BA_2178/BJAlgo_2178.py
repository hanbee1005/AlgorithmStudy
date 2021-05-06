from sys import stdin
import heapq

dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]


def bfs(x, y):
    queue = []
    heapq.heappush(queue, [1, x, y])
    visited[x][y] = True

    while queue:
        count, cx, cy = heapq.heappop(queue)

        if cx == n - 1 and cy == m - 1:
            return count

        for i in range(4):
            nx = cx + dx[i]
            ny = cy + dy[i]
            if 0 <= nx < n and 0 <= ny < m:
                if maze[nx][ny] == 1 and not visited[nx][ny]:
                    visited[nx][ny] = True
                    heapq.heappush(queue, [count + 1, nx, ny])


n, m = map(int, stdin.readline().split())
maze = []
for _ in range(n):
    maze.append(list(map(int, stdin.readline().strip())))

visited = [[False] * m for _ in range(n)]
print(bfs(0, 0))
