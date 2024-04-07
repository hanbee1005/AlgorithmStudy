package Apr2024;

import java.util.Arrays;

/**
 * Level 3. 최고의 집합
 */
public class TheBestSet {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(2, 9)));
        System.out.println(Arrays.toString(solution(2, 1)));
        System.out.println(Arrays.toString(solution(2, 8)));
    }

    private static int[] solution(int n, int s) {
        int[] answer = new int[n];

        if (s == 1 || n > s) {
            return new int[]{-1};
        }

        int base = s / n;
        int remainder = s % n;

        for (int i = n - 1; i >= 0; i--) {
            if (i >= n - remainder) {
                answer[i] = base + 1;
            } else {
                answer[i] = base;
            }
        }

        return answer;
    }
}
