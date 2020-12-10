from sys import stdin
import heapq


def dijkstra(comp, start):
    time = [float('inf')] * len(comp)
    time[start] = 0

    queue = []
    heapq.heappush(queue, [0, start])

    while queue:
        current_time, current_node = heapq.heappop(queue)

        if current_time > time[current_node]:
            continue

        for adj, t in comp[current_node]:
            dist = current_time + t
            if dist < time[adj]:
                time[adj] = dist
                heapq.heappush(queue, [dist, adj])

    return time


test_case = int(stdin.readline())
for _ in range(test_case):
    n, d, c = map(int, stdin.readline().split())
    computers = [[] for _ in range(n + 1)]
    for _ in range(d):
        a, b, s = map(int, stdin.readline().split())
        computers[b].append([a, s])
    result = dijkstra(computers, c)
    count = 0
    max_time = -1
    for r in result:
        if r != float('inf'):
            count += 1
            if max_time < r:
                max_time = r

    print(count, max_time)
