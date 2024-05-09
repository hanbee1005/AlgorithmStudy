package May2024;

/**
 * Level 3. 거스름돈
 */
public class TheChange {
    public static void main(String[] args) {
        System.out.println(solution(5, new int[]{1,2,5}));
    }

    private static int solution(int n, int[] money) {
        int answer = 0;

        int m = money.length;
        long [] dp = new long[n + 1];
        for(int i = 0; i < m; i++){
            int cur = money[i];
            if(cur > n) continue;
            dp[cur]++;
            for(int j = 1; j <= n; j++){
                if(j - cur >= 0){
                    dp[j] += dp[j - cur];
                    dp[j] %= 1000000007;
                }
            }
        }

        return (int) dp[n];
    }
}
