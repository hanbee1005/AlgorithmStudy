from sys import stdin
import heapq

dx = [-1, 0, 0, 1]
dy = [0, -1, 1, 0]


def bfs(x, y):
    global time, shark_x, shark_y
    queue = []
    heapq.heappush(queue, [0, x, y])

    while queue:
        c, cx, cy = heapq.heappop(queue)

        if 0 < fish[cx][cy] < shark_weight:  # 물고기를 먹은 경우
            time += c  # 물고기 먹는데 걸린 시간 추가
            shark_x = cx  # 먹은 물고기 위치로 상어 이동 (x)
            shark_y = cy  # 먹은 물고기 위치로 상어 이동 (y)
            fish[cx][cy] = 0  # 먹은 물고기 위치 0으로 수정
            return True

        # 물고기를 못 먹은 경우 다음 물고기 위치로 이동
        for d in range(4):
            nx = cx + dx[d]
            ny = cy + dy[d]

            if 0 <= nx < n and 0 <= ny < n:  # 다음 위치가 공간 내에 있고
                if fish[nx][ny] <= shark_weight and not visited[nx][ny]:  # 물고기의 크기가 상어보다 작거나 같으면서 아직 해당 위치로 이동하지 않은 경우
                    heapq.heappush(queue, [c + 1, nx, ny])  # [해당 위치까지 이동한 시간, 다음 x 위치, 다음 y 위치] 저장
                    visited[nx][ny] = True  # 다음 위치를 방문한 것으로 처리

    return False  # 결과적으로 더이상 먹을 물고기가 없는 경우


n = int(stdin.readline())

shark_x = 0
shark_y = 0
shark_weight = 2
eat_fish = 0

fish = list()
for i in range(n):
    tmp = list(map(int, stdin.readline().split()))
    if 9 in tmp:
        shark_x = i
        shark_y = tmp.index(9)
        tmp[shark_y] = 0  # 원래 상어의 위치를 물고기가 없는 것으로 표시
    fish.append(tmp)

time = 0
while True:
    visited = [[False] * n for _ in range(n)]
    visited[shark_x][shark_y] = True

    if not bfs(shark_x, shark_y):  # 먹을 물고기가 없는 경우 종료
        break

    eat_fish += 1  # 먹은 물고기 수 증가

    if eat_fish == shark_weight:  # 먹은 물고기와 아기 상어의 무게가 같아질 때
        shark_weight += 1  # 무게를 증가시키고
        eat_fish = 0  # 먹은 물고기 수 초기화

print(time)
