import java.io.*;

public class BJAlgo_2748 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        long[] cache = new long[N + 1];
        cache[0] = 0;

        if (N >= 1) {
            cache[1] = 1;
        }

        if (N > 1) {
            for (int i = 2; i < N + 1; i++) {
                cache[i] = cache[i - 1] + cache[i - 2];
            }
        }

        System.out.println(cache[N]);
    }
}
