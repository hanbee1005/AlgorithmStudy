from sys import stdin

stringA = stdin.readline().strip()
stringB = stdin.readline().strip()

result = [[0] * (len(stringA) + 1) for _ in range(len(stringB) + 1)]
for i in range(1, len(result)):
    for j in range(1, len(result[i])):
        if stringB[i - 1] != stringA[j - 1]:
            result[i][j] = max(result[i - 1][j], result[i][j - 1])
        else:
            result[i][j] = result[i - 1][j - 1] + 1

print(result[-1][-1])
