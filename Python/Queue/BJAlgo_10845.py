from sys import stdin
que = []

for _ in range(int(stdin.readline())):
    comm = stdin.readline().split()

    if comm[0] == 'push':
        que.append(int(comm[1]))
    elif comm[0] == 'pop':
        if que:
            print(que.pop(0))
        else:
            print(-1)
    elif comm[0] == 'size':
        print(len(que))
    elif comm[0] == 'empty':
        print(1-int(bool(que)))
    elif comm[0] == 'front':
        if que:
            print(que[0])
        else:
            print(-1)
    elif comm[0] == 'back':
        if que:
            print(que[-1])
        else:
            print(-1)