from sys import stdin


def dfs(x, y):
    if x == m - 1 and y == n - 1:  # 도착점에 도달한 경우
        return 1
    if visited[x][y] != -1:  # 한번 이상 방문한 적이 있는 경우
        return visited[x][y]
    visited[x][y] = 0  # 한번도 방문한 적 없는 경우 +1 해서 0으로 만들고
    for i in range(4):  # 상하좌우 위치를 순서대로 확인하며
        next_x = x + dx[i]
        next_y = y + dy[i]
        if 0 <= next_x < m and 0 <= next_y < n:  # 지도 안에 다음 위치가 존재하고
            if height[next_x][next_y] < height[x][y]:  # 현재 위치보다 이동하려는 다음 위치가 낮은 경우 (내리막길인 경우)
                visited[x][y] += dfs(next_x, next_y)  # 그 다음 위치까지 이동한 (방문한 적 있는) 경우의 수를 현재 위치에 더하기
    return visited[x][y]


m, n = map(int, stdin.readline().split())
height = []
for _ in range(m):
    height.append(list(map(int, stdin.readline().split())))

visited = [[-1] * n for _ in range(m)]

# 상하좌우 이동할 위치를 x, y 좌표 나눠서 표시
dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]

print(dfs(0, 0))
