package Oct2022;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q2805 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] trees = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(trees);

        long min = 0;
        long mid = 0;
        long max = trees[trees.length - 1];

        while (min <= max) {
            mid = (min + max) / 2;

            long m = 0;
            for (int tree : trees) {
                m += tree - mid <= 0 ? 0 : tree - mid;
            }

            if (m < M) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }

        System.out.println(max);
    }
}
