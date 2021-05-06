import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ15652 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        combination(new int[n], n, m, 0, 0);
    }

    private static void combination(int[] nums, int n, int m, int start, int k) {
        if (k == m) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < k; i++) {
                sb.append(nums[i]).append(" ");
            }
            System.out.println(sb);
            return;
        }

        for (int i = start; i < n; i++) {
            nums[k] = i + 1;
            combination(nums, n, m, i,k + 1);
        }
    }
}
