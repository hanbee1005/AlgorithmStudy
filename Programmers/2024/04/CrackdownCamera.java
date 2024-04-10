package Apr2024;

import java.util.Arrays;

/**
 * Level 3. 단속 카메라 (그리디)
 */
public class CrackdownCamera {
    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{-20,-15}, {-14,-5}, {-18,-13}, {-5,-3}}));
        System.out.println(solution(new int[][]{{0, 1}, {2, 10}, {2, 3}, {4, 5}}));
    }

    private static int solution(int[][] routes) {
        int answer = 0;

        Arrays.sort(routes, (r1, r2) -> r1[1] - r2[1]);

        int last = -30001;
        for (int[] route : routes) {
            if (route[0] > last) {
                answer++;
                last = route[1];
            }
        }

        return answer;
    }
}
