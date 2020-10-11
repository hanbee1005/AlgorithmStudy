from sys import stdin


def qsort(data):
    if len(data) <= 1:
        return data

    pivot = data[0]
    left = [item for item in data[1:] if item < pivot]
    right = [item for item in data[1:] if item >= pivot]

    return qsort(right) + [pivot] + qsort(left)


N = stdin.readline().strip()
print(''.join(qsort(N)))


