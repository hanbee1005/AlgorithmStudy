from sys import stdin

N = int(stdin.readline())

def fibonacci(num):
    cache = [0 for index in range(num+1)]
    cache[0] = 0

    if num >= 1:
        cache[1] = 1

    if num > 1:
        for index in range(2, num + 1):
            cache[index] = cache[index - 1] + cache[index - 2]

    return cache[num]

print(fibonacci(N))