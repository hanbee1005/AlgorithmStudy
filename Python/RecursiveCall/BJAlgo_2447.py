from sys import stdin


def star(num):
    matrix = []
    for i in range(3 * len(num)):
        # 3으로 나눈 몫이 1인 경우에만 중앙이 뚫린 형태
        if i // len(num) == 1:
            matrix.append(num[i % len(num)] + (" " * len(num)) + num[i % len(num)])
        # 나머지 경우는 처음 구조를 그대로 반복
        else:
            matrix.append(num[i % len(num)] * 3)

    return list(matrix)


N = int(stdin.readline())
stars = ["***", "* *", "***"]
k = 0

while N != 3:
    N = int(N/3)
    k += 1

for i in range(k):
    stars = star(stars)

for i in range(len(stars)):
    print(stars[i])