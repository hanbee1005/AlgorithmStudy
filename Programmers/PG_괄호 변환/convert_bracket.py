# 균형잡힌 괄호 문자열인지 확인
def check_balance_string(s):
    left_bracket_cnt = 0  # '(' 의 수
    right_bracket_cnt = 0  # ')' 의 수

    divided_idx = -1  # 나누어지는 인덱스

    for i in range(len(s)):
        if s[i] == '(':
            left_bracket_cnt += 1
        else:
            right_bracket_cnt += 1

        # 왼쪽 괄호와 오른쪽 괄호의 수가 같은 경우
        if left_bracket_cnt == right_bracket_cnt:
            divided_idx = i  # 그 때 인덱스를 저장하고 종료
            break

    return divided_idx


# 올바른 괄호 문자열인지 확인
def check_correct_string(s):
    stack = []
    for ss in s:
        if ss == '(':
            stack.append(ss)
        else:
            if stack:
                stack.pop()

    # 스택에 문자가 남아있는 경우 짝이 맞지 않으므로 False 반환
    if stack:
        return False
    else:  # 스택에 문자가 남아있는 경우 짝이 맞기 때문에 True 반환
        return True


def solution(p):
    # 1. 입력이 빈 문자열인 경우, 빈 문자열을 반환합니다.
    if p == '':
        return p

    # 2. 문자열 w를 두 "균형잡힌 괄호 문자열" u, v로 분리합니다.
    divided_idx = check_balance_string(p)
    u = p[0:divided_idx + 1]
    v = '' if divided_idx + 1 >= len(p) else p[divided_idx + 1:]

    # 3. 문자열 u가 "올바른 괄호 문자열" 이라면
    if check_correct_string(u):
        # 문자열 v에 대해 1단계부터 다시 수행합니다.
        # 3-1. 수행한 결과 문자열을 u에 이어 붙인 후 반환합니다.
        answer = [u, solution(v)]
        return ''.join(answer)
    else: # 4. 문자열 u가 "올바른 괄호 문자열"이 아니라면 아래 과정을 수행합니다.
        # 4-1, 4-2, 4-3
        answer = ['(', solution(v), ')']
        # 4-4
        u = u[1:-1]
        for uu in u:
            answer.append('(') if uu == ')' else answer.append(')')
        # 4-5
        return ''.join(answer)


print(solution('(()())()'))
