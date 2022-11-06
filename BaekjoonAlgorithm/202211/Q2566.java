package Nov2022;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q2566 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int max = 0;
        int x = 0;
        int y = 0;

        int[][] matrix = new int[9][9];
        for (int i = 0; i < 9; i++) {
            int[] tmp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < 9; j++) {
                matrix[i][j] = tmp[j];

                if (max < matrix[i][j]) {
                    max = matrix[i][j];
                    x = i;
                    y = j;
                }
            }
        }

        System.out.println(max);
        System.out.println((x + 1) + " " + (y + 1));
    }
}
