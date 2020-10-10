import java.io.*;

public class BJAlgo_9461 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            long[] cache = new long[N + 1];
            cache[0] = 0;
            cache[1] = 1;

            if (N >= 2) {
                cache[2] = 1;
            }

            if (N > 2) {
                for (int j = 3; j < N + 1; j++) {
                    cache[j] = cache[j - 2] + cache[j - 3];
                }
            }

            System.out.println(cache[N]);
        }
    }
}
