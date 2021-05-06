import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ15654 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        int[] nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(nums);

        permutation(nums, new int[n], new boolean[n], n, m, 0);
    }

    private static void permutation(int[] nums, int[] selected, boolean[] isSelect, int n, int m, int depth) {
        if (depth == m) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < depth; i++) {
                sb.append(selected[i]).append(" ");
            }

            System.out.println(sb);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!isSelect[i]) {
                isSelect[i] = true;
                selected[depth] = nums[i];
                permutation(nums, selected, isSelect, n, m, depth + 1);
                isSelect[i] = false;
            }
        }
    }
}
