from sys import stdin

T = int(stdin.readline())

for _ in range(T):
    N = int(stdin.readline())

    cache_zero = [0 for index in range(N + 1)]
    cache_one = [0 for index in range(N + 1)]

    cache_zero[0] = 1
    cache_one[0] = 0

    if N >= 1:
        cache_zero[1] = 0
        cache_one[1] = 1

    if N > 1:
        for index in range(2, N + 1):
            cache_zero[index] = cache_zero[index - 1] + cache_zero[index - 2]
            cache_one[index] = cache_one[index - 1] + cache_one[index - 2]

    print("{} {}".format(cache_zero[N], cache_one[N]))