from sys import stdin

N = int(stdin.readline())

cache = [0 for index in range(N + 1)]
cache[0] = 1
cache[1] = 1

if N > 1:
    for index in range(2, N + 1):
        cache[index] = (cache[index - 1] + cache[index - 2]) % 15746

print(cache[N])