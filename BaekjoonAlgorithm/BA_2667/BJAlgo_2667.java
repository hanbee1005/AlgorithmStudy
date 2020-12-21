import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class BJAlgo_2667 {

    private static int n;
    private static int[][] apartments;
    private static int[][] visited;

    private static int[] dx = {1, -1, 0, 0};
    private static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());
        apartments = new int[n][n];
        for (int i = 0; i < n; i++) {
            apartments[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        }

        visited = new int[n][n];
        int count = 0;
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (apartments[i][j] != 0 && visited[i][j] == 0) {
                    result.add(dfs(i, j));
                    count++;
                }
            }
        }

        Collections.sort(result);
        for (int r : result) {
            sb.append(r).append("\n");
        }

        System.out.println(count + "\n" + sb);
    }

    private static int dfs(int x, int y) {
        visited[x][y] = 1;
        for (int i = 0; i < 4; i++) {
            int next_x = x + dx[i];
            int next_y = y + dy[i];

            if (next_x >= 0 && next_x < n && next_y >= 0 && next_y < n) {
                if (visited[next_x][next_y] == 0 && apartments[next_x][next_y] != 0) {
                    visited[x][y] += dfs(next_x, next_y);
                }
            }
        }
        return visited[x][y];
    }
}
