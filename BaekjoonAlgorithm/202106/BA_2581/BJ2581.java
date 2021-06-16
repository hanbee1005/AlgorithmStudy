import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ2581 {
    public static void main(String[] args) throws Exception {
        boolean[] primeNum = new boolean[10001];
        Arrays.fill(primeNum, true);
        primeNum[0] = false; primeNum[1] = false;

        for (int i = 2; i < primeNum.length - 1; i++) {
            for (int j = i + 1; j < primeNum.length; j++) {
                if (primeNum[j]) {
                    primeNum[j] = j % i != 0;
                }
            }
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int minPrimeNum = -1;
        int sum = 0;

        for (int i = n; i < m + 1; i++) {
            if (primeNum[i]) {
                if (minPrimeNum == -1) {
                    minPrimeNum = i;
                }

                sum += i;
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(minPrimeNum);

        if (sum != 0) {
            sb.insert(0, sum + "\n");
        }

        System.out.println(sb);
    }
}
