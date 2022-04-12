package Apr2022;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2579 {
    private static Integer[] dp;
    private static int[] steps;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        dp = new Integer[n + 1];
        steps = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            steps[i] = Integer.parseInt(br.readLine());
        }

        dp[0] = steps[0];
        dp[1] = steps[1];

        if (n >= 2) {
            dp[2] = steps[1] + steps[2];
        }

        System.out.println(upToStair(n));
    }

    private static int upToStair(int step) {
        // 아직 밟지 않은 계단인 경우
        if (dp[step] == null) {
            dp[step] = Math.max(upToStair(step - 2), upToStair(step - 3) + steps[step - 1]) + steps[step];
        }

        return dp[step];
    }
}
