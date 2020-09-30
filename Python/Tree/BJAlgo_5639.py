from sys import stdin
import sys
sys.setrecursionlimit(10**9)  # 재귀 허용 깊이 지정 (런타임 에러 방지)


def postorder(start, end):
    if start > end:
        return

    division = end + 1  # 나눌 위치 (root 보다 큰 처음 값 위치)
    for i in range(start + 1, end + 1):
        if post[start] < post[i]:
            division = i
            break

    postorder(start + 1, division - 1)  # 분할 왼쪽 (root 보다 작은 그룹)
    postorder(division, end)            # 분할 오른쪽 (root 보다 큰 그룹)
    print(post[start])


post = []
count = 0
while count <= 10000:
    try:
        num = int(stdin.readline())
    except:
        break

    post.append(num)
    count += 1

postorder(0, len(post) - 1)