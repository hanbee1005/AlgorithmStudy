import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ1978 {
    public static void main(String[] args) throws Exception {
         boolean[] nums = new boolean[1001];
        Arrays.fill(nums, true);
        nums[0] = false; nums[1] = false;

         for (int i = 2; i < nums.length - 1; i++) {
             for (int j = i + 1; j < nums.length; j++) {
                 if (nums[j]) {
                     nums[j] = j % i != 0;
                 }
             }
         }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         int t = Integer.parseInt(br.readLine());
         int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

         int answer = 0;
         for (int i = 0; i < t; i++) {
             if (nums[input[i]]) {
                 answer++;
             }
         }

         System.out.println(answer);
    }
}
