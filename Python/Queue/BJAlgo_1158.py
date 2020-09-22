from sys import stdin

N, K = map(int, stdin.readline().split())
memberList = []
result = []
popNum = 0

for i in range(1, (N + 1)):
    memberList.append(i)

while bool(memberList):
    popNum = (popNum + (K - 1)) % len(memberList)
    popElement = memberList.pop(popNum)
    result.append(str(popElement))

print("<{}>".format(", ".join(result)))  # "".join(리스트) 은 list => str 으로 전환하며 사이에 어떤 문자를 넣을지 지정할 수 있음

# - 참고 -
# 시간 초과 났던 기존 코드
# from sys import stdin
#
# N, K = map(int, stdin.readline().split())
# memberList = []
# result = []
# count = 0
#
# for i in range(1, (N + 1)):
#     memberList.append(i)
#
# while bool(memberList):
#     data = memberList[0]
#     del memberList[0]
#
#     if count == (K - 1):
#         count = 0
#         result.append(str(data))
#     else:
#         count += 1
#         memberList.append(data)
#
# print("<{}>".format(", ".join(result)))
