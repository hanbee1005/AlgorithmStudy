from sys import stdin


# 시간 초과 에러...
# def binary_search(a_list, num):
#     if len(a_list) == 1:
#         if a_list[0] == num:
#             return 1
#         else:
#             return 0
#
#     center_idx = len(a_list) // 2
#     left = a_list[:center_idx]
#     right = a_list[center_idx:]
#
#     if a_list[center_idx] > num:
#         return binary_search(left, num)
#     elif a_list[center_idx] <= num:
#         return binary_search(right, num)
#

N = int(stdin.readline())
A = set(map(int, stdin.readline().split()))
M = int(stdin.readline())
find = list(map(int, stdin.readline().split()))

# result = []

# A.sort()
# for item in find:
#     result.append(binary_search(A, item))
#
# print("\n".join(str(i) for i in result))

for item in find:
    if item in A:
        print(1)
    else:
        print(0)
