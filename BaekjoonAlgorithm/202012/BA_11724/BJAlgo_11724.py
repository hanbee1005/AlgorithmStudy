from sys import stdin


# 일반적인 DFS 수행 (연결 요소 찾기)
def dfs(start):
    queue = [start]

    while queue:
        node = queue.pop()
        if not visited[node]:
            queue.extend(graph[node])
            visited[node] = True


n, m = map(int, stdin.readline().split())
graph = [[] for _ in range(1001)]
for _ in range(m):
    u, v = map(int, stdin.readline().split())
    # 무방향 그래프이기 때문에 양쪽 정점을 모두 저장해줍니다.
    graph[u].append(v)
    graph[v].append(u)

visited = [False] * 1001
count = 0
for i in range(1, n + 1):
    if not visited[i]:  # 아직 연결되지 않은 경우
        dfs(i)  # 연결 노드 찾기 수행
        count += 1
print(count)
