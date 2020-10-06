from sys import stdin

N, K = map(int, stdin.readline().split())
data = list(map(int, stdin.readline().split()))

for i in range(K):
    swap = False
    for index in range(len(data) - i - 1):
        if data[index] > data[index+1]:
            data[index], data[index+1] = data[index+1], data[index]
            swap = True

    if swap == False:
        break

for i in range(len(data)):
    print(data[i], end=" ")