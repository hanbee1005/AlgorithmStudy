package Apr2022;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1463 {
    private static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        makeOne(n, 0);
        System.out.println(answer);
    }

    private static void makeOne(int n, int count) {
        if (n == 1) {
            answer = Math.min(answer, count);
            return;
        }

        if (count > answer) {
            return;
        }

        if (n % 3 == 0) {
            makeOne(n / 3, count + 1);
        }

        if (n % 2 == 0) {
            makeOne(n / 2, count + 1);
        }

        makeOne(n - 1, count + 1);
    }
}
