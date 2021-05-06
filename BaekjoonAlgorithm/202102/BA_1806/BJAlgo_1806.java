import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BJAlgo_1806 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        int[] nums = new int[100000];
        int[] tmp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        for (int i = 0; i < n; i++) {
            nums[i] = tmp[i];
        }

        int low = 0, high = 0;
        int sum = nums[0];
        int result = 100001;

        while (low <= high && high < n) {
            if (sum < s) {
                sum += nums[++high];
            } else if (sum == s) {
                result = Math.min(result, high - low + 1);
                sum += nums[++high];
            } else if (sum > s) {
                result = Math.min(result, high - low + 1);
                sum -= nums[low++];
            }
        }

        if (result == 100001) {
            result = 0;
        }

        System.out.println(result);
    }
}
