package Sep2023;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Top Coder MazeMaker SRM453.5 Div 2 Level 2
 */
public class TopCoderMazeMaker {
    public static void main(String[] args) {
        System.out.println(longestPath(new String[]{"...", "...", "..."}, 0, 1, new int[]{1, 0, -1, 0}, new int[]{0, 1, 0, -1}));
        System.out.println(longestPath(new String[]{"...", "...", "..."}, 0, 1, new int[]{1, 0, -1, 0, 1, 1, -1, -1}, new int[]{0, 1, 0, -1, 1, -1, 1, -1}));
        System.out.println(longestPath(new String[]{"X.X", "...", "XXX", "X.X"}, 0, 1, new int[]{1, 0, -1, 0}, new int[]{0, 1, 0, -1}));
        System.out.println(longestPath(new String[]{".......", "X.X.X..", "XXX...X", "....X..", "X....X.", "......."}, 5, 0, new int[]{1, 0, -1, 0, -2, 1}, new int[]{0, -1, 0, 1, 3, 0}));
    }

    private static int longestPath(String[] maze, int startRow, int startCol, int[] moveRow, int[] moveCol) {
        int answer = -1;

        Queue<int[]> move = new LinkedList<>();
        move.offer(new int[]{startRow, startCol});

        int[][] visited = new int[maze.length][maze[0].length()];
        for (int[] v : visited) {
            Arrays.fill(v, -1);
        }
        visited[startRow][startCol] = 0;

        while (!move.isEmpty()) {
            int[] cur = move.poll();

            for (int i = 0; i < moveRow.length; i++) {
                int nx = cur[0] + moveRow[i];
                int ny = cur[1] + moveCol[i];

                if (nx >= 0 && nx < maze.length && ny >= 0 && ny < maze[0].length()) {
                    if (maze[nx].charAt(ny) == '.' && visited[nx][ny] == -1) {
                        visited[nx][ny] = visited[cur[0]][cur[1]] + 1;
                        move.offer(new int[]{nx, ny});
                    }
                }
            }
        }

        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length(); j++) {
                if (i == 0 || i == maze.length - 1 || j == 0 || j == maze[i].length()) {
                    if (maze[i].charAt(j) == '.' && visited[i][j] == -1) return -1;
                    answer = Math.max(answer, visited[i][j]);
                }
            }
        }

        return answer;
    }
}
