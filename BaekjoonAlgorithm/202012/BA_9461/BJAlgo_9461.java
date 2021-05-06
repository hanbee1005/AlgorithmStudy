import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJAlgo_9461 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long[] result = new long[101];
        for (int i = 1; i < result.length; i++) {
            if (i < 3) {
                result[i] = 1;
            } else {
                result[i] = result[i - 2] + result[i - 3];
            }
        }

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            System.out.println(result[n]);
        }
    }
}
