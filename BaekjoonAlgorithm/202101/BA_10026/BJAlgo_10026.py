from sys import stdin

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]


def dfs(x, y):
    need_visit = [[x, y]]
    visited[x][y] = True

    while need_visit:
        cx, cy = need_visit.pop()

        for k in range(4):
            nx = cx + dx[k]
            ny = cy + dy[k]

            if 0 <= nx < n and 0 <= ny < n:
                if grid[cx][cy] == grid[nx][ny] and not visited[nx][ny]:
                    need_visit.append([nx, ny])
                    visited[nx][ny] = True


def blindness_dfs(x, y):
    need_visit = [[x, y]]
    blindness_visited[x][y] = True

    while need_visit:
        cx, cy = need_visit.pop()

        for k in range(4):
            nx = cx + dx[k]
            ny = cy + dy[k]

            if 0 <= nx < n and 0 <= ny < n:
                if (grid[cx][cy] == grid[nx][ny] or (grid[cx][cy] == 'R' and grid[nx][ny] == 'G')
                    or (grid[cx][cy] == 'G' and grid[nx][ny] == 'R')) and not blindness_visited[nx][ny]:
                    need_visit.append([nx, ny])
                    blindness_visited[nx][ny] = True


n = int(stdin.readline())
grid = []
for _ in range(n):
    grid.append(stdin.readline().strip())

visited = [[False] * n for _ in range(n)]
blindness_visited = [[False] * n for _ in range(n)]
count = [0, 0]

for i in range(n):
    for j in range(n):
        if not visited[i][j]:
            dfs(i, j)
            count[0] += 1

        if not blindness_visited[i][j]:
            blindness_dfs(i, j)
            count[1] += 1

print(count[0], count[1])
