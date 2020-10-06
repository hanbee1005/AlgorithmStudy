# 가장 많이 이동한 (index 값이 변경된) 횟수 = 정렬이 완료되기까지 반복한 횟수
from sys import stdin


class Pair:
    def __init__(self, index, value):
        self.index = index
        self.value = value


N = int(stdin.readline())
data = list(map(int, stdin.readline().split()))

pq = list()

for i in range(len(data)):
    pq.append(Pair(i, data[i]))

pq.sort(key=lambda obj: obj.value)

result = 0
for i in range(len(pq)):
    tmp = pq[i]
    if result < (tmp.index - i):
        result = tmp.index - i

print(result)
