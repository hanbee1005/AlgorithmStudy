from sys import stdin

N = int(stdin.readline())
result = 0

# 들어간 차량 순서대로 저장 {'차량번호': 입장순서}
cars = {}
for i in range(N):
    car = stdin.readline().strip('\n')
    cars[car] = i

for i in range(N):
    car = stdin.readline().strip('\n')
    num = cars[car]  # 들어온 차량 찾아서
    del cars[car]    # dictionary 에서 삭제 후
    for val in cars.values():  # 남은 차량의 입장 순서를 확인해
        if num > val:          # 현재 차량보다 빨리 들어온 차가 있는 경우 result + 1
            result += 1
            break

print(result)