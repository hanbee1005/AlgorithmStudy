from sys import stdin
que = []

# input() 대신 stdin.readline()을 사용하는 것이 빠름
for _ in range(int(stdin.readline())):
    comm = stdin.readline().split()

    if comm[0] == 'push':
        que.append(int(comm[1]))
    elif comm[0] == 'pop':
        if que:
            print(que.pop(0))  # pop(index)를 하면 값을 뽑고 지우기
        else:
            print(-1)
    elif comm[0] == 'size':
        print(len(que))
    elif comm[0] == 'empty':
        print(1-int(bool(que)))  # bool(조건)에 따라 true/false 반환
    elif comm[0] == 'front':
        if que:
            print(que[0])
        else:
            print(-1)
    elif comm[0] == 'back':
        if que:
            print(que[-1])  # list의 마지막 요소
        else:
            print(-1)