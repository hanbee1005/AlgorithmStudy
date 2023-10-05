package Oct2023;

import java.util.Arrays;

/**
 * Level 2. 테이블 해시 함수
 */
public class TableHashFunction {
    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{2,2,6},{1,5,10},{4,2,9},{3,8,3}}, 2, 2, 3));
    }

    public static int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;

        Arrays.sort(data, (d1, d2) -> {
            if (d1[col - 1] == d2[col - 1]) return d2[0] - d1[0];
            return d1[col - 1] - d2[col - 1];
        });

        for (int i = row_begin; i <= row_end; i++) {
            int[] cur = data[i - 1];
            int sum = 0;

            for (int c : cur) {
                sum += c % i;
            }

            answer ^= sum;
        }

        return answer;
    }
}
