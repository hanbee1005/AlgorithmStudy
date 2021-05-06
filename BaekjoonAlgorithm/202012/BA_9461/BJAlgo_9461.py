from sys import stdin

result = [1 for _ in range(101)]
for i in range(4, len(result)):
    result[i] = result[i - 2] + result[i - 3]

t = int(stdin.readline())
for _ in range(t):
    n = int(stdin.readline())
    print(result[n])
