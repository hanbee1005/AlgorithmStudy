package array;

import java.util.Arrays;

public class Convert1DArrayInto2DArray_2022 {
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(construct2DArray(new int[]{1, 2, 3, 4}, 2, 2)));
        System.out.println(Arrays.deepToString(construct2DArray(new int[]{1, 2, 3}, 1, 3)));
        System.out.println(Arrays.deepToString(construct2DArray(new int[]{1, 2}, 1, 1)));
    }

    private static int[][] construct2DArray(int[] original, int m, int n) {
        if (original.length != m * n) {
            return new int[0][0];
        }

        int[][] answer = new int[m][n];
        int k = 0;

        for (int x = 0; x < m; x++) {
            for (int y = 0; y < n; y++) {
                answer[x][y] = original[k++];
            }
        }

        return answer;
    }
}
