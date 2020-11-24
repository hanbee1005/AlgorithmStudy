from sys import stdin
import heapq

n, m = map(int, stdin.readline().split())
array = [[] for _ in range(n + 1)]  # 해당 노드와 연결된 노드 담기
indegree = [0] * (n + 1)  # 진입 차수

heap = []

for _ in range(m):
    x, y = map(int, stdin.readline().split())
    array[x].append(y)  # x -> y 관계 연결
    indegree[y] += 1  # y 로 들어오는 진입 차수 증가

for i in range(1, n + 1):
    if indegree[i] == 0:  # 진입 차수가 0인 경우 heap 에 추가
        heapq.heappush(heap, i)

result = []
while heap:
    data = heapq.heappop(heap)
    result.append(data)
    for d in array[data]:  # 꺼낸 데이터와 연결된 데이터들을 돌면서
        indegree[d] -= 1   # 진입 차수 줄이기
        if indegree[d] == 0:  # 진입 차수가 0인 경우 heap 에 추가
            heapq.heappush(heap, d)

for i in result:
    print(i, end=" ")
