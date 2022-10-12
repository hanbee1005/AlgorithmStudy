package Oct2022;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q11050 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long N = Long.parseLong(st.nextToken());
        long K = Long.parseLong(st.nextToken());

        System.out.println(factorial(N) / (factorial(K) * factorial(N - K)));
    }

    private static long factorial(long n) {
        if (n <= 1) {
            return 1;
        }

        return factorial(n - 1) * n;
    }
}
