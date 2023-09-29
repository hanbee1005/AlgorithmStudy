package Sep2023;

/**
 * Top Coder Infinity Sequence2 SRM413 Div 1 Level 2
 */
public class TopCoderInfinitySequence2 {
    private static long[] dp;
    private static int MAX = 1000000;

    public static void main(String[] args) {
        System.out.println(calc(1000000, 2, 3, 1000000, 1000000));
        System.out.println(calc(12, 2, 3, 1, 0));
        System.out.println(calc(0, 2, 2, 0, 0));
        System.out.println(calc(124, 45, 67, 8, 9));
        System.out.println(calc(10000000000000L, 2, 2, 0, 123456));
    }

    private static long calc(long n, int p, int q, int x, int y) {
        if (n <= 0) return 1;

        dp = new long[MAX];
        dp[0] = 1;

        return recursion(n, q, p, x, y);
    }

    private static long recursion(long n, int p, int q, int x, int y) {
        if (n <= 0) return 1;
        if (n < MAX) {
            if (dp[(int) n] != 0) return dp[(int) n];
            return dp[(int) n] = recursion(n / p - x, p, q, x, y) + recursion(n / q - y, p, q, x, y);
        }

        return recursion(n / p - x, p, q, x, y) + recursion(n / q - y, p, q, x, y);
    }
}
