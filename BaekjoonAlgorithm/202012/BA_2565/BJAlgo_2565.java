import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class BJAlgo_2565 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] pos = new int[n][2];

        for (int i = 0; i < n; i++) {
            pos[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        Arrays.sort(pos, Comparator.comparing(p1 -> p1[0]));

        int[] result = new int[n];
        Arrays.fill(result, 1);

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (pos[i][1] > pos[j][1]) {
                    result[i] = Math.max(result[i], result[j] + 1);
                }
            }
        }

        Arrays.sort(result);
        System.out.println(n - result[result.length - 1]);
    }
}
