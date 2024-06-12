package graph;

import java.util.LinkedList;
import java.util.Queue;

public class MaxAreaOfIsland_695 {
    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, -1, 0, 1};

    private static boolean[][] visited;

    public static void main(String[] args) {
        System.out.println(maxAreaOfIsland(
                new int[][]{
                        {0,0,1,0,0,0,0,1,0,0,0,0,0},
                        {0,0,0,0,0,0,0,1,1,1,0,0,0},
                        {0,1,1,0,1,0,0,0,0,0,0,0,0},
                        {0,1,0,0,1,1,0,0,1,0,1,0,0},
                        {0,1,0,0,1,1,0,0,1,1,1,0,0},
                        {0,0,0,0,0,0,0,0,0,0,1,0,0},
                        {0,0,0,0,0,0,0,1,1,1,0,0,0},
                        {0,0,0,0,0,0,0,1,1,0,0,0,0}
                }));

        System.out.println(maxAreaOfIsland(new int[][]{{0,0,0,0,0,0,0,0}}));
        System.out.println(maxAreaOfIsland(new int[][]{{1,1,0,0,0}, {1,1,0,0,0}, {0,0,0,1,1}, {0,0,0,1,1}}));
    }

    private static int maxAreaOfIsland(int[][] grid) {
        visited = new boolean[grid.length][grid[0].length];
        int maxArea = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] != 0 && !visited[i][j]) {
                    maxArea = Math.max(bfs(i, j, grid), maxArea);
                }
            }
        }

        return maxArea;
    }

    private static int bfs(int x, int y, int[][] grid) {
        int area = 0;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});

        visited[x][y] = true;
        area++;

        while(!queue.isEmpty()) {
            int[] cxy = queue.poll();
            int cx = cxy[0], cy = cxy[1];

            for (int d = 0; d < 4; d++) {
                int nx = cx + dx[d];
                int ny = cy + dy[d];

                if (nx >= 0 && nx < grid.length && ny >= 0 && ny < grid[0].length) {
                    if (grid[nx][ny] != 0 && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        area++;
                        queue.offer(new int[]{nx, ny});
                    }
                }
            }
        }

        return area;
    }
}
