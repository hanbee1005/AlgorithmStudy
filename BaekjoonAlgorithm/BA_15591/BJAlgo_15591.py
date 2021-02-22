import sys


def dfs(k, v):
    visited = [False] * (n + 1)
    need_visit = [[v, 1000000000]]

    while need_visit:
        cv, usado = need_visit.pop()
        if not visited[cv] and usado >= k:
            visited[cv] = True
            need_visit.extend(videos[cv])

    count = visited.count(True)
    return count - 1


n, q = map(int, sys.stdin.readline().split())
videos = dict()
for _ in range(n-1):
    a, b, r = map(int, sys.stdin.readline().split())
    if a in videos.keys():
        videos[a].append([b, r])
    else:
        videos[a] = [[b, r]]

    if b in videos.keys():
        videos[b].append([a, r])
    else:
        videos[b] = [[a, r]]

answer = []
for _ in range(q):
    k, v = map(int, sys.stdin.readline().split())
    answer.append(dfs(k, v))

print('\n'.join(map(str, answer)))
