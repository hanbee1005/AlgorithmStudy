import sys
sys.setrecursionlimit(10000)

dx = [-1, -1, -1, 0, 0, 1, 1, 1]
dy = [-1, 0, 1, -1, 1, -1, 0, 1]


def dfs(x, y):
    visited[x][y] = True

    for d in range(8):
        nx = x + dx[d]
        ny = y + dy[d]
        if 0 <= nx < h and 0 <= ny < w:
            if island[nx][ny] == 1 and not visited[nx][ny]:
                dfs(nx, ny)


while True:
    w, h = map(int, sys.stdin.readline().split())

    if w == 0 and h == 0:
        break

    island = []
    for _ in range(h):
        island.append(list(map(int, sys.stdin.readline().split())))

    visited = [[False] * w for _ in range(h)]
    count = 0

    for i in range(h):
        for j in range(w):
            if island[i][j] == 1 and not visited[i][j]:
                dfs(i, j)
                count += 1

    print(count)
