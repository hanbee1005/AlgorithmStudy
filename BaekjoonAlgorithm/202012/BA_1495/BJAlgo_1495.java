import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJAlgo_1495 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] nsm = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] v = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int[][] dp = new int[nsm[0] + 1][nsm[2] + 1];
        dp[0][nsm[1]] = 1;

        for (int i = 1; i < nsm[0] + 1; i++) {
            for (int j = 0; j < nsm[2] + 1; j++) {
                if (dp[i - 1][j] == 1) {
                    if (j + v[i - 1] <= nsm[2]) {
                        dp[i][j + v[i - 1]] = 1;
                    }

                    if (j - v[i - 1] >= 0) {
                        dp[i][j - v[i - 1]] = 1;
                    }
                }
            }
        }

        int result = -1;
        for (int i = dp[nsm[0]].length - 1; i >= 0; i--) {
            if (dp[nsm[0]][i] == 1) {
                result = i;
                break;
            }
        }

        System.out.println(result);
    }
}
