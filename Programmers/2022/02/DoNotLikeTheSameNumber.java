package Feb2022;

import java.util.Arrays;
import java.util.Stack;

public class DoNotLikeTheSameNumber {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{1, 1, 3, 3, 0, 1, 1})));
    }

    private static int[] solution(int []arr) {
        Stack<Integer> stack = new Stack<>();
        Arrays.stream(arr)
                .forEach(num -> {
                    if (stack.isEmpty()) stack.push(num);
                    else {
                        if (stack.peek() != num) stack.push(num);
                    }
                });

        int[] answer = stack.stream()
                .mapToInt(Integer::intValue)
                .toArray();
        return answer;
    }
}
