package Apr2022;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q1912 {
    private static Integer[] dp;
    private static int[] nums;
    private static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        dp = new Integer[n];

        dp[0] = nums[0];
        max = nums[0];

        recur(n - 1);

        System.out.println(max);
    }

    private static int recur(int n) {
        // 아직 탐색하지 않은 인덱스라면
        if (dp[n] == null) {

            // (이전 누적 합 + 현재 값)과 현재 값을 비교해서 더 큰 수를 저장
            dp[n] = Math.max(recur(n - 1) + nums[n], nums[n]);

            max = Math.max(max, dp[n]);
        }

        return dp[n];
    }
}
