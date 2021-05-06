import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJAlgo_11049 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] matrix = new int[n][2];
        for (int i = 0; i < n; i++) {
            matrix[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        int[][] dp = new int[n][n];
        for (int i = 0; i < n - 1; i++) {
            dp[i][i + 1] = matrix[i][0] * matrix[i][1] * matrix[i + 1][1];
        }

        for (int j = 2; j < n; j++) {
            for (int i = 0; i + j < n; i++) {
                for (int k = i; k < i + j; k++) {
                    if (dp[i][i + j] == 0) {
                        dp[i][i + j] = dp[i][k] + dp[k + 1][i + j] + (matrix[i][0] * matrix[k + 1][0] * matrix[i + j][1]);
                    } else {
                        dp[i][i + j] = Math.min(dp[i][i + j], dp[i][k] + dp[k + 1][i + j] + (matrix[i][0] * matrix[k + 1][0] * matrix[i + j][1]));
                    }
                }
            }
        }

        System.out.println(dp[0][n - 1]);
    }
}
