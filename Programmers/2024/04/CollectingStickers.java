package Apr2024;

/**
 * Level 3. 스티커 모으기(2)
 */
public class CollectingStickers {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{14, 6, 5, 11, 3, 9, 2, 10}));
        System.out.println(solution(new int[]{1, 3, 2, 5, 4}));
    }

    private static int solution(int[] sticker) {
        int answer = 0;

        if (sticker.length == 1) {
            return sticker[0];
        }

        int[] dp = new int[sticker.length];

        // 첫 번째 스티커를 뗀 경우
        dp[0] = sticker[0];
        dp[1] = sticker[0];

        for (int i = 2; i < dp.length - 1; i++) {
            if (dp[i - 1] < sticker[i] + dp[i - 2]) {
                dp[i] = sticker[i] + dp[i - 2];
            } else {
                dp[i] = dp[i - 1];
            }
        }

        answer = dp[dp.length - 2];

        // 첫 번째 스티커를 떼지 않은 경우
        dp[0] = 0;
        dp[1] = sticker[1];

        for (int i = 2; i < dp.length; i++) {
            if (dp[i - 1] < sticker[i] + dp[i - 2]) {
                dp[i] = sticker[i] + dp[i - 2];
            } else {
                dp[i] = dp[i - 1];
            }
        }

        if (answer < dp[dp.length - 1]) {
            answer = dp[dp.length - 1];
        }

        return answer;
    }
}
