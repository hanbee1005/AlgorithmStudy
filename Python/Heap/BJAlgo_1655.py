# 주어진 수들은 번갈아 가며 max_heap, min_heap 에 담는다.
# max_heap 의 최대 값은 min_heap 의 최소 값보다 작거나 같다.
# 즉, max_heap 의 최대 값은 전체 수의 중간 값
from sys import stdin
from queue import PriorityQueue

N = int(stdin.readline())
max_heap = PriorityQueue()
min_heap = PriorityQueue()

for _ in range(N):
    num = int(stdin.readline())
    if max_heap.qsize() == min_heap.qsize():
        max_heap.put(-num)
    else:
        min_heap.put(num)

    if max_heap.qsize() > 0 and min_heap.qsize() > 0:
        m = -max_heap.get()
        n = min_heap.get()

        if m > n:
            max_heap.put(-n)
            min_heap.put(m)
        else:
            max_heap.put(-m)
            min_heap.put(n)

    mid = max_heap.get()
    print(-mid)
    max_heap.put(mid)
