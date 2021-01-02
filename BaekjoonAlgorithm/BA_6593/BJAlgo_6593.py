from sys import stdin
import heapq

dx = [-1, 1, 0, 0, 0, 0]
dy = [0, 0, -1, 1, 0, 0]
dz = [0, 0, 0, 0, -1, 1]


def bfs(z, x, y):
    queue = []
    heapq.heappush(queue, [0, z, x, y])

    visited = [[[False for _ in range(c)] for _ in range(r)] for _ in range(l)]
    visited[z][x][y] = True

    while queue:
        cnt, cz, cx, cy = heapq.heappop(queue)

        if cz == ez and cx == ex and cy == ey:
            return cnt

        for d in range(6):
            nz = cz + dz[d]
            nx = cx + dx[d]
            ny = cy + dy[d]

            if 0 <= nz < l and 0 <= nx < r and 0 <= ny < c:
                if building[nz][nx][ny] != '#' and not visited[nz][nx][ny]:
                    heapq.heappush(queue, [cnt + 1, nz, nx, ny])
                    visited[nz][nx][ny] = True

    return 0


while True:
    l, r, c = map(int, stdin.readline().split())

    if l == r == c == 0:
        break

    sx = 0
    sy = 0
    sz = 0

    ex = 0
    ey = 0
    ez = 0

    building = [[] * r for _ in range(l)]
    for i in range(l):
        for j in range(r):
            tmp = list(map(str, stdin.readline().strip()))
            if 'S' in tmp:
                sz = i
                sx = j
                sy = tmp.index('S')
            elif 'E' in tmp:
                ez = i
                ex = j
                ey = tmp.index('E')
            building[i].append(tmp)
        stdin.readline()

    result = bfs(sz, sx, sy)
    if result == 0:
        print("Trapped!")
    else:
        print("Escaped in", result, "minute(s).")
