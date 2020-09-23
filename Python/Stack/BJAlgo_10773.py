from sys import stdin

K = int(stdin.readline())
stack = []
sum = 0

for _ in range(K):
    num = int(stdin.readline())

    if num == 0:
        stack.pop()
    else:
        stack.append(int(num))

for _ in range(len(stack)):
    sum += stack.pop()

print(sum)