package May2022;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2740 {
    private static int[][] A;
    private static int[][] B;

    private static int[][] answer;

    private static StringBuffer sb = new StringBuffer();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 2; i++) {
            makeMatrix(br, i);
        }

        multi();

        System.out.println(sb);
    }

    private static void makeMatrix(BufferedReader br, int idx) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        if (idx == 0) {
            A = new int[N][M];
        } else {
            B = new int[N][M];
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                if (idx == 0) {
                    A[i][j] = Integer.parseInt(st.nextToken());
                } else {
                    B[i][j] = Integer.parseInt(st.nextToken());
                }
            }
        }
    }

    private static void multi() {
        answer = new int[A.length][B[0].length];

        for (int n = 0; n < A.length; n++) {
            for (int k = 0; k < B[0].length; k++) {
                for (int m = 0;  m < B.length; m++) {
                    answer[n][k] += A[n][m] * B[m][k];
                }
                sb.append(answer[n][k]).append(" ");
            }
            sb.append("\n");
        }
    }
}
