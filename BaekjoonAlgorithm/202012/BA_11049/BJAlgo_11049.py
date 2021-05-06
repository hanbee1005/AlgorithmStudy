from sys import stdin

n = int(stdin.readline())
matrix = []
for _ in range(n):
    matrix.append(list(map(int, stdin.readline().split())))

dp = [[0] * n for _ in range(n)]
for i in range(n - 1):
    dp[i][i + 1] = matrix[i][0] * matrix[i][1] * matrix[i + 1][1]


def find_add_num(start, end, mid):
    return matrix[start][0] * matrix[mid][0] * matrix[end][1]


for j in range(2, n):
    i = 0
    while i + j < n:
        for k in range(i, i + j):
            if dp[i][i + j] == 0:
                dp[i][i + j] = dp[i][k] + dp[k + 1][i + j] + find_add_num(i, i + j, k + 1)
            else:
                dp[i][i + j] = min(dp[i][i + j], dp[i][k] + dp[k + 1][i + j] + find_add_num(i, i + j, k + 1))
        i += 1

print(dp[0][n - 1])
