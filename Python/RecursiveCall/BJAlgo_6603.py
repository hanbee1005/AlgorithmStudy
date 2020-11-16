from sys import stdin
import copy

result = list() # 하나의 케이스의 모든 경우의 수를 담을 리스트


def lotto(nums, selected):
    if len(selected) == 6:
        result.append(copy.deepcopy(selected)) # 6개의 수가 모두 선택된 경우 해당 경우를 result 리스트에 추가
        return

    for i in range(len(nums)):
        selected.append(nums[i]) # 숫자를 하나 뽑아 선택된 리스트에 추가하고
        lotto(nums[(i + 1):], selected) # 그 숫자 이후 리스트를 다시 반복
        selected.pop() # 해당 자리 수의 숫자를 빼기


while True:
    result.clear()
    inputs = list(map(int, stdin.readline().split()))

    # 입력이 0인 경우 종료
    if len(inputs) == 1 and inputs[0] == 0:
        break

    k = inputs[0]
    s = inputs[1:]

    lotto(s, [])

    for r in result:
        print(" ".join(str(n) for n in r))

    print()
