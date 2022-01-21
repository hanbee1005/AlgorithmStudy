package Jan2022;

import java.util.Arrays;

public class LandGame {

    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{1,2,6,7},{2,3,10,8},{1,3,9,4},{7,11,9,4}}));
    }

    private static int solution(int[][] land) {
        for (int i = 1; i < land.length; i++) {
            for (int n = 0; n < 4; n++) {
                int max = 0;
                for (int m = 0; m < 4; m++) {
                    if (n == m) continue;

                    max = Math.max(max, land[i - 1][m]);
                }

                land[i][n] += max;
            }
        }

        return Arrays.stream(land[land.length - 1]).max().getAsInt();
    }
}
