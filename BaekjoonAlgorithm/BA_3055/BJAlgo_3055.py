from sys import stdin
import heapq

xx = [-1, 1, 0, 0]
yy = [0, 0, -1, 1]


def bfs():
    queue = []
    w_visited = [[False] * c for _ in range(r)]  # 물이 이동하는 위치
    visited = [[False] * c for _ in range(r)]

    for wx, wy in water:
        heapq.heappush(queue, [0, '*', wx, wy])
        w_visited[wx][wy] = True
    heapq.heappush(queue, [0, 'S', sx, sy])
    visited[sx][sy] = True

    while queue:
        cnt, t, cx, cy = heapq.heappop(queue)

        # 현재 위치가 도착 위치와 같은 경우
        if t == 'D':
            return cnt  # 현재 위치까지 오는데 걸린 시간 반환

        for d in range(4):
            nx = cx + xx[d]
            ny = cy + yy[d]

            if 0 <= nx < r and 0 <= ny < c:
                # 현재 위치가 물인 경우
                if t == '*':
                    # 다음 위치가 돌이 아니거나 도착 지점이 아니면서 아직 물이 차지 않은 경우
                    if (forest[nx][ny] != 'X' and forest[nx][ny] != 'D') and not w_visited[nx][ny]:
                        heapq.heappush(queue, [cnt + 1, '*', nx, ny])  # [물이 차는데 걸리는 시간, 물 표시, 다음 위치 x, 다음 위치 y] 데이터 저장
                        w_visited[nx][ny] = True  # 다음 위치에 물이 찼다는 것을 표시
                else:
                    # 다음 위치가 돌이 아니면서 물이 차지 않은 공간이고 아직 고슴도치가 이동하지 않은 공간인 경우
                    if (forest[nx][ny] != 'X' and not w_visited[nx][ny]) and not visited[nx][ny]:
                        heapq.heappush(queue, [cnt + 1, forest[nx][ny], nx, ny])
                        visited[nx][ny] = True

    return -1


r, c = map(int, stdin.readline().split())
sx = 0
sy = 0
dx = 0
dy = 0

forest = []
water = []
for i in range(r):
    tmp = list(stdin.readline().strip())
    if 'S' in tmp:
        sx = i
        sy = tmp.index('S')

    if 'D' in tmp:
        dx = i
        dy = tmp.index('D')

    if '*' in tmp:
        water.append([i, tmp.index('*')])
    forest.append(tmp)

result = bfs()
if result == -1:
    print("KAKTUS")
else:
    print(result)
