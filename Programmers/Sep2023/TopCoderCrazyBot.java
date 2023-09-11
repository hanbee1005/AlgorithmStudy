package Sep2023;

/**
 * Top Coder Crazy Bot SRM425 Div 2 Level 2
 */
public class TopCoderCrazyBot {
    private static final int[] dx = {-1, 0, 1, 0};
    private static final int[] dy = {0, 1, 0, -1};

    private static final boolean[][] visited = new boolean[100][100];
    private static final double[] directionRate = new double[4];

    public static void main(String[] args) {
        System.out.println(getProbability(2, 25, 25, 25, 25));
    }

    private static double getProbability(int n, int east, int west, int south, int north) {
        directionRate[0] = north / 100.0;
        directionRate[1] = east / 100.0;
        directionRate[2] = south / 100.0;
        directionRate[3] = west / 100.0;

        return dfs(n, 50, 50);
    }

    private static double dfs(int n, int cx, int cy) {
        if (visited[cx][cy]) return 0;
        if (n == 0) return 1;

        visited[cx][cy] = true;

        double answer = 0.0;
        for (int i = 0; i < 4; i++) {
            answer += dfs(n - 1, cx + dx[i], cy + dy[i]) * directionRate[i];
        }

        visited[cx][cy] = false;

        return answer;
    }
}
