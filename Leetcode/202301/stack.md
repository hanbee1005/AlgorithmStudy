# Stack

### 20. Valid Parentheses
`(, ), {, }, [, ]`로 이루어진 문자열이 주어졌을 때 괄호의 짝이 모두 맞는지 확인하는 문제
[문제풀이코드](https://github.com/hanbee1005/AlgorithmStudy/blob/master/Leetcode/202301/ValidParentheses_20.java)
- stack을 생성해서 문자열의 각 문자를 순환하면서 stack이 비어 있는 경우는 현재 문자를 push 하고
- stack에 담긴 top 문자가 `(, {, [`에 속하고 현재 문자와 짝이 맞는 경우는 pop 을 합니다.
- 위 경우가 아니면 현재 문자를 다시 push 하고
- 최종적으로 stack이 비어있지 않으면 짝이 맞지 않았기 때문이므로 false, 비어 있으면 true를 반환하도록 구현하였습니다.