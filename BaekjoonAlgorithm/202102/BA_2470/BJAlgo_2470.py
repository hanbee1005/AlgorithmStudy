from sys import stdin

n = int(stdin.readline())
nums = list(map(int, stdin.readline().split()))
nums.sort()

low = 0
high = len(nums) - 1

result = [nums[0], nums[-1]]
s = abs(nums[0] + nums[-1])
while low < high:
    tmp = nums[low] + nums[high]
    if s > abs(tmp):
        s = abs(tmp)
        result[0] = nums[low]
        result[1] = nums[high]

    if tmp >= 0:
        high -= 1
    else:
        low += 1

print(result[0], result[-1])
