from sys import stdin

n = int(stdin.readline())
trophies = []
for _ in range(n):
    trophies.append(int(stdin.readline()))

left_max = 0
left = 0
for trophy in trophies:
    if left_max < trophy:
        left += 1
        left_max = trophy

right_max = 0
right = 0
for i in range(len(trophies) - 1, -1, -1):
    if right_max < trophies[i]:
        right += 1
        right_max = trophies[i]

print(left)
print(right)