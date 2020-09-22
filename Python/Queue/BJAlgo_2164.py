from sys import stdin
from collections import deque

N = int(stdin.readline())
que = deque()

for i in range(1, N + 1):
    que.append(i)

while len(que) > 1:
    que.popleft()
    que.append(que.popleft())

print(que.pop())

# - 참고 -
# 시간 초과 에러
# from sys import stdin
#
# N = int(stdin.readline())
# que = []
# popNum = 0
#
# for i in range(1, N + 1):
#     que.append(i)
#
# while len(que) > 1:
#     popNum = popNum % len(que)
#     que.pop(popNum)
#     popNum += 1
#
# print(que[0])


