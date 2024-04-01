package Feb2022;

import java.util.Arrays;

public class SecretMap {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(5, new int[]{9, 20, 28, 18, 11}, new int[]{30, 1, 21, 17, 28})));
    }

    private static String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];

        boolean[][] map1 = makeMap(n, arr1);
        boolean[][] map2 = makeMap(n, arr2);

        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                char isWall = (map1[i][j] || map2[i][j]) ? '#' : ' ';
                sb.append(isWall);
            }

            answer[i] = sb.toString();
        }

        return answer;
    }

    private static boolean[][] makeMap(int n, int[] arr) {
        boolean[][] map = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            int tmp = arr[i];
            for (int j = n - 1; j >= 0; j--) {
                map[i][j] = tmp % 2 == 1;
                tmp /= 2;
            }
        }

        return map;
    }
}
