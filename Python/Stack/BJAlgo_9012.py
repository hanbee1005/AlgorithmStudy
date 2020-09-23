from sys import stdin

T = int(stdin.readline())

for _ in range(T):
    stack = []
    ps = stdin.readline()

    for i in range(len(ps) - 1):
        if ps[i] == '(':
            stack.append(ps[i])
        elif ps[i] == ')':
            if stack and stack[-1] == '(':
                stack.pop()
            else:
                stack.append(ps[i])

    if stack:
        print('NO')
    else:
        print('YES')