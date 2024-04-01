package Apr2024;

public class N3Tiling {
    public static void main(String[] args) {
        System.out.println(solution(4));
    }

    public static int solution(int n) {
        int mod = 1000000007;

        long[][] dp = new long[n / 2 + 1][2];
        dp[1][0] = 3;
        dp[1][1] = 0;
        dp[2][0] = 11;
        dp[2][1] = 3;

        int idx = n / 2;

        if (n % 2 != 0) {
            return 0;
        }

        if (idx < 3) {
            return (int) dp[idx][0];
        }

        for (int i = 3; i < idx + 1; i++) {
            dp[i][0] = ((dp[i - 1][0] * 3) + (dp[i - 1][1] * 2 + 2)) % mod;
            dp[i][1] = dp[i - 1][0] + dp[i - 1][1];
        }

        return (int) dp[idx][0];
    }
}
