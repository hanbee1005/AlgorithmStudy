from sys import stdin

count = int(stdin.readline())
top = 1
stack = []
result = []

for _ in range(count):
    num = int(stdin.readline())

    while top <= num:
        stack.append(top)
        result.append('+')
        top += 1

    if stack[-1] == num:
        stack.pop()
        result.append('-')
    else:
        result = ['NO']
        break

for i in range(len(result)):
    print(result[i])