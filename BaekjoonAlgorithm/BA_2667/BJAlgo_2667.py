from sys import stdin

dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]


def dfs(cur_x, cur_y):
    visited[cur_x][cur_y] = 1
    for d in range(4):
        next_x = cur_x + dx[d]
        next_y = cur_y + dy[d]
        if 0 <= next_x < n and 0 <= next_y < n:
            if visited[next_x][next_y] == 0 and apartments[next_x][next_y] != 0:
                visited[cur_x][cur_y] += dfs(next_x, next_y)

    return visited[cur_x][cur_y]


n = int(stdin.readline())
apartments = []
for _ in range(n):
    apartments.append(list(map(int, stdin.readline().strip())))

visited = [[0] * n for _ in range(n)]
count = 0
result = []

for i in range(n):
    for j in range(n):
        if apartments[i][j] != 0 and visited[i][j] == 0:
            result.append(dfs(i, j))
            count += 1

print(count)
result.sort()
for r in result:
    print(r)
