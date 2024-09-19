package dynamicprogramming;

import java.util.ArrayList;
import java.util.List;

public class DifferentWaysToAddParentheses_241 {
    public static void main(String[] args) {
        System.out.println(diffWaysToCompute("2-1-1"));
        System.out.println(diffWaysToCompute("2*3-4*5"));
    }

    private static List<Integer> diffWaysToCompute(String expression) {
        List<Integer> answer = new ArrayList<>();

        // 연산자가 있는 경우 분할 정복 시작
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);

            if (c == '+' || c == '-' || c == '*') {
                // 연산자를 기준으로 좌우로 수식을 분할
                String leftPart = expression.substring(0, i);
                String rightPart = expression.substring(i + 1);

                // 좌측과 우측 수식을 재귀적으로 계산
                List<Integer> leftResults = diffWaysToCompute(leftPart);
                List<Integer> rightResults = diffWaysToCompute(rightPart);

                // 두 결과를 결합하여 가능한 모든 값을 계산
                for (Integer left : leftResults) {
                    for (Integer right : rightResults) {
                        if (c == '+') {
                            answer.add(left + right);
                        } else if (c == '-') {
                            answer.add(left - right);
                        } else if (c == '*') {
                            answer.add(left * right);
                        }
                    }
                }
            }
        }

        // 숫자만 있는 경우, 그대로 리스트에 추가
        if (answer.isEmpty()) {
            answer.add(Integer.parseInt(expression));
        }

        return answer;
    }
}
