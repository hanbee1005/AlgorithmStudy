package Sep2023;

import java.util.*;

/**
 * Level 2. 줄 서는 방법
 */
public class HowToLineUp {
    private static long[] factorial;

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(4, 6)));
    }

    private static int[] solution(int n, long k) {
        int[] answer = new int[n];

        factorial = new long[n + 1];
        factorial[0] = 0;
        factorial[1] = 1;

        for (int i = 2; i <= n; i++) {
            factorial[i] = factorial[i - 1] * i;
        }

        List<Integer> remainNumbers = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            remainNumbers.add(i);
        }

        long remain = --k;
        int i = 0;

        while (remainNumbers.size() > 1) {
            long quot = remain / factorial[n - 1];
            remain = remain % factorial[n - 1];

            answer[i++] = remainNumbers.remove((int)quot);
            n--;
        }

        answer[i] = remainNumbers.get(0);

        return answer;
    }
}
