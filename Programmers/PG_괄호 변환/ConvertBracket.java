import java.util.Stack;

public class ConvertBracket {
    public static void main(String[] args) {
        String answer = solution(")(");
        System.out.println(answer);
    }

    private static String solution(String p) {
        // 1. 입력이 빈 문자열인 경우, 빈 문자열을 반환합니다.
        if ("".equals(p)) {
            return "";
        }

        // 2. 문자열 w를 두 "균형잡힌 괄호 문자열" u, v로 분리합니다.
        int divideIdx = checkBalancedString(p);

        StringBuilder u = new StringBuilder();
        u.append(p, 0, divideIdx + 1);

        StringBuilder v = new StringBuilder();
        if (divideIdx + 1 != p.length()) {
            v.append(p.substring(divideIdx + 1));
        }

        // 3. 문자열 u가 "올바른 괄호 문자열" 이라면 문자열 v에 대해 1단계부터 다시 수행합니다.
        if (checkCorrectString(u.toString())) {
            // 3-1. 수행한 결과 문자열을 u에 이어 붙인 후 반환합니다.
            return u.append(solution(v.toString())).toString();
        } else {  // 4. 문자열 u가 "올바른 괄호 문자열"이 아니라면 아래 과정을 수행합니다.
            // 4-1, 4-2, 4-3
            StringBuilder answer = new StringBuilder();
            answer.append("(").append(solution(v.toString())).append(")");
            // 4-4
            u.delete(0, 1);
            u.deleteCharAt(u.length() - 1);
            for (int i = 0; i < u.length(); i++) {
                if (u.charAt(i) == '(') {
                    answer.append(')');
                } else {
                    answer.append('(');
                }
            }
            // 4-5
            return answer.toString();
        }
    }

    // 2번 과정을 위해 균형잡힌 괄호 문자열로 구분되는 인덱스 구하기
    private static int checkBalancedString(String s) {
        int leftBracketCnt = 0;
        int rightBracketCnt = 0;

        int divideIdx = -1;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                leftBracketCnt += 1;
            } else {
                rightBracketCnt += 1;
            }

            // 왼쪽 괄호 수와 오른쪽 괄호의 수가 같아지는 경우 해당 인덱스를 저장하고 반복 종료
            if (leftBracketCnt != 0 && rightBracketCnt != 0) {
                if (leftBracketCnt == rightBracketCnt) {
                    divideIdx = i;
                    break;
                }
            }
        }

        return divideIdx;  // 균형잡힌 괄호 문자열로 나눠지는 인덱스 반환
    }

    // 3, 4번 올바른 문자열인지를 확인하는 메소드
    private static boolean checkCorrectString(String s) {
        Stack stack = new Stack();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                // 스택에 추가
                stack.push(c);
            } else {
                // 스택에서 pop
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            }
        }

        // 스택이 비었는지 확인하여 비어있는 경우 짝이 모두 맞으므로 true 반환
        if (stack.isEmpty()) {
            return true;
        } else {  // 스택에 문자가 남아있는 경우 짝이 맞지 않으므로 false 반환
            return false;
        }
    }
}
