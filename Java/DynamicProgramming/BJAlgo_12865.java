import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJAlgo_12865 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] nk = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[][] dp = new int[nk[0] + 1][nk[1] + 1];
        for (int i = 1; i < nk[0] + 1; i++) {
            int[] wv = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int j = 1; j < nk[1] + 1; j++) {
                if (j < wv[0]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - wv[0]] + wv[1]);
                }
            }
        }

        System.out.println(dp[nk[0]][nk[1]]);
    }
}
