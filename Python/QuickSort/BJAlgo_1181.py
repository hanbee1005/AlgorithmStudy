from sys import stdin


def qsort(data):
    if len(data) <= 1:
        return data

    pivot = data[0]
    left = [item for item in data[1:] if len(item) < len(pivot) or (len(item) == len(pivot) and item < pivot)]
    right = [item for item in data[1:] if len(item) > len(pivot) or (len(item) == len(pivot) and item > pivot)]

    return qsort(left) + [pivot] + qsort(right)


N = int(stdin.readline())
data_list = [stdin.readline().strip() for _ in range(N)]

result = qsort(data_list)
for i in range(len(result)):
    print(result[i])