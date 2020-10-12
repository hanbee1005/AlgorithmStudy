from sys import stdin


def merge(left, right):
    merged = list()
    left_index, right_index = 0, 0

    # Case 1: left, right 둘 다 남은 경우
    while left_index < len(left) and right_index < len(right):
        if left[left_index] < right[right_index]:
            merged.append(left[left_index])
            left_index += 1
        else:
            merged.append(right[right_index])
            right_index += 1

    # Case 2: left 만 남은 경우
    if left_index < len(left):
        merged += left[left_index:]

    # Case 3: right 만 남은 경우
    if right_index < len(right):
        merged += right[right_index:]

    return merged


def split(data):
    if len(data) <= 1:
        return data

    medium = int(len(data) / 2)
    left = split(data[:medium])
    right = split(data[medium:])

    return merge(left, right)


N = int(stdin.readline())
data_list = [int(stdin.readline()) for _ in range(N)]
result = split(data_list)
for i in range(len(result)):
    print(result[i])

# 이미 구현된 sort() 메소드 사용
# data_list.sort()
# for i in range(len(data_list)):
#     print(data_list[i])