package Sep2023;

/**
 * Top Coder HandShaking SRM363 Div 2 Level 2
 */
public class TopCoderHandShaking {
    public static void main(String[] args) {
        System.out.println(countPerfect(2));
        System.out.println(countPerfect(4));
        System.out.println(countPerfect(8));
    }

    private static long countPerfect(int n) {
        long[] dp = new long[n / 2 + 1];
        dp[0] = 1;

        for (int i = 1; i <= n / 2; i++) {
            dp[i] = 0;

            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }

        return dp[n / 2];
    }
}
