from sys import stdin

N = int(stdin.readline())
data_list = list(map(int, stdin.readline().split()))

for i in range(len(data_list) - 1):
    swap = False
    for index in range(len(data_list) - i - 1):
        if data_list[index] > data_list[index + 1]:
            data_list[index], data_list[index + 1] = data_list[index + 1], data_list[index]
            swap = True

    if swap == False:
        print(i)
        break