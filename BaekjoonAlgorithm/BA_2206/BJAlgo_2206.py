from sys import stdin
from collections import deque

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]


def bfs():
    queue = deque()
    queue.append([0, 0, 0])  # [현 위치 x, 현 위치 y, 부수고 온 벽의 수] 를 BFS 를 수행할 큐에 저장

    # 각 위치의 방문 여부 및 지나온 벽 수를 저장하는데 [벽을 부수지 않고 방문한 경우, 벽을 부수고 방문한 경우] 형태로 저장
    visited = [[[0] * 2 for _ in range(m)] for _ in range(n)]
    visited[0][0][0] = 1

    while queue:
        cx, cy, break_count = queue.popleft()

        # 도착 지점에 도달한 경우
        if cx == n - 1 and cy == m - 1:
            return visited[cx][cy][break_count]  # 현 위치에서 벽을 부수고 방문한 경우 및 벽을 부수지 않고 방문한 경우 중 먼저 도달한 경우를 반환

        # 상하좌우 위치를 확인하면서
        for i in range(4):
            nx = cx + dx[i]
            ny = cy + dy[i]

            if 0 <= nx < n and 0 <= ny < m:  # 다음 위치가 범위 내에 존재하고
                if maze[nx][ny] == 1 and break_count == 0:  # 다음 위치가 벽인데 아직 벽을 부수고 오지 않은 경우
                    visited[nx][ny][1] = visited[cx][cy][0] + 1  # 다음 위치의 벽을 부수고 온 경우는 현 위치의 벽을 부수고 오지 않은 경우 +1 저장
                    queue.append([nx, ny, 1])  # 다음 위치 저장 및 부술 벽이 없으므로 0을 저장

                if maze[nx][ny] == 0 and visited[nx][ny][break_count] == 0:  # 다음 위치가 빈 공간이고 아직 방문하지 않은 경우
                    visited[nx][ny][break_count] = visited[cx][cy][break_count] + 1
                    queue.append([nx, ny, break_count])

    return -1


n, m = map(int, stdin.readline().split())
maze = []
for _ in range(n):
    maze.append(list(map(int, stdin.readline().strip())))

print(bfs())
