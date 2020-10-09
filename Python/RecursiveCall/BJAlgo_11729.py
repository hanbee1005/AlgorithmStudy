from sys import stdin

N = int(stdin.readline())
result = list()

def hanoi(num, from_post, to_post, middle_post):
    if num == 1:
        result.append('{} {}'.format(from_post, to_post))
        return

    hanoi(num-1, from_post, middle_post, to_post)
    result.append('{} {}'.format(from_post, to_post))
    hanoi(num-1, middle_post, to_post, from_post)

hanoi(N, 1, 3, 2)

print(len(result))
for i in range(len(result)):
    print(result[i])