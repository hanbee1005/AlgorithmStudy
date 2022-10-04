package Oct2022;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q10830 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        long[][] A = new long[N][N];
        for (int i = 0; i < N; i++) {
            A[i] = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
        }

        StringBuilder sb = new StringBuilder();
        long[][] result = multiply(A, B);
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                sb.append(result[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static long[][] multiply(long[][] arr, long count) {
        if (count <= 1) {
            return divide(arr);
        }

        long[][] tmp = multiply(arr, count / 2);
        if (count % 2 == 0) {
            return matrix(tmp, tmp);
        } else {
            return matrix(matrix(tmp, tmp), arr);
        }
    }

    private static long[][] matrix(long[][] n, long[][]m) {
        long[][] result = new long[n.length][n.length];
        for (int i = 0; i < n.length; i++) {
            for (int j = 0; j < n.length; j++) {
                long tmp = 0;
                for (int k = 0; k < n.length; k++) {
                    tmp += n[i][k] * m[k][j];
                }
                result[i][j] = tmp;
            }
        }

        return divide(result);
    }

    private static long[][] divide(long[][] arr) {
        // 각 요소를 1000으로 나누기
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                arr[i][j] %= 1000;
            }
        }
        return arr;
    }

}
