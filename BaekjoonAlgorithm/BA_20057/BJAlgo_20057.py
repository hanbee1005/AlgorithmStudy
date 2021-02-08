from sys import stdin

dx = [0, 1, 0, -1]
dy = [-1, 0, 1, 0]

# 왼쪽으로 갈 때 위치와 비율
l_rate = [
    [-2, 0, 0.02], [2, 0, 0.02],
    [-1, -1, 0.1], [-1, 0, 0.07], [-1, 1, 0.01], [1, -1, 0.1], [1, 0, 0.07], [1, 1, 0.01],
    [0, -2, 0.05], [0, -1, 0]
]

# 아래로 갈 때 위치와 비율
d_rare = [
    [0, -2, 0.02], [0, 2, 0.02],
    [1, -1, 0.1], [0, -1, 0.07], [-1, -1, 0.01], [1, 1, 0.1], [0, 1, 0.07], [-1, 1, 0.01],
    [2, 0, 0.05], [1, 0, 0]
]

# 오른쪽으로 갈 때 위치와 비율
r_rate = [
    [-2, 0, 0.02], [2, 0, 0.02],
    [-1, -1, 0.01], [-1, 0, 0.07], [-1, 1, 0.1], [1, -1, 0.01], [1, 0, 0.07], [1, 1, 0.1],
    [0, 2, 0.05], [0, 1, 0]
]

# 위로 갈 때 위치와 비율
u_rate = [
    [0, -2, 0.02], [0, 2, 0.02],
    [-1, -1, 0.1], [0, -1, 0.07], [1, -1, 0.01], [-1, 1, 0.1], [0, 1, 0.07], [1, 1, 0.01],
    [-2, 0, 0.05], [-1, 0, 0]
]

# 원하는 방향으로 cnt 만큼 반복하여 이동
def move(cnt, idx, t):
    global sx, sy
    for _ in range(cnt + 1):
        sx += dx[idx]
        sy += dy[idx]

        # (0, 0) 지점에 도달하는 경우 종료
        if sx < 0 or sy < 0:
            break

        tornado(t)


# 이동 후 모래 날리기
def tornado(t):
    global result
    remove_sand = 0  # 비율에 따라 날아간 먼지의 합

    if t == 'l':
        rate = l_rate
    elif t == 'r':
        rate = r_rate
    elif t == 'd':
        rate = d_rare
    elif t == 'u':
        rate = u_rate

    for x, y, r in rate:
        # 먼지가 날아가는 위치 구하기
        nx = sx + x
        ny = sy + y

        if r == 0:  # 알파 구역에 날린 먼지 구하기
            s = sand[sx][sy] - remove_sand
        else:  # 비율에 따라 날린 먼지 구하기
            s = int(sand[sx][sy] * r)

        # 모래밭 범위 내로 먼지가 날린 경우
        if 0 <= nx < n and 0 <= ny < n:
            sand[nx][ny] += s  # 기존 위치의 먼지 + 날아온 먼지
        else:
            result += s  # 범위 밖으로 나간 먼지는 최종 값에 추가

        remove_sand += s  # 날린 먼지의 합구하기


n = int(stdin.readline())
sand = []
for _ in range(n):
    sand.append(list(map(int, stdin.readline().split())))

sx = n // 2
sy = n // 2

result = 0

for i in range(n):
    if i % 2 == 0:
        move(i, 0, 'l')
        move(i, 1, 'd')
    else:
        move(i, 2, 'r')
        move(i, 3, 'u')

print(result)
