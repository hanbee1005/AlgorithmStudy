import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ15656 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        int[] nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(nums);

        System.out.println(permutation(nums, new int[n], n, m, 0));
    }

    public static StringBuilder permutation(int[] nums, int[] selected, int n, int m, int depth) {
        StringBuilder sb = new StringBuilder();

        if (depth == m) {
            for (int i = 0; i < depth; i++) {
                sb.append(selected[i]).append(" ");
            }

            return sb.append("\n");
        }

        for (int i = 0; i < n; i++) {
            selected[depth] = nums[i];
            sb.append(permutation(nums, selected, n, m, depth + 1));
        }

        return sb;
    }
}
