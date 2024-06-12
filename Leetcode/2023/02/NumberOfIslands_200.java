package graph;

public class NumberOfIslands_200 {
    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, -1, 0, 1};
    private static boolean[][] visited;

    public static void main(String[] args) {
        System.out.println(numIslands(new char[][]{{'1','1','1','1','0'}, {'1','1','0','1','0'}, {'1','1','0','0','0'}, {'0','0','0','0','0'}}));
        System.out.println(numIslands(new char[][]{{'1','1','0','0','0'}, {'1','1','0','0','0'}, {'0','0','1','0','0'}, {'0','0','0','1','1'}}));
    }

    private static int numIslands(char[][] grid) {
        int count = 0;
        visited = new boolean[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    dfs(i, j, grid);
                    count++;
                }
            }
        }

        return count;
    }

    private static void dfs(int x, int y, char[][] grid) {
        visited[x][y] = true;

        for (int d = 0; d < 4; d++) {
            int cx = x + dx[d];
            int cy = y + dy[d];

            if (cx >= 0 && cx < grid.length && cy >= 0 && cy < grid[0].length) {
                if (grid[cx][cy] == '1' && !visited[cx][cy]) {
                    dfs(cx, cy, grid);
                }
            }
        }
    }
}
