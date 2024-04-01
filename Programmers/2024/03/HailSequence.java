package Mar2024;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Level 2. 우박수열 정적분
 */
public class HailSequence {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(5, new int[][]{{0, 0}, {0, -1}, {2, -3}, {3, -3}})));
        System.out.println(Arrays.toString(solution(3, new int[][]{{0, 0}, {1, -2}, {3, -3}})));
    }

    private static double[] solution(int k, int[][] ranges) {
        double[] answer = new double[ranges.length];
        List<Integer> points = calculateSequence(k);

        for (int i = 0; i < ranges.length; i++) {
            int a = ranges[i][0];
            int b = points.size() + ranges[i][1];

            if (b <= a) {
                answer[i] = -1.0;
                continue;
            }

            for (int j = a + 1; j < b; j++) {
                answer[i] += (points.get(j - 1) + points.get(j)) / 2.0;
            }
        }

        return answer;
    }

    private static List<Integer> calculateSequence(int k) {
        List<Integer> points = new ArrayList<>();

        while(true) {
            points.add(k);

            if (k == 1) {
                break;
            }

            if (k % 2 == 0) {
                k /= 2;
            } else {
                k = k * 3 + 1;
            }
        }

        return points;
    }
}
