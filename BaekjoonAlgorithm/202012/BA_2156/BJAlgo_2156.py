from sys import stdin

n = int(stdin.readline())
wines = [int(stdin.readline()) for _ in range(n)]
dp = [0 for _ in range(n)]
dp[0] = wines[0]
if n > 1:
    dp[1] = wines[0] + wines[1]
if n > 2:
    dp[2] = max(dp[0] + wines[2], wines[1] + wines[2], dp[1])

for i in range(3, n):
    dp[i] = max(dp[i - 2] + wines[i], dp[i - 3] + wines[i - 1] + wines[i], dp[i - 1])

print(dp[-1])
