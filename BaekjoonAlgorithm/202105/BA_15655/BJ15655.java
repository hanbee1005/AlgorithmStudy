import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ15655 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        int[] nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(nums);

        combination(nums, new boolean[n], n, m, 0, 0);
    }

    private static void combination(int[] nums, boolean[] selected, int n, int m, int start, int k) {
        if (k == m) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                if (selected[i]) {
                    sb.append(nums[i]).append(" ");
                }
            }
            System.out.println(sb);
            return;
        }

        for (int i = start; i < n; i++) {
            selected[i] = true;
            combination(nums, selected, n, m, i + 1, k + 1);
            selected[i] = false;
        }
    }
}
