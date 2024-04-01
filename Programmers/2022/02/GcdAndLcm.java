package Feb2022;

import java.util.Arrays;

public class GcdAndLcm {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(3, 12)));
    }

    private static int[] solution(int n, int m) {
        int[] answer = new int[2];

        int num1 = Math.max(n, m);
        int num2 = Math.min(n, m);

        answer[0] = gcd(num1, num2);
        answer[1] = (num1 * num2) / answer[0];

        return answer;
    }

    private static int gcd(int num1, int num2) {
        if (num2 == 0) return num1;
        else return gcd(num2, num1 % num2);
    }
}
