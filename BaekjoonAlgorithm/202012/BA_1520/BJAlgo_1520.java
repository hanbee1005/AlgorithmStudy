import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJAlgo_1520 {

    private static int m;
    private static int n;

    private static int[][] height;
    private static int[][] visited;

    private static int[] dx = {1, -1, 0, 0};
    private static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        height = new int[m][n];
        for (int i = 0; i < m; i++) {
            height[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        visited = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(visited[i], -1);
        }

        System.out.println(dfs(0, 0));
    }

    private static int dfs(int x, int y) {
        if (x == m - 1 && y == n - 1) {
            return 1;
        }

        if (visited[x][y] != -1) {
            return visited[x][y];
        }

        visited[x][y] = 0;
        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if (nextX >= 0 && nextX < m && nextY >= 0 && nextY < n) {
                if (height[x][y] > height[nextX][nextY]) {
                    visited[x][y] += dfs(nextX, nextY);
                }
            }
        }
        return visited[x][y];
    }
}
