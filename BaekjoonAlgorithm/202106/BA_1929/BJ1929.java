import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ1929 {
    public static void main(String[] args) throws IOException {
        boolean[] primeNum = new boolean[1000001];
        Arrays.fill(primeNum, true);
        primeNum[0] = false; primeNum[1] = false;

        for (int i = 2; i * i < primeNum.length; i++) {
            for(int j = i * i; j < primeNum.length; j+=i) {
                primeNum[j] = false;
            }
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int m = Integer.parseInt(input[0]);
        int n = Integer.parseInt(input[1]);

        StringBuilder sb = new StringBuilder();
        for (int i = m; i < n + 1; i++) {
            if (primeNum[i]) {
                sb.append(i).append("\n");
            }
        }

        System.out.print(sb);
    }
}
