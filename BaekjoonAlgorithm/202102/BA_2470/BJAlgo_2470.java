import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJAlgo_2470 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(nums);

        int low = 0, high = nums.length - 1;
        int[] result = new int[2];
        result[0] = nums[0];
        result[1] = nums[nums.length - 1];
        int sum = Math.abs(result[0] + result[1]);
        while (low < high) {
            int tmp = nums[low] + nums[high];
            if (sum > Math.abs(tmp)) {
                sum = Math.abs(tmp);
                result[0] = nums[low];
                result[1] = nums[high];
            }

            if (tmp >= 0) {
                high -= 1;
            } else {
                low += 1;
            }
        }

        System.out.println(result[0] + " " + result[1]);
    }
}
