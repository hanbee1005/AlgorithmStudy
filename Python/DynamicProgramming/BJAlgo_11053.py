from sys import stdin

n = int(stdin.readline())
data = list(map(int, stdin.readline().split()))
dp = [1] * n

for i in range(1, n):
    for j in range(i):
        if data[i] > data[j]:
            dp[i] = max(dp[i], dp[j] + 1)

print(max(dp))
