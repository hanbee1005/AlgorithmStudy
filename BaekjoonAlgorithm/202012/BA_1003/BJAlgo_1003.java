import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJAlgo_1003 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] result = new int[41][2];
        result[0][0] = 1;
        result[1][1] = 1;
        for (int i = 2; i < result.length; i++) {
            result[i][0] = result[i - 1][0] + result[i - 2][0];
            result[i][1] = result[i - 1][1] + result[i - 2][1];
        }

        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            int n = Integer.parseInt(br.readLine());
            System.out.println(result[n][0] + " " + result[n][1]);
        }
    }
}
