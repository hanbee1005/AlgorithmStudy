from sys import stdin


def find_prime_num():
    is_prime_num = [True] * (n + 1)

    for i in range(2, n + 1):
        if is_prime_num[i]:
            end = (n + 1) // i if (n + 1) % i == 0 else (n + 1) // i + 1
            for j in range(2, end):
                is_prime_num[i * j] = False
            prime_num.append(i)

    if len(prime_num) == 0:
        prime_num.append(0)


n = int(stdin.readline())

prime_num = []
find_prime_num()

print(prime_num)

low = 0
high = 0
s = prime_num[0]
result = 0

while low <= high < len(prime_num) - 1:
    if s < n:
        high += 1
        s += prime_num[high]
    elif s == n:
        result += 1
        high += 1
        s += prime_num[high]
    elif s > n:
        s -= prime_num[low]
        low += 1

if prime_num[-1] == n:
    result += 1

print(result)
