package Sep2022;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q24416 {
    private static int fibCount = 0;
    private static int fibonacciCount = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        fib(n);
        fibonacci(n);

        System.out.println(fibCount + " " + fibonacciCount);
    }

    private static int fib(int n) {
        if (n == 1 || n == 2) {
            fibCount++;
            return 1;
        }

        return (fib(n - 1) + fib(n - 2));
    }

    private static int fibonacci(int n) {
        int[] f = new int[n + 1];
        f[1] = f[2] = 1;
        for (int i = 3; i <= n; i++) {
            fibonacciCount++;
            f[i] = f[i - 1] + f[i - 2];
        }

        return f[n];
    }
}
