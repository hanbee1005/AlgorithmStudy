package May2022;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q11054 {
    private static int N;
    private static int[] A;
    private static Integer[] r_dp;
    private static Integer[] l_dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        r_dp = new Integer[N];
        l_dp = new Integer[N];

        for (int i = 0; i < N; i++) {
            LIS(i);
            LDS(i);
        }

        int[] dp = new int[N];
        for(int i = 0; i < N; i++) {
            dp[i] = r_dp[i] + l_dp[i] - 1;
        }

        System.out.println(Arrays.toString(dp));
        System.out.println(Arrays.stream(dp).max().getAsInt());
    }

    private static int LIS(int n) {
        // 탐색하지않은 위치인 경우
        if (r_dp[n] == null) {
            r_dp[n] = 1;  // 초기화

            for (int i = 0; i < n; i++) {
                // 이전 노드 중 작은 값을 발견한 경우
                if (A[i] < A[n]) {
                    r_dp[n] = Math.max(r_dp[n], LIS(i) + 1);
                }
            }
        }

        return r_dp[n];
    }

    private static int LDS(int n) {
        // 탐색하지않은 위치인 경우
        if (l_dp[n] == null) {
            l_dp[n] = 1;  // 초기화

            for (int i = N - 1; i > n; i--) {
                // 이전 노드 중 작은 값을 발견한 경우
                if (A[i] < A[n]) {
                    l_dp[n] = Math.max(l_dp[n], LDS(i) + 1);
                }
            }
        }

        return l_dp[n];
    }
}
