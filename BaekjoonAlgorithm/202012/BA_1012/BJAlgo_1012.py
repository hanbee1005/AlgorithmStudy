import sys
sys.setrecursionlimit(100000)  # 재귀 가능 범위 제한 해결


def dfs(now_x, now_y):
    visited[now_x][now_y] = True  # 현재 위치 방문 처리
    directions = [(-1, 0), (1, 0), (0, -1), (0, 1)]
    for dx, dy in directions:
        next_x, next_y = now_x + dx, now_y + dy  # 연결된 위치 확인
        if next_x < 0 or next_x >= n or next_y < 0 or next_y >= m:  # 밭의 범위를 벗어나는 경우 패스
            continue
        if array[next_x][next_y] and not visited[next_x][next_y]:  # 범위 내에 있으면서 배추가 심어져 있는데 방문하지 않았다면
            dfs(next_x, next_y)  # 연결된 위치 방문


t = int(sys.stdin.readline())
for _ in range(t):
    n, m, k = map(int, sys.stdin.readline().split())
    array = [[0] * m for _ in range(n)]  # 배추 위치를 표시할 배열 (배추가 있으면 1, 없으면 0)
    visited = [[False] * m for _ in range(n)]  # 방문 결과 배열 (방문한적 있으면 True, 없으면 False)
    for _ in range(k):
        x, y = map(int, sys.stdin.readline().split())
        array[x][y] = 1  # 배추가 심어진 위치 표시
    result = 0
    # 전체 밭을 모두 확인
    for i in range(n):
        for j in range(m):
            if array[i][j] and not visited[i][j]:  # 배추가 심어져 있는데 방문한 적이 없다면
                dfs(i, j)  # 연결된 지역 모두 방문하기
                result += 1

    print(result)
