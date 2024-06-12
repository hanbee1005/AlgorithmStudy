package dynamicprogramming;

public class UniquePathsII_63 {
    public static void main(String[] args) {
        System.out.println(uniquePathsWithObstacles(new int[][]{{0,0,0},{0,1,0},{0,0,0}}));
        System.out.println(uniquePathsWithObstacles(new int[][]{{0,1},{0,0}}));
    }

    private static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] dp = new int[obstacleGrid.length + 1][obstacleGrid[0].length + 1];
        dp[0][1] = 1;

        for (int m = 1; m <= obstacleGrid.length; m++) {
            for (int n = 1; n <= obstacleGrid[m - 1].length; n++) {
                if (obstacleGrid[m - 1][n - 1] == 1) continue;
                dp[m][n] = dp[m - 1][n] + dp[m][n - 1];
            }
        }

        return dp[obstacleGrid.length][obstacleGrid[0].length];
    }
}
