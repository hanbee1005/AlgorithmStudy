from sys import stdin

birds = int(stdin.readline())

num = 1
time = 0
while birds != 0:
    if num > birds:
        num = 1

    birds -= num
    time += 1
    num += 1

print(time)
