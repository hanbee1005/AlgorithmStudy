package graph;

import java.util.Stack;

public class CountSubIslands_1905 {
    public static void main(String[] args) {
        System.out.println(countSubIslands(new int[][]{{1,1,1,0,0},{0,1,1,1,1},{0,0,0,0,0},{1,0,0,0,0},{1,1,0,1,1}},
                new int[][]{{1,1,1,0,0},{0,0,1,1,1},{0,1,0,0,0},{1,0,1,1,0},{0,1,0,1,0}}));
        System.out.println(countSubIslands(new int[][]{{1,0,1,0,1},{1,1,1,1,1},{0,0,0,0,0},{1,1,1,1,1},{1,0,1,0,1}},
                new int[][]{{0,0,0,0,0},{1,1,1,1,1},{0,1,0,1,0},{0,1,0,1,0},{1,0,0,0,1}}));
    }

    private static int countSubIslands(int[][] grid1, int[][] grid2) {
        int answer = 0;

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        boolean[][] visited = new boolean[grid2.length][grid2[0].length];
        for (int i = 0; i < grid2.length; i++) {
            for (int j = 0; j < grid2[i].length; j++) {
                if (grid2[i][j] == 0 || visited[i][j]) {
                    continue;
                }

                if (grid1[i][j] == 0) {
                    continue;
                }

                boolean isNotContain = false;

                Stack<int[]> stack = new Stack<>();
                stack.push(new int[]{i, j});
                visited[i][j] = true;
                while (!stack.isEmpty()) {
                    int[] cur = stack.pop();
                    int x = cur[0], y = cur[1];

                    for (int d = 0; d < 4; d++) {
                        int nx = x + dx[d];
                        int ny = y + dy[d];

                        if (nx >= 0 && nx < grid2.length && ny >= 0 && ny < grid2[i].length) {
                            if (grid2[nx][ny] == 1 && !visited[nx][ny]) {
                                if (grid1[nx][ny] == 0) {
                                    isNotContain = true;
                                }

                                stack.push(new int[]{nx, ny});
                                visited[nx][ny] = true;
                            }
                        }
                    }
                }

                if (!isNotContain) answer++;
            }
        }

        return answer;
    }
}
