from sys import stdin
from itertools import combinations
import heapq

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]


def bfs():
    queue = []
    for v in virus:
        heapq.heappush(queue, [0, v[0], v[1]])
        visited[v[0]][v[1]] = True

    while queue:
        cnt, cx, cy = heapq.heappop(queue)

        for r in range(4):
            nx = cx + dx[r]
            ny = cy + dy[r]

            if 0 <= nx < n and 0 <= ny < m:
                if labs[nx][ny] == 0 and not visited[nx][ny]:
                    heapq.heappush(queue, [cnt + 1, nx, ny])
                    visited[nx][ny] = True


n, m = map(int, stdin.readline().split())
labs = []
virus = []
combi = []

for i in range(n):
    tmp = list(map(int, stdin.readline().split()))
    for j in range(m):
        if tmp[j] == 2:
            virus.append([i, j])
        if tmp[j] == 0:
            combi.append([i, j])
    labs.append(tmp)

max_safe_area = 0

# 3개의 벽을 세울 위치를 조합으로 구하기
for cb in combinations(combi, 3):
    # 새로운 벽 3개 세우기
    for c in cb:
        labs[c[0]][c[1]] = 1

    # 바이러스 퍼트리기
    visited = [[False] * m for _ in range(n)]
    bfs()

    # 감염되지 않은 칸 수 세기
    count = 0
    for i in range(n):
        for j in range(m):
            if not visited[i][j] and labs[i][j] == 0:
                count += 1

    if count > max_safe_area:
        max_safe_area = count

    # 새로운 벽 3개 제거하기
    for c in cb:
        labs[c[0]][c[1]] = 0

print(max_safe_area)
