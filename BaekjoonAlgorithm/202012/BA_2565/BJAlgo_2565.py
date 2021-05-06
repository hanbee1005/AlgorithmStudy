from sys import stdin

n = int(stdin.readline())
pos = []
for _ in range(n):
    a, b = map(int, stdin.readline().split())
    pos.append([a, b])
pos.sort()

result = [1 for _ in range(n)]
for i in range(1, n):
    for j in range(i):
        if pos[i][1] > pos[j][1]:
            result[i] = max(result[i], result[j] + 1)

print(n - max(result))
