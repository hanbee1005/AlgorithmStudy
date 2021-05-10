import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class BJ15664 {
    private static Set<String> answer = new HashSet<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        int[] nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(nums);

        combination(nums, new boolean[n], n, m, 0);
    }

    private static void combination(int[] nums, boolean[] selected, int n, int m, int start) {
        if (m == 0) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < selected.length; i++) {
                if (selected[i]) {
                    sb.append(nums[i]).append(" ");
                }
            }

            if (!answer.contains(sb.toString())) {
                answer.add(sb.toString());
                System.out.println(sb);
            }

            return;
        }

        for (int i = start; i < n; i++) {
            selected[i] = true;
            combination(nums, selected, n, m - 1, i + 1);
            selected[i] = false;
        }
    }
}
