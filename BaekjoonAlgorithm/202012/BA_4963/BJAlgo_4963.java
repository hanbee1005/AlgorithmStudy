import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJAlgo_4963 {

    private static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    private static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

    private static int w;
    private static int h;

    private static int[][] island;
    private static boolean[][] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());

            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            if (w == 0 && h == 0) {
                break;
            }

            island = new int[h][w];
            for (int i = 0; i < h; i++) {
                island[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            }

            visited = new boolean[h][w];
            int count = 0;

            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (island[i][j] == 1 && !visited[i][j]) {
                        dfs(i, j);
                        count += 1;
                    }
                }
            }

            System.out.println(count);
        }
    }

    private static void dfs(int x, int y) {
        visited[x][y] = true;

        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < h && ny >= 0 && ny < w) {
                if (island[nx][ny] == 1 && !visited[nx][ny]) {
                    dfs(nx, ny);
                }
            }
        }
    }
}
