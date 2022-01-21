import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class RotateBracket {
    public static void main(String[] args) {
        System.out.println(solution("[](){}"));
    }

    private static int solution(String s) {
        int answer = 0;

        Queue<Character> brackets = new LinkedList<>();
        for (char c : s.toCharArray()) {
            brackets.offer(c);
        }

        for (int i = 0; i < s.length(); i++) {
            Queue<Character> copyBrackets = new LinkedList<>(brackets);
            boolean correct = correctBracket(copyBrackets);
            if (correct) answer++;

            brackets.offer(brackets.poll());
        }


        return answer;
    }

    private static boolean correctBracket(Queue<Character> brackets) {
        Stack<Character> stack = new Stack<>();

        while (!brackets.isEmpty()) {
            char bracket = brackets.poll();

            if (stack.isEmpty()) {
                stack.push(bracket);
            } else {
                char b = stack.peek();
                if ((b == '[' && bracket == ']')
                        || (b == '(' && bracket == ')')
                        || (b == '{' && bracket == '}')) {
                    stack.pop();
                } else {
                    stack.push(bracket);
                }
            }
        }

        return stack.isEmpty();
    }
}
