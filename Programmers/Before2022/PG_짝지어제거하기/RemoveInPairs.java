import java.util.Stack;

public class RemoveInPairs {
    public static void main(String[] args) {
        System.out.println(solution("baabaa"));
    }

    private static int solution(String s)
    {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (stack.isEmpty()) {
                stack.push(c);
                continue;
            }

            if (stack.lastElement() == c) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }

        return stack.isEmpty() ? 1 : 0;
    }
}
