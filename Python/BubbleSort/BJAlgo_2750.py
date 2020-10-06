from sys import stdin

N = int(stdin.readline())
bs = list()
for _ in range(N):
    num = int(stdin.readline())
    bs.append(num)

for i in range(len(bs) - 1):
    swap = False
    for index in range(len(bs) - i - 1):
        if bs[index] > bs[index+1]:
            bs[index], bs[index+1] = bs[index+1], bs[index]
            swap = True

    if swap == False:
        break

for i in range(len(bs)):
    print(bs[i])