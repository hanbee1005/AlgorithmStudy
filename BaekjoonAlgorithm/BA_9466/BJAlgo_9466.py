import sys
sys.setrecursionlimit(10**6)


def dfs(now):
    global count
    if visited[now]:  # 이미 해당 위치를 방문한 경우 검사 x
        return

    visited[now] = True  # 현재 위치를 방문한 것으로 처리
    next_student = student[now]  # 다음 위치 얻기

    if not visited[next_student]:  # 다음 위치를 방문한 적이 없는 경우
        dfs(next_student)  # 다음 위치 방문
    else:
        if not finish[next_student]:  # 이미 방문한 위치인데 다음 위치와 연결된 그래프에서 아직 사이클을 만나지 않은 경우
            # 다음 위치는 사이클에 포함된 위치이므로 count + 1
            count += 1
            tmp = next_student
            while tmp != now:  # 다음 위치가 현 위치랑 같은 때까지 반복하면서
                count += 1  # 사이클에 포함된 수를 확인하고 count + 1
                tmp = student[tmp]

    finish[now] = True  # 현재 위치와 연결된 위치를 모두 확인해 더 이상 확인할 필요 없음


t = int(sys.stdin.readline())
for _ in range(t):
    n = int(sys.stdin.readline())
    student = list(map(int, sys.stdin.readline().split()))
    student.insert(0, 0)
    visited = [False] * (n + 1)
    finish = [False] * (n + 1)
    count = 0

    for i in range(1, n + 1):
        dfs(i)

    print(n - count)
