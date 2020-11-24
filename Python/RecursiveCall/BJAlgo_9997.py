# 재귀, 비트 마스크, 브루투포스 알고리즘, 깊이 우선 탐색
from sys import stdin


def dfs(count, mask):
    global result
    if count == n - 1:
        if mask == alphabet:
            result += 1
    else:
        dfs(count + 1, mask | words[count + 1])  # 단어를 추가하는 경우
        dfs(count + 1, mask)                     # 단어를 추가하지 않은 경우


alphabet = (1 << 26) - 1

result = 0

n = int(stdin.readline())
words = [0 for _ in range(n)]
for i in range(n):
    word = stdin.readline().strip()  # 각 단어를 알파벳 리스트로 받아서
    for w in word:
        words[i] |= 1 << ord(w) - 97  # 각 알파벳의 위치를 1로 만들기

dfs(-1, 0)

print(result)

