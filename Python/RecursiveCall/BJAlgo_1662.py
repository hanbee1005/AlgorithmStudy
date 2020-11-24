# 스택, 재귀
from sys import stdin

s = stdin.readline().strip()
stack = list()

for i in range(len(s)):
    if s[i] == "(":
        stack.append("(")
    elif s[i] == ")":  # 닫는 괄호가 들어오면
        cnt = 0
        while True:
            tmp = stack.pop()  # 다시 앞으로 돌아가면서
            if tmp == "(":     # 여는 괄호를 만날 때까지 반복
                break
            cnt += tmp         # () 사이에 저장된 문자열의 수를 더하기
        stack.append(int(stack.pop()) * cnt)  # "( 앞에 있는 반복 횟수 * () 사이 문자열의 크기" 를 구해서 다시 저장하기
    elif i < len(s) - 1 and s[i + 1] == "(":  # 숫자, ( 조합이 들어온 경우
        stack.append(int(s[i]))  # 숫자 그대로 반복 숫자로 추가
    else:  # 숫자, 숫자 조합이 들어온 경우
        stack.append(1)  # 숫자의 크기는 문자열 1개이므로 1을 저장

# 총 문자열의 길이 구하기
answer = 0
for st in stack:
    answer += st
print(answer)
