package Apr2022;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q1149 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] RGB = new int[n][3];

        for (int i = 0; i < n; i++) {
            RGB[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        int[][] paint = new int[n][3];
        paint[0][0] = RGB[0][0];
        paint[0][1] = RGB[0][1];
        paint[0][2] = RGB[0][2];

        for (int i = 1; i < n; i++) {
            paint[i][0] = RGB[i][0] + Math.min(paint[i - 1][1], paint[i - 1][2]);
            paint[i][1] = RGB[i][1] + Math.min(paint[i - 1][0], paint[i - 1][2]);
            paint[i][2] = RGB[i][2] + Math.min(paint[i - 1][0], paint[i - 1][1]);
        }

        int answer = Arrays.stream(paint[n - 1]).min().getAsInt();
        System.out.println(answer);
    }
}
