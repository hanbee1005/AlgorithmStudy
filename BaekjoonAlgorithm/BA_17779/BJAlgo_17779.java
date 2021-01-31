import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJAlgo_17779 {
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};

    private static int n;
    private static int[][] city;

    private static int[] population;
    private static boolean[][] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        city = new int[n + 1][n + 1];

        StringTokenizer st;
        for (int i = 1; i < n + 1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < n + 1; j++) {
                city[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result = 40000;

        for (int x = 1; x < n + 1; x++) {
            for (int y = 1; y < n + 1; y++) {
                for (int d1 = 1; d1 < y; d1++) {
                    for (int d2 = 1; d2 < n - y + 1; d2++) {
                        if (((x + d1 + d2) > x && (x + d1 + d2) <= n) && ((y - d1) >= 1 && (y - d1) < y && (y + d2) > y && (y + d2) <= n)) {
                            population = new int[5];
                            visited = new boolean[n + 1][n + 1];

                            makeBoundary(x, y, d1, 1);
                            makeBoundary(x, y, d2, 2);
                            makeBoundary(x + d1, y - d1, d2, 3);
                            makeBoundary(x + d2, y + d2, d1, 4);

                            dfs(1, 1, 1, 1, x + d1, y + 1, 0);
                            dfs(1, n, 1, y + 1, x + d2 + 1, n + 1, 1);
                            dfs(n, 1, x + d1, 1, n + 1, y - d1 + d2, 2);
                            dfs(n, n, x + d2, y - d1 + d2, n + 1, n + 1, 3);

                            inBoundaryPopulation();

                            Arrays.sort(population);
                            result = Math.min(result, (population[population.length - 1] - population[0]));
                        }
                    }
                }
            }
        }

        System.out.println(result);
    }

    private static void makeBoundary(int x, int y, int d, int t) {
        if (t == 1 || t == 4) {
            for (int i = 0; i < d + 1; i++) {
                if (!visited[x + i][y - i]) {
                    visited[x + i][y - i] = true;
                    population[4] += city[x + i][y - i];
                }
            }
        } else {
            for (int i = 0; i < d + 1; i++) {
                if (!visited[x + i][y + i]) {
                    visited[x + i][y + i] = true;
                    population[4] += city[x + i][y + i];
                }
            }
        }
    }

    private static void dfs(int x, int y, int minR, int minC, int maxR, int maxC, int num) {
        visited[x][y] = true;
        population[num] += city[x][y];

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= minR && nx < maxR && ny >= minC && ny < maxC) {
                if (!visited[nx][ny]) {
                    dfs(nx, ny, minR, minC, maxR, maxC, num);
                }
            }
        }
    }

    private static void inBoundaryPopulation() {
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (!visited[i][j]) {
                    population[4] += city[i][j];
                }
            }
        }
    }
}
