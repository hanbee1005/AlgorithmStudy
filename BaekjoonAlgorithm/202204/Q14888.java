package Apr2022;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class Q14888 {
    private static Character[] operator = {'+', '-', '*', '/'};
    private static int min = Integer.MAX_VALUE;
    private static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        int[] An = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] operators = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        // make operator string
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < operators.length; i++) {
            for (int j = 0; j < operators[i]; j++) {
                buffer.append(operator[i]);
            }
        }
        String[] op = buffer.toString().split("");

        permutation(An, op, new String[op.length], new boolean[op.length], op.length, 0);

        System.out.println(max);
        System.out.println(min);
    }

    private static void permutation(int[] An, String[] op, String[] output, boolean[] isSelected, int n, int dept) {
        if  (dept == n) {
            findMinMax(An, output);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!isSelected[i]) {
                output[dept] = op[i];
                isSelected[i] = true;
                permutation(An, op, output, isSelected, n, dept + 1);
                isSelected[i] = false;
            }
        }
    }

    private static void findMinMax(int[] An, String[] op) {
        Stack<Integer> stack = new Stack<>();
        stack.push(An[0]);

        for (int i = 0; i < An.length - 1; i++) {
            int num = An[i+1];
            String o = op[i];

            if (!stack.isEmpty()) {
                int before = stack.pop();
                int mid = calculator(before, num, o);
                stack.push(mid);
            }
        }

        int result = stack.pop();
        min = Math.min(min, result);
        max = Math.max(max, result);
    }

    private static int calculator(int num1, int num2, String op) {
        if (op.equals("+")) {
            return num1 + num2;
        } else if (op.equals("-")) {
            return  num1 - num2;
        } else if (op.equals("*")) {
            return num1 * num2;
        } else {
            if (num1 < 0) {
                return ((num1 * -1) / num2) * -1;
            } else {
                return num1 / num2;
            }
        }
    }
}
