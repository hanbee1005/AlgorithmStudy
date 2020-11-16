import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BJAlgo_6603 {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            sb.setLength(0);
            int[] inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            if (inputs.length == 1 && inputs[0] == 0) {
                break;
            }

            int[] nums = new int[inputs.length - 1];
            System.arraycopy(inputs, 1, nums, 0, nums.length);

            lotto(nums, 0, nums.length - 5, new ArrayList());

            System.out.println(sb);
        }
    }

    private static void lotto(int[] nums, int start, int end,  ArrayList<Integer> selected) {
        if (selected.size() == 6) {
            for (int i = 0; i < 5; i++) {
                sb.append(selected.get(i)).append(" ");
            }
            sb.append(selected.get(5)).append("\n");
            return;
        }

        for (int i = start; i < end; i++) {
            if (i < nums.length) {
                selected.add(nums[i]);
                lotto(nums, i + 1, i + (nums.length - 5) + 1, selected);
                selected.remove(selected.size() - 1);
            }
        }
    }
}
