package dynamicprogramming;

public class UglyNumberII_264 {
    public static void main(String[] args) {
        System.out.println(nthUglyNumber(10));
        System.out.println(nthUglyNumber(1));
    }

    private static int nthUglyNumber(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;

        int p2 = 1;
        int p3 = 1;
        int p5 = 1;

        for(int i = 2; i <= n; i++){
            int k1 = 2 * dp[p2];
            int k2 = 3 * dp[p3];
            int k3 = 5 * dp[p5];

            dp[i] = Math.min(k1, Math.min(k2, k3));

            if(dp[i] == k1) p2++;
            if(dp[i] == k2) p3++;
            if(dp[i] == k3) p5++;
        }

        return dp[n];
    }
}
