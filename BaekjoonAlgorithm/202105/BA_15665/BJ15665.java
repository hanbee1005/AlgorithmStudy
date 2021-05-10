import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class BJ15665 {
    private static Set<String> answer = new HashSet<>();
    private static StringBuilder answerStr = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        int[] nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(nums);

        permutation(nums, new int[n], n, m, 0);
        System.out.println(answerStr);
    }

    public static void permutation(int[] nums, int[] selected, int n, int m, int depth) {
        if (depth == m) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < depth; i++) {
                sb.append(selected[i]).append(" ");
            }

            if (!answer.contains(sb.toString())) {
                answer.add(sb.toString());
                answerStr.append(sb).append("\n");
            }

            return;
        }

        for (int i = 0; i < n; i++) {
            selected[depth] = nums[i];
            permutation(nums, selected, n, m, depth + 1);
        }
    }
}
