package Dec;

import java.util.ArrayList;
import java.util.List;

public class Fatigue {
    private static List<int[][]> matrix;
    public static void main(String[] args) {
        System.out.println(solution(80, new int[][]{{80,20},{50,40},{30,10}}));
    }

    public static int solution(int k, int[][] dungeons) {
        int answer = 0;
        matrix = new ArrayList<>();

        permutation(dungeons, new int[dungeons.length][2], new boolean[dungeons.length], 0, dungeons.length, dungeons.length);

        for (int[][] m : matrix) {
            int cnt = 0;
            int num = k;
            for (int[] d : m) {
                if (num >= d[0]) {
                    num -= d[1];
                    cnt++;
                }
            }

            answer = Math.max(answer, cnt);

            if (answer == dungeons.length) {
                break;
            }
        }

        return answer;
    }

    private static void permutation(int[][] dungeous, int[][] output, boolean[] visited, int depth, int n, int r) {
        if (depth == r) {
            int[][] tmp = new int[output.length][2];
            for (int i = 0; i < tmp.length; i++) {
                System.arraycopy(output[i], 0, tmp[i], 0, 2);
            }
            matrix.add(tmp);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                output[depth] = dungeous[i];
                permutation(dungeous, output, visited, depth + 1, n, r);
                visited[i] = false;
            }
        }
    }
}
