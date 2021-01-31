from sys import stdin

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]


def dfs(cx, cy, min_r, min_c, max_r, max_c, num):
    people[num] += city[cx][cy]
    visited[cx][cy] = True

    for d in range(4):
        nx = cx + dx[d]
        ny = cy + dy[d]

        if min_r <= nx < max_r and min_c <= ny < max_c:
            if not visited[nx][ny]:
                dfs(nx, ny, min_r, min_c, max_r, max_c, num)


n = int(stdin.readline())
city = [[0 for _ in range(n + 1)]]
for _ in range(n):
    tmp = list(map(int, stdin.readline().split()))
    tmp.insert(0, 0)
    city.append(tmp)

result = 40000

for x in range(1, n):
    for y in range(1, n):
        for d1 in range(1, y):
            for d2 in range(1, n - y + 1):
                if x < x + d1 + d2 <= n and 1 <= y - d1 < y < y + d2 <= n:
                    people = [0] * 5
                    visited = [[False] * (n + 1) for _ in range(n + 1)]

                    for i in range(d1 + 1):
                        if not visited[x + i][y - i]:
                            visited[x + i][y - i] = True
                            people[4] += city[x + i][y - i]

                    for i in range(d2 + 1):
                        if not visited[x + i][y + i]:
                            visited[x + i][y + i] = True
                            people[4] += city[x + i][y + i]

                    for i in range(d2 + 1):
                        if not visited[x + d1 + i][y - d1 + i]:
                            visited[x + d1 + i][y - d1 + i] = True
                            people[4] += city[x + d1 + i][y - d1 + i]

                    for i in range(d1 + 1):
                        if not visited[x + d2 + i][y + d2 - i]:
                            visited[x + d2 + i][y + d2 - i] = True
                            people[4] += city[x + d2 + i][y + d2 - i]

                    dfs(1, 1, 1, 1, x + d1, y + 1, 0)
                    dfs(1, n, 1, y + 1, x + d2 + 1, n + 1, 1)
                    dfs(n, 1, x + d1, 1, n + 1, y - d1 + d2, 2)
                    dfs(n, n, x + d2, y - d1 + d2, n + 1, n + 1, 3)

                    for i in range(n + 1):
                        for j in range(n + 1):
                            if not visited[i][j]:
                                people[4] += city[i][j]

                    result = min(result, max(people) - min(people))

print(result)
