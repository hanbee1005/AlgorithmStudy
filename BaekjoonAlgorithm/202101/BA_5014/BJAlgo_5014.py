from sys import stdin
import heapq


def bfs(start):
    queue = []
    heapq.heappush(queue, [0, start])

    visited = [False] * (f + 1)
    visited[start] = True

    while queue:
        cnt, current_floor = heapq.heappop(queue)

        # 현재 층과 도착 층이 같은 경우
        if current_floor == g:
            return cnt  # 지금까지 누른 버튼 수 반환

        # 위로 올라가는 경우
        next_up_floor = current_floor + u

        if 0 < next_up_floor <= f and not visited[next_up_floor]:
            heapq.heappush(queue, [cnt + 1, next_up_floor])
            visited[next_up_floor] = True

        # 아래로 내려가는 경우
        next_down_floor = current_floor - d

        if 0 < next_down_floor <= f and not visited[next_down_floor]:
            heapq.heappush(queue, [cnt + 1, next_down_floor])
            visited[next_down_floor] = True

    return -1


f, s, g, u, d = map(int, stdin.readline().split())

result = bfs(s)
if result == -1:
    print("use the stairs")
else:
    print(result)
