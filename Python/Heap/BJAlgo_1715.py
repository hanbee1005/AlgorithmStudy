from sys import stdin
import heapq

heap = []
n = int(stdin.readline())
for _ in range(n):
    bundle = int(stdin.readline())
    heapq.heappush(heap, bundle)

result = 0

while len(heap) > 1:
    min1 = heapq.heappop(heap)
    min2 = heapq.heappop(heap)
    result += min1 + min2
    heapq.heappush(heap, min1 + min2)

print(result)
