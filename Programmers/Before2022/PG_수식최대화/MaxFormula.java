import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MaxFormula {
    public static void main(String[] args) {
        System.out.println(solution("50*6-3*2"));
    }

    private static long solution(String expression) {
        Character[][] operations = new Character[][]{{'*', '+', '-'}, {'*', '-', '+'}, {'+', '*', '-'},
                {'+', '-', '*'}, {'-', '+', '*'}, {'-', '*', '+'}};

        long answer = 0;

        for (Character[] operation : operations) {
            List<Long> exNum = new ArrayList<>();
            String[] nums = expression.split("[^0-9]");
            for (String n : nums) {
                exNum.add(Long.parseLong(n));
            }

            List<String> exOp = Arrays.stream(expression.split("[0-9]")).filter(s -> !s.equals("")).collect(Collectors.toList());

            for (char op : operation) {
                while (true) {
                    int i = exOp.indexOf(String.valueOf(op));
                    if (i < 0) {
                        break;
                    }

                    switch (op) {
                        case '*':
                            long mul = exNum.remove(i) * exNum.remove(i);
                            exNum.add(i, mul);
                            break;
                        case '+':
                            long add = exNum.remove(i) + exNum.remove(i);
                            exNum.add(i, add);
                            break;
                        case '-':
                            long minus = exNum.remove(i) - exNum.remove(i);
                            exNum.add(i, minus);
                            break;
                    }

                    exOp.remove(i);
                }
            }

            answer = Math.max(Math.abs(exNum.get(0)), answer);
        }

        return answer;
    }
}
