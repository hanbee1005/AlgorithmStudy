import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class BJAlgo_1920 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());

        int m = Integer.parseInt(br.readLine());
        int[] finds = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for (int num : finds) {
            if (set.contains(num)) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
    }
}
