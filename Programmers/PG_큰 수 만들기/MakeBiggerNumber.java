import java.util.Stack;

public class MakeBiggerNumber {
    public static void main(String[] args) {
        System.out.println(solution("1924", 2));
    }

    private static String solution(String number, int k) {
        char[] answer = new char[number.length() - k];
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < number.length(); i++) {
            char cur = number.charAt(i);
            while (!stack.isEmpty() && stack.peek() < cur && k-- > 0) {
                stack.pop();
            }

            stack.push(cur);
        }

        for (int i = 0; i < answer.length; i++) {
            answer[i] = stack.get(i);
        }

        return new String(answer);
    }
}
