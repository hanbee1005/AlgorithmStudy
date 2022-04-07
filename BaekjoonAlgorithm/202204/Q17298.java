package Apr2022;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class Q17298 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] numbers = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        StringBuffer buffer = new StringBuffer();
        int[] answer = new int[n];
        Arrays.fill(answer, -1);

        Stack<int[]> stack = new Stack<>();

        for (int i = 0; i < numbers.length; i++) {
            if (stack.isEmpty() || numbers[i] <= stack.peek()[1]) {
                stack.push(new int[]{i, numbers[i]});
                continue;
            }

            while (!stack.isEmpty() && numbers[i] > stack.peek()[1]) {
                int[] pop = stack.pop();
                answer[pop[0]] = numbers[i];
            }

            stack.push(new int[]{i, numbers[i]});
        }

        for (int j : answer) {
            buffer.append(j).append(" ");
        }

        System.out.println(buffer);
    }
}