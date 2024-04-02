package Apr2024;

import java.util.Arrays;

/**
 * Level 3. 정수 삼각형 (동적 계획법)
 */
public class IntegerTriangle {
    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}}));
    }

    private static int solution(int[][] triangle) {
        int answer = 0;

        int[][] sum = new int[triangle.length][triangle.length];
        sum[0][0] = triangle[0][0];

        for (int i = 1; i < triangle.length; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    sum[i][j] = sum[i - 1][j] + triangle[i][j];
                } else if (j == i) {
                    sum[i][j] = sum[i - 1][j - 1] + triangle[i][j];
                } else {
                    sum[i][j] = Math.max(sum[i - 1][j - 1], sum[i - 1][j]) + triangle[i][j];
                }
            }
        }

        answer = Arrays.stream(sum[triangle.length - 1]).max().orElse(0);
        return answer;
    }
}
