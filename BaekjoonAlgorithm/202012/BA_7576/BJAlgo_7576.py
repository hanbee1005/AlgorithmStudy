from sys import stdin
import heapq

dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]


def bfs():
    total_day = 0

    queue = []
    # 초기 익은 토마토 확인
    for i in range(n):
        for j in range(m):
            if tomato[i][j] == 1:  # 이미 익은 토마토가 주어진 경우
                heapq.heappush(queue, [0, i, j])  # [익는데 걸리는 일수, 토마토 위치 x, 토마토 위치 y] 데이터를 우선순위 큐에 저장

    while queue:
        day, x, y = heapq.heappop(queue)  # 익는데 걸리는 일수가 적은 토마토부터 순차적으로 확인
        for d in range(4):
            nx = x + dx[d]
            ny = y + dy[d]
            if 0 <= nx < n and 0 <= ny < m:  # 주변(상하좌우) 토마토의 위치가 상자 범위 내에 있고
                if tomato[nx][ny] == 0:  # 아직 토마토가 익지 않은 경우
                    tomato[nx][ny] = 1  # 토마토가 익은 것으로 처리하고
                    heapq.heappush(queue, [day + 1, nx, ny])  # 해당(다음) 토마토를 [현재 토마토가 익는데 걸리는 일수 + 1, 토마토 위치 x, 토마토 위치 y] 데이터를 우선순위 큐에 저장
                    total_day = max(total_day, day + 1)  # 지금까지 토마토가 익는데 걸린 시간과 확인된 토마토가 익는데 걸리는 일수 중 더 큰 값을 저장

    # 최종적으로 익지 않은 토마토가 있는지 확인
    for i in range(n):
        for j in range(m):
            if tomato[i][j] == 0:
                return -1

    return total_day


m, n = map(int, stdin.readline().split())
tomato = []
for _ in range(n):
    tomato.append(list(map(int, stdin.readline().split())))

print(bfs())
