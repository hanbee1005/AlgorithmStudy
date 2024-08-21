package search;

public class StoneGameII_1140 {
    private static int[] s;
    private static Integer[][] f;
    private static int n;

    public static void main(String[] args) {
        System.out.println(stoneGameII(new int[]{2,7,9,4,4}));
        System.out.println(stoneGameII(new int[]{1,2,3,4,5,100}));
    }

    private static int stoneGameII(int[] piles) {
        n = piles.length;
        s = new int[n + 1];
        f = new Integer[n][n + 1];
        for (int i = 0; i < n; ++i) {
            s[i + 1] = s[i] + piles[i];
        }
        return dfs(0, 1);
    }

    private static int dfs ( int i, int m){
        if (m * 2 >= n - i) {
            return s[n] - s[i];
        }

        if (f[i][m] != null) {
            return f[i][m];
        }

        int res = 0;
        for (int x = 1; x <= m * 2; ++x) {
            res = Math.max(res, s[n] - s[i] - dfs(i + x, Math.max(m, x)));
        }

        return f[i][m] = res;
    }
}
