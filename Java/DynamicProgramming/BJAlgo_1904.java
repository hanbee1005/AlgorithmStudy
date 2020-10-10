import java.io.*;

public class BJAlgo_1904 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] cache = new int[N + 1];
        cache[0] = 1;
        cache[1] = 1;

        if (N > 1) {
            for (int i = 2; i < N + 1; i++) {
                cache[i] = (cache[i - 1] + cache[i - 2]) % 15746;
            }
        }

        System.out.println(cache[N]);
    }
}
