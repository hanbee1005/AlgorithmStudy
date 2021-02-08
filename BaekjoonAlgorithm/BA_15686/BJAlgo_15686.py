from sys import stdin
from itertools import combinations


def find_min_dist(chicken):
    min_dist = 0
    for hx, hy in home:
        min_dist_per_home = 101
        for cx, cy in chicken:
            dist = abs(hx - cx) + abs(hy - cy)
            min_dist_per_home = min(min_dist_per_home, dist)
        min_dist += min_dist_per_home

    return min_dist


n, m = map(int, stdin.readline().split())
city = []
home = []
chickens = []
for i in range(n):
    tmp = list(map(int, stdin.readline().split()))
    for j in range(n):
        if tmp[j] == 1:
            home.append([i, j])
        elif tmp[j] == 2:
            chickens.append([i, j])

    city.append(tmp)

result = -1

for combi in combinations(chickens, m):
    result = find_min_dist(combi) if result == -1 else min(result, find_min_dist(combi))

print(result)
