from sys import stdin

heap = list()
heap.append(None)

N = int(stdin.readline())
for i in range(2, N+1):
    heap.append(i)

    idx = len(heap) - 1
    while True:
        if idx <= 1:
            break

        parent_idx = idx // 2
        if heap[idx] > heap[parent_idx]:
            heap[idx], heap[parent_idx] = heap[parent_idx], heap[idx]
            idx = parent_idx
        else:
            break

heap.append(1)
for i in range(1, len(heap)):
    print(heap[i], end=' ')