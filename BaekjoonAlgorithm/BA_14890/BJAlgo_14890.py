from sys import stdin


def find_path(p):
    answer = True
    last = p[0]
    count = 1

    cnt = 1
    while cnt < n:
        if last == p[cnt]:
            count += 1
            cnt += 1
        elif p[cnt] - last == 1:
            if count < l:
                answer = False
                break

            last = p[cnt]
            count = 1
            cnt += 1
            continue
        elif last - p[cnt] == 1:
            if n - cnt >= l:
                for a in range(cnt + 1, cnt + l):
                    if p[cnt] != p[a]:
                        answer = False
                        break
                if not answer:
                    break

                cnt = cnt + l
                last = p[cnt - 1]
                count = 0
            else:
                answer = False
                break
        else:
            answer = False
            break

    return answer


n, l = map(int, stdin.readline().split())
matrix = []
for _ in range(n):
    matrix.append(list(map(int, stdin.readline().split())))

path = 0

for i in range(n):
    tmp = matrix[i]
    if find_path(tmp):
        path += 1

    tmp = []
    for j in range(n):
        tmp.append(matrix[j][i])

    if find_path(tmp):
        path += 1

print(path)
