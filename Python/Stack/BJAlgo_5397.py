# 런타임 에러...
# from sys import stdin
#
# test_case = int(stdin.readline())
#
# for _ in range(test_case):
#     L = stdin.readline().strip()
#     stack = list()
#     cursor = 0
#
#     for i in range(len(L)):
#         ch = L[i]
#
#         if ch == '-':
#             stack.pop()
#             cursor -= 1
#             if cursor < 0:
#                 cursor = 0
#         elif ch == '<':
#             cursor -= 1
#             if cursor < 0:
#                 cursor = 0
#         elif ch == '>':
#             cursor += 1
#             if cursor > len(stack):
#                 cursor = len(stack)
#         else:
#             stack.insert(cursor, ch)
#             cursor += 1
#
#     print(''.join(stack))

from sys import stdin

test_case = int(stdin.readline())

for _ in range(test_case):
    L = stdin.readline().strip()
    left = []
    right = []

    for ch in L:
        if ch == '<':
            if left:
                right.append(left.pop())
        elif ch == '>':
            if right:
                left.append(right.pop())
        elif ch == '-':
            if left:
                left.pop()
        else:
            left.append(ch)
    left.extend(reversed(right))
    print(''.join(left))
