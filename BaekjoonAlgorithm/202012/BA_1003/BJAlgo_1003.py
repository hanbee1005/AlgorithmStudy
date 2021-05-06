from sys import stdin

result = [[0, 0] for _ in range(41)]
for i in range(len(result)):
    if i == 0:
        result[i] = [1, 0]
    elif i == 1:
        result[i] = [0, 1]
    else:
        result[i] = [result[i - 1][0] + result[i - 2][0], result[i - 1][1] + result[i - 2][1]]

test_case = int(stdin.readline())
for _ in range(test_case):
    n = int(stdin.readline())
    print(result[n][0], result[n][1])
