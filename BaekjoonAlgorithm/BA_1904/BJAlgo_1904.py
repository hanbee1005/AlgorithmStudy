from sys import stdin

n = int(stdin.readline())
result = [1 for _ in range(n + 1)]
result[1] = 1
for i in range(2, len(result)):
    result[i] = (result[i - 1] + result[i - 2]) % 15746

print(result[n])
