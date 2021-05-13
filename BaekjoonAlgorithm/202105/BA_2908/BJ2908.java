import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ2908 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] nums = br.readLine().split(" ");
        StringBuilder sb = new StringBuilder(nums[0]);
        int a = Integer.parseInt(sb.reverse().toString());

        sb = new StringBuilder(nums[1]);
        int b = Integer.parseInt(sb.reverse().toString());

        System.out.println(Math.max(a, b));
    }
}
