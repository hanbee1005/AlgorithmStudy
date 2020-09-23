from sys import stdin

count = int(stdin.readline())
stack = []

for _ in range(count):
    comm = stdin.readline().split()

    if comm[0] == 'push':
        stack.append(int(comm[1]))
    elif comm[0] == 'pop':
        if stack:
            print(stack.pop())
        else:
            print(-1)
    elif comm[0] == 'size':
        print(len(stack))
    elif comm[0] == 'empty':
        print(1 - int(bool(stack)))
    elif comm[0] == 'top':
        if stack:
            print(stack[-1])
        else:
            print(-1)