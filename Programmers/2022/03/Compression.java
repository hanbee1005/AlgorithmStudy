package Mar2022;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Compression {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution("KAKAO")));
    }

    private static int[] solution(String msg) {
        List<Integer> answer = new ArrayList<>();

        List<String> dic = new ArrayList<>(){{
            add(""); add("A"); add("B"); add("C"); add("D"); add("E"); add("F"); add("G"); add("H"); add("I"); add("J");
            add("K"); add("L"); add("M"); add("N"); add("O"); add("P"); add("Q"); add("R"); add("S"); add("T"); add("U");
            add("V"); add("W"); add("X"); add("Y"); add("Z");
        }};

        Stack<Character> stack = new Stack<>();
        for (int i = msg.length() - 1; i >= 0; i--) {
            stack.push(msg.charAt(i));
        }

        while (!stack.isEmpty()) {
            int idx = 0;
            StringBuilder sb = new StringBuilder();
            while (!stack.isEmpty()) {
                sb.append(stack.pop());
                if (dic.contains(sb.toString())) {
                    idx = dic.indexOf(sb.toString());
                } else {
                    stack.push(sb.charAt(sb.length() - 1));
                    break;
                }
            }

            answer.add(idx);

            if (!dic.contains(sb.toString())) {
                dic.add(sb.toString());
            }
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
