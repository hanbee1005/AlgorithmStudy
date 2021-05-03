import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ15651 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        System.out.println(permutation(new int[n], n, m, 0));
    }

    private static StringBuilder permutation(int[] nums, int n, int m, int depth) {
        StringBuilder sb = new StringBuilder();

        if (depth == m) {
            for (int i = 0; i < depth; i++) {
                sb.append(nums[i]).append(" ");
            }
            return sb.append("\n");
        }

        for (int i = 0; i < n; i++) {
            nums[depth] = i + 1;
            sb.append(permutation(nums, n, m, depth + 1));
        }

        return sb;
    }
}
