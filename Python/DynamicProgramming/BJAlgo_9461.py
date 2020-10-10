from sys import stdin

T = int(stdin.readline())

for _ in range(T):
    N = int(stdin.readline())

    cache = [0 for index in range(N + 1)]
    cache[0] = 0
    cache[1] = 1

    if N >= 2:
        cache[2] = 1

    if N > 2:
        for index in range(3, N + 1):
            cache[index] = cache[index - 2] + cache[index - 3]

    print(cache[N])