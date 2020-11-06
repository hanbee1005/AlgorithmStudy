from sys import stdin

test_case = int(stdin.readline())

for _ in range(test_case):
    n, m = map(int, stdin.readline().split())
    queue = list(map(int, stdin.readline().split()))
    queue = [(i, idx) for idx, i in enumerate(queue)]  # [(우선 순위, 인덱스), ...] 형태의 리스트로 변환

    count = 0
    while True:
        # queue 의 가장 앞에 있는 값이 우선 순위가 최대인 값인 경우
        if queue[0][0] == max(queue, key=lambda x: x[0])[0]:
            count += 1
            # 그 값이 찾고 있는 인덱스의 값이라면
            if queue[0][1] == m:
                print(count)
                break
            else:
                queue.pop(0)  # 찾는 값이 아닌 경우 그냥 pop (프린트)
        else:
            queue.append(queue.pop(0))  # 우선 순위가 최대가 아닌 경우는 pop 하고 다시 push 하기
