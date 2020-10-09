from sys import stdin

N = int(stdin.readline())

def factorial(num):
    if num <= 1:
        return 1

    return num * factorial(num-1)

print(factorial(N))
