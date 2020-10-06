from sys import stdin, stdout
from queue import PriorityQueue

N, K = map(int, stdin.readline().split())
inputs = list(map(int, stdin.readline().split()))


# 우선 순위 큐에 K개 원소 유지
# K개 보다 더 많은 원소가 들어오면
# 가장 작은 값 바로 poll
pq = PriorityQueue()
for i in range(len(inputs)):
    pq.put(inputs[i])

    if i >= K:
        stdout.write("{} ".format(pq.get()))

while not pq.empty():
    stdout.write("{} ".format(pq.get()))

stdout.flush()