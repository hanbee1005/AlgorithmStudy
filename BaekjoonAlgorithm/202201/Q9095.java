package Jan2022;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q9095 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < testCase; i++) {
            int num = Integer.parseInt(br.readLine());
            sb.append(dp(num)).append("\n");
        }

        System.out.print(sb);
    }

    private static int dp(int n) {
        if (n <= 3) {
            return n == 3 ? 4 : n == 2 ? 2 : n == 1 ? 1 : 0;
        }

        return dp(n - 1) + dp(n - 2) + dp(n - 3);
    }
}
