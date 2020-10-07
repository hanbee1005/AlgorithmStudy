from sys import stdin

N = int(stdin.readline())
data_list = list()
for _ in range(N):
    data_list.append(int(stdin.readline()))

for stand in range(len(data_list) - 1):
    lowest = stand
    for num in range(stand + 1, len(data_list)):
        if data_list[lowest] > data_list[num]:
            lowest = num
    data_list[stand], data_list[lowest] = data_list[lowest], data_list[stand]

for i in range(len(data_list)):
    print(data_list[i])