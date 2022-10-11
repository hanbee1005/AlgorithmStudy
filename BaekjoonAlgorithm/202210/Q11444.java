package Oct2022;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q11444 {
    private static long[][] root = {{1, 1}, {1, 0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        System.out.println(fibonacci(n));
    }

    private static long fibonacci(long n) {
        long[][] m = matrix(n - 1);
        return m[0][0];
    }

    private static long[][] matrix(long n) {
        if (n <= 1) {
            return root;
        }

        long[][] m = matrix(n / 2);
        if (n % 2 == 0) {
            return multi(m, m);
        } else {
            return multi(multi(m, m), root);
        }
    }

    private static long[][] multi(long[][] A, long[][] B) {
        long[][] result = new long[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 2; k++) {
                    result[i][j] += A[i][k] * B[k][j];
                }
            }
        }

        return divide(result);
    }

    private static long[][] divide(long[][] m) {
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m.length; j++) {
                m[i][j] %= 1000000007;
            }
        }

        return m;
    }
}
