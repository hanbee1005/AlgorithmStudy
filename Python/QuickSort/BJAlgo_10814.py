from sys import stdin


def qsort(data):
    if len(data) <= 1:
        return data

    pivot = data[0]
    left = [item for item in data[1:] if item[0] < pivot[0]]
    right = [item for item in data[1:] if item[0] >= pivot[0]]

    return qsort(left) + [pivot] + qsort(right)


N = int(stdin.readline())
data_list = list()
for _ in range(N):
    age, name = stdin.readline().split()
    age = int(age)
    data_list.append([age, name])

result = qsort(data_list)
for i in range(len(result)):
    print("{} {}".format(result[i][0], result[i][1]))

# 이미 있는 sort 사용
# data_list.sort(key=lambda member: member[0])
# for member in data_list:
#     print(member[0], member[1])