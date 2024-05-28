package May2024;

/**
 * Level 3. 보행자 천국
 */
public class APedestrianParadise {
    private static int MOD = 20170805;
    public static void main(String[] args) {
        System.out.println(solution(3, 3, new int[][]{{0, 0, 0}, {0, 0, 0}, {0, 0, 0}}));
        System.out.println(solution(3, 6, new int[][]{{0, 2, 0, 0, 0, 2}, {0, 0, 2, 0, 1, 0}, {1, 0, 0, 2, 2, 0}}));
    }

    private static int solution(int m, int n, int[][] cityMap) {
        int answer = 0;

        int[][][] paths = new int[m][n][2];
        for (int x = 1; x < m; x++) {
            if (cityMap[x][0] == 1) break;
            paths[x][0][1] = 1;
        }
        for (int y = 1; y < n; y++) {
            if (cityMap[0][y] == 1) break;
            paths[0][y][0] = 1;
        }

        for (int x = 1; x < m; x++) {
            for (int y = 1; y < n; y++) {
                if (cityMap[x][y-1] == 0) paths[x][y][0] = (paths[x][y-1][0] + paths[x][y-1][1]) %MOD;
                else if (cityMap[x][y-1] == 2) paths[x][y][0] = paths[x][y-1][0] % MOD;

                if (cityMap[x-1][y] == 0) paths[x][y][1] = (paths[x-1][y][0] + paths[x-1][y][1]) % MOD;
                else if (cityMap[x-1][y] == 2) paths[x][y][1] = paths[x-1][y][1] % MOD;
            }
        }

        return (paths[m-1][n-1][0] + paths[m-1][n-1][1]) % MOD;
    }
}

