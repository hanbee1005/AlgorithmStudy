import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJAlgo_9997 {
    static int n;
    static int[] words;
    static final int alphabet = (1 << 26) - 1;
    static int result = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        words = new int[n];
        for (int i = 0; i < n; i++) {
            String[] word = br.readLine().split("");
            for (String w : word) {
                words[i] |= 1 << w.charAt(0) - 'a';
            }
        }

        dfs(-1, 0);

        System.out.println(result);
    }

    private static void dfs(int count, int mask) {
        if (count == n - 1) {
            if (mask == alphabet) {
                result += 1;
            }
        } else {
            dfs(count + 1, mask | words[count + 1]);
            dfs(count + 1, mask);
        }
    }
}
