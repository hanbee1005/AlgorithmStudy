from sys import stdin

# inputs = list(map(int, stdin.readline().split()))
# asc = sorted(inputs)
#
# if inputs == asc:
#     print('ascending')
# else:
#     desc = sorted(inputs, reverse=True)
#     if inputs == desc:
#         print('descending')
#     else:
#         print('mixed')


# fastcampus 문제 풀이
inputs = list(map(int, stdin.readline().split()))

ascending = True
descending = True

for i in range(1, 8):
    if inputs[i] > inputs[i - 1]:
        descending = False
    elif inputs[i] < inputs[i - 1]:
        ascending = False

if ascending:
    print('ascending')
elif descending:
    print('descending')
else:
    print('mixed')