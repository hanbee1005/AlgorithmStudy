package Dec2021;

import java.util.Arrays;

public class NSquareArrayCut {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(3, 2, 5)));
    }

    private static int[] solution(int n, long left, long right) {
        int[] answer = new int[(int) (right - left + 1)];

        int idx = 0;
        for (long i = left; i <= right; i++) {
            int a = (int) (i / n);
            int b = (int) (i % n);

            if (a < b) {
                int tmp = 0;
                tmp = a;
                a = b;
                b = tmp;
            }

            answer[idx] = a + 1;
            idx++;
        }

        return answer;
    }
}