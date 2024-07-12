package stack;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseSubstringsBetweenEachPairOfParentheses_1190 {
    public static void main(String[] args) {
        System.out.println(reverseParentheses("(abcd)"));
        System.out.println(reverseParentheses("(u(love)i)"));
        System.out.println(reverseParentheses("(ed(et(oc))el)"));
    }

    private static String reverseParentheses(String s) {
        StringBuilder sb = new StringBuilder();

        Stack<Character> stack = new Stack<>();
        Queue<Character> queue = new LinkedList<>();
        for (char c : s.toCharArray()) {
            if (c == ')') {
                while (!stack.isEmpty()) {
                    char top = stack.pop();

                    if (top == '(') {
                        break;
                    }

                    queue.offer(top);
                }

                while (!queue.isEmpty()) {
                    stack.push(queue.poll());
                }
            } else {
                stack.push(c);
            }
        }

        while (!stack.isEmpty()) {
            sb.insert(0, stack.pop());
        }

        return sb.toString();
    }
}
