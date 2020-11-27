import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJAlgo_1904 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] result = new int[n + 1];
        result[0] = 1;
        result[1] = 1;
        for (int i = 2; i < result.length; i++) {
            result[i] = (result[i - 1] + result[i - 2]) % 15746;
        }

        System.out.println(result[n]);
    }
}
