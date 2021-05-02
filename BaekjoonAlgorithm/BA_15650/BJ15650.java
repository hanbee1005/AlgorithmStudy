import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ15650 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        combination(new boolean[n], 0, m);
    }

    private static void combination(boolean[] selected, int r, int k) {
        if (k == 0) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < selected.length; i++) {
                if (selected[i]) {
                    sb.append(i + 1).append(" ");
                }
            }
            System.out.println(sb);
            return;
        }

        for (int i = r; i < selected.length; i++) {
            selected[i] = true;
            combination(selected, i + 1, k - 1);
            selected[i] = false;
        }
    }
}
