from sys import stdin

length = int(stdin.readline())
chars = stdin.readline()
sum = 0

MOD = 1234567891
MULTIPLY = 31

R = 1

for i in range(length):
    char = chars[i]
    sum = (sum + (ord(char) - 96) * R) % MOD

    R = (R*MULTIPLY) % MOD

print(sum)