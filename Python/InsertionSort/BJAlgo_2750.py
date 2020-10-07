from sys import stdin

N = int(stdin.readline())
data_list = list()
for _ in range(N):
    data_list.append(int(stdin.readline()))

for stand in range(len(data_list) - 1):
    for num in range(stand + 1, 0, -1):
        if data_list[num] < data_list[num - 1]:
            data_list[num], data_list[num - 1] = data_list[num - 1], data_list[num]
        else:
            break

for i in range(len(data_list)):
    print(data_list[i])