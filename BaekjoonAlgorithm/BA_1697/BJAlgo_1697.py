from sys import stdin
from collections import deque

MAX = 100001
n, k = map(int, stdin.readline().split())
array = [0] * MAX  # 해당 위치(인덱스)를 방문하는데 걸린 거리


def bfs(v):
    q = deque([v])
    while q:
        now_pos = q.popleft()
        if now_pos == k:
            return array[now_pos]
        for next_pos in (now_pos - 1, now_pos + 1, now_pos * 2):
            if 0 <= next_pos < MAX and not array[next_pos]:  # 다음 위치가 범위 내에 있고 지금까지 방문한 적이 없는 경우
                array[next_pos] = array[now_pos] + 1
                q.append(next_pos)


print(bfs(n))
