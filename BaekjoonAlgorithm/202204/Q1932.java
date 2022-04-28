package Apr2022;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q1932 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] triangle = new int[n][n];
        for (int i = 0; i < n; i++) {
            triangle[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        int[][] sums = new int[n][n];
        sums[0][0] = triangle[0][0];
        for (int i = 1; i < n; i++) {
            sums[i][0] = triangle[i][0] + sums[i - 1][0];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= i; j++) {
                sums[i][j] = triangle[i][j] + Math.max(sums[i - 1][j - 1], sums[i - 1][j]);
            }
        }

        int answer = Arrays.stream(sums[n - 1]).max().getAsInt();

        System.out.println(answer);
    }
}
