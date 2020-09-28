from sys import stdin
N, M = map(int, stdin.readline().split())

members = {}  # 처음 들어오는 듣도 못한 사람들만 저장
result = []

for _ in range(N):
    member = stdin.readline().strip('\n')
    members[member] = member

# 보도 못한 사람들이 들어오면 바로 저장된 듣도 못한 사람들과 비교해서 중복되는 사람만 저장
for _ in range(M):
    member = stdin.readline().strip('\n')
    try:
        result.append(members[member])
    except KeyError:
        continue

# 사전 순으로 정렬하기
result = sorted(result)
print(len(result))
for i in range(len(result)):
    print(result[i])