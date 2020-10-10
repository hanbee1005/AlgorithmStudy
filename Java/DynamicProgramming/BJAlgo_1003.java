import java.io.*;

public class BJAlgo_1003 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            int[] cache_zero = new int[N + 1];
            int[] cache_one = new int[N + 1];

            cache_zero[0] = 1;
            cache_one[0] = 0;

            if (N >= 1) {
                cache_zero[1] = 0;
                cache_one[1] = 1;
            }

            if (N > 1) {
                for (int j = 2; j < N + 1; j++) {
                    cache_zero[j] = cache_zero[j - 1] + cache_zero[j - 2];
                    cache_one[j] = cache_one[j - 1] + cache_one[j - 2];
                }
            }

            System.out.println(cache_zero[N] + " " + cache_one[N]);
        }
    }
}
