package Oct2023;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Level 2. 리코쳇 로봇
 */
public class RicochetRobot {
    private static final int[] dx = {-1, 0, 1, 0};
    private static final int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) {
        System.out.println(solution(new String[]{"...D..R", ".D.G...", "....D.D", "D....D.", "..D...."}));
        System.out.println(solution(new String[]{".D.R", "....", ".G..", "...D"}));
    }

    private static int solution(String[] board) {
        int answer = -1;

        int[] start = new int[3];

        for (int i = 0; i < board.length; i++) {
            if (board[i].contains("R")) {
                start[0] = i;
                start[1] = board[i].indexOf("R");
            }
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.add(start);

        boolean[][] visited = new boolean[board.length][board[0].length()];
        visited[start[0]][start[1]] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            if (board[cur[0]].charAt(cur[1]) == 'G') {
                return cur[2];
            }

            for (int i = 0; i < 4; i++) {
                int[] next = findNextPosition(cur, i, board);
                if (!visited[next[0]][next[1]]) {
                    visited[next[0]][next[1]] = true;
                    queue.add(next);
                }
            }
        }

        return answer;
    }

    private static int[] findNextPosition(int[] cur, int d, String[] board) {
        int cx = cur[0];
        int cy = cur[1];

        while (true) {
            int nx = cx + dx[d];
            int ny = cy + dy[d];

            if ((nx < 0 || nx >= board.length || ny < 0 || ny >= board[0].length()) || board[nx].charAt(ny) == 'D') {
                return new int[]{cx, cy, cur[2] + 1};
            }

            cx = nx;
            cy = ny;
        }
    }
}
