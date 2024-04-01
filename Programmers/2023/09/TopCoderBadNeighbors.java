package Sep2023;

/**
 * Top Coder BadNeighbors 2004 TCCC Online Round 4 Div 1 Level 1
 */
public class TopCoderBadNeighbors {

    public static void main(String[] args) {
        System.out.println(maxDonations(new int[]{10, 3, 2, 5, 7, 8}));
        System.out.println(maxDonations(new int[]{11, 15}));
        System.out.println(maxDonations(new int[]{7, 7, 7, 7, 7, 7, 7}));
        System.out.println(maxDonations(new int[]{1, 2, 3, 4, 5, 1, 2, 3, 4, 5}));
    }

    private static int maxDonations(int[] donations) {
        int answer = 0;
        int[] dp = new int[donations.length];

        // 0 번째 집부터 시작하는 경우
        for (int i = 0; i < donations.length - 1; i++) {
            dp[i] = donations[i];

            if (i > 0) dp[i] = Math.max(dp[i], dp[i - 1]);
            if (i > 1) dp[i] = Math.max(dp[i], dp[i - 2] + donations[i]);

            answer = Math.max(answer, dp[i]);
        }

        // 1 번째 집부터 시작하는 경우
        for (int i = 0; i < donations.length - 1; i++) {
            dp[i] = donations[i + 1];

            if (i > 0) dp[i] = Math.max(dp[i], dp[i - 1]);
            if (i > 1) dp[i] = Math.max(dp[i], dp[i - 2] + donations[i + 1]);

            answer = Math.max(answer, dp[i]);
        }

        return answer;
    }
}
