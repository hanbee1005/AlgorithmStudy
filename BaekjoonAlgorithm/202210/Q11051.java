package Oct2022;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q11051 {
    private static long[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        dp = new long[N + 1][K + 1];

        System.out.println(BC(N, K));
    }

    private static long BC(int N, int K) {
        // 이미 풀었던 sub 문제인 경우 재활용
        if (dp[N][K] > 0) {
            return dp[N][K];
        }

        // 2번 성질
        if (N == K || K == 0) {
            return dp[N][K] = 1;
        }

        // 1번 성질
        return dp[N][K] = (BC(N - 1, K - 1) + BC(N - 1, K)) % 10007;
    }
}
