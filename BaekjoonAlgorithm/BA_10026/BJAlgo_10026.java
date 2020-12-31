import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BJAlgo_10026 {
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};

    private static int n;
    private static String[] grid;

    private static boolean[][] visited;
    private static boolean[][] blindness_visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        grid = new String[n];
        for (int i = 0; i < n; i++) {
            grid[i] = br.readLine();
        }

        visited = new boolean[n][n];
        blindness_visited = new boolean[n][n];

        int[] count = new int[2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    dfs(i, j);
                    count[0] += 1;
                }

                if (!blindness_visited[i][j]) {
                    blindness_dfs(i, j);
                    count[1] += 1;
                }
            }
        }

        System.out.println(count[0] + " " + count[1]);
    }

    private static void dfs(int x, int y) {
        ArrayList<int[]> need_visit = new ArrayList<>();
        need_visit.add(new int[]{x, y});
        visited[x][y] = true;

        while (!need_visit.isEmpty()) {
            int[] current = need_visit.remove(need_visit.size() - 1);

            for (int i = 0; i < 4; i++) {
                int nx = current[0] + dx[i];
                int ny = current[1] + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                    if (grid[current[0]].charAt(current[1]) == grid[nx].charAt(ny) && !visited[nx][ny]) {
                        need_visit.add(new int[]{nx, ny});
                        visited[nx][ny] = true;
                    }
                }
            }
        }
    }

    private static void blindness_dfs(int x, int y) {
        ArrayList<int[]> need_visit = new ArrayList<>();
        need_visit.add(new int[]{x, y});
        blindness_visited[x][y] = true;

        while (!need_visit.isEmpty()) {
            int[] current = need_visit.remove(need_visit.size() - 1);

            for (int i = 0; i < 4; i++) {
                int nx = current[0] + dx[i];
                int ny = current[1] + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                    if ((grid[current[0]].charAt(current[1]) == grid[nx].charAt(ny)
                            || (grid[current[0]].charAt(current[1]) == 'R' && grid[nx].charAt(ny) == 'G')
                            || (grid[current[0]].charAt(current[1]) == 'G' && grid[nx].charAt(ny) == 'R'))
                            && !blindness_visited[nx][ny]) {
                        need_visit.add(new int[]{nx, ny});
                        blindness_visited[nx][ny] = true;
                    }
                }
            }
        }
    }
}
