import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ9020 {
    public static void main(String[] args) throws Exception {
        boolean[] primeNum = new boolean[10001];
        Arrays.fill(primeNum, true);
        primeNum[0] = primeNum[1] = false;

        for (int i = 2; i * i < primeNum.length; i++) {
            for (int j = i * i; j < primeNum.length; j+=i) {
                primeNum[j] = false;
            }
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());

            for (int k = n / 2; k >= 2; k--) {
                if (primeNum[k] && primeNum[n - k]) {
                    sb.append(k).append(" ").append(n - k).append("\n");
                    break;
                }
            }
        }

        System.out.print(sb);
    }
}
