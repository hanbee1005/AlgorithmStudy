from sys import stdin

n, m = map(int, stdin.readline().split())
castle = [list(stdin.readline().strip()) for _ in range(n)]

x = [i for i in range(n)]
y = [i for i in range(m)]

for i in range(n):
    for j in range(m):
        if castle[i][j] == "X":
            if i in x:
                x.remove(i)
            if j in y:
                y.remove(j)

print(max(len(x), len(y)))
