import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ4948 {
    public static void main(String[] args) throws IOException {
        boolean[] primeNum = new boolean[(123456 * 2) + 1];
        Arrays.fill(primeNum, true);
        primeNum[0] = primeNum[1] = false;

        for (int i = 2; i * i < primeNum.length; i++) {
            for (int j = i * i; j < primeNum.length; j += i) {
                primeNum[j] = false;
            }
        }

        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            int n = Integer.parseInt(br.readLine());

            if (n == 0) {
                break;
            }

            int count = 0;
            for (int i = n + 1; i < (n * 2) + 1; i++) {
                if (primeNum[i]) {
                    count++;
                }
            }

            sb.append(count).append("\n");
        }

        System.out.print(sb);
    }
}
