package Apr2024;

/**
 * Level 3. 등굣길 (Dynamic Programming)
 */
public class WayToSchool {
    public static void main(String[] args) {
        System.out.println(solution(4, 3, new int[][]{{2, 2}}));
    }

    private static int solution(int m, int n, int[][] puddles) {
        int[][] land = new int[n][m];
        for (int[] puddle : puddles) {
            land[puddle[1] - 1][puddle[0] - 1] = -1;
        }

        int[] dx = {0, 1};
        int[] dy = {1, 0};

        for (int x = n - 1; x >= 0; x--) {
            for (int y = m - 1; y >= 0; y--) {
                if (land[x][y] == -1) {
                    continue;
                }

                if (x == n - 1 && y == m - 1) {
                    land[x][y] = 1;
                    continue;
                }

                for (int d = 0; d < 2; d++) {
                    int bx = x + dx[d];
                    int by = y + dy[d];

                    if (bx < n && by < m) {
                        if (land[bx][by] != -1) {
                            land[x][y] += land[bx][by];
                        }
                    }
                }

                land[x][y] %= 1000000007;
            }
        }

        return land[0][0];
    }
}
