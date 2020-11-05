from sys import stdin

N, M = map(int, stdin.readline().split())
cards = list(map(int, stdin.readline().split()))

result = 0
length = len(cards)

# 모든 경우의 수는 n(n-1)(n-2) / 3 이므로, n 이 100 보다 작기 때문에 충분히 계산이 가능한 시간 복잡도를 가짐
for i in range(length):
    for j in range(i+1, length):
        for k in range(j+1, length):
            tmp = cards[i] + cards[j] + cards[k]

            if M >= tmp > result:
                result = tmp

print(result)