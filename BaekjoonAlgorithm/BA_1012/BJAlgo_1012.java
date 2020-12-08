import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJAlgo_1012 {
    private static int[][] array;
    private static boolean[][] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int[] nmk = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            array = new int[nmk[0]][nmk[1]];
            visited = new boolean[nmk[0]][nmk[1]];
            for (int j = 0; j < nmk[2]; j++) {
                int[] xy = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                array[xy[0]][xy[1]] = 1;
            }
            int result = 0;
            for (int n = 0; n < nmk[0]; n++) {
                for (int m = 0; m < nmk[1]; m++) {
                    if (array[n][m] == 1 && !visited[n][m]) {
                        dfs(n, m);
                        result += 1;
                    }
                }
            }

            System.out.println(result);
        }
    }

    private static void dfs(int now_x, int now_y) {
        visited[now_x][now_y] = true;
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for (int i = 0; i < directions.length; i++) {
            int next_x = now_x + directions[i][0];
            int next_y = now_y + directions[i][1];
            if (next_x < 0 || next_x >= array.length || next_y < 0 || next_y >= array[0].length) {
                continue;
            }
            if (array[next_x][next_y] == 1 && !visited[next_x][next_y]) {
                dfs(next_x, next_y);
            }
        }
    }
}
