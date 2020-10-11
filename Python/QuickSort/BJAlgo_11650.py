from sys import stdin


def qsort(data):
    if len(data) <= 1:
        return data

    pivot = data[0]
    left = [item for item in data[1:] if item[0] < pivot[0] or (item[0] == pivot[0] and item[1] < pivot[1])]
    right = [item for item in data[1:] if item[0] > pivot[0] or (item[0] == pivot[0] and item[1] > pivot[1])]

    return qsort(left) + [pivot] + qsort(right)


N = int(stdin.readline())
data_list = list()
for _ in range(N):
    x, y = map(int, stdin.readline().split())
    data_list.append([x, y])

result = qsort(data_list)
for i in range(len(result)):
    print("{} {}".format(result[i][0], result[i][1]))