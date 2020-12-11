from sys import stdin

t = int(stdin.readline())
for _ in range(t):
    k = int(stdin.readline())
    files = list(map(int, stdin.readline().split()))
    sums = [files[0]]
    for i in range(1, len(files)):
        sums.append(sums[i - 1] + files[i])

    dp = [[0] * k for _ in range(k)]
    for i in range(len(files) - 1):
        dp[i][i + 1] = files[i] + files[i + 1]

    for j in range(2, len(files)):  # 열
        i = 0
        while i + j < len(files):  # 행
            for k in range(i, i + j):
                sum_dist = sums[i + j] - sums[i - 1] if i != 0 else sums[i + j]
                if dp[i][i + j] == 0:
                    dp[i][i + j] = dp[i][k] + dp[k + 1][i + j] + sum_dist
                else:
                    dp[i][i + j] = min(dp[i][i + j], dp[i][k] + dp[k + 1][i + j] + sum_dist)
            i += 1

    print(dp[0][-1])
