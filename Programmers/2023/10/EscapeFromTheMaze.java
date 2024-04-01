package Oct2023;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Level 2. 미로 탈출
 */
public class EscapeFromTheMaze {
    private static final int[] dx = {-1, 0, 1, 0};
    private static final int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) {
        System.out.println(solution(new String[]{"SOOOL","XXXXO","OOOOO","OXXXX","OOOOE"}));
        System.out.println(solution(new String[]{"LOOXS","OOOOX","OOOOO","OOOOO","EOOOO"}));
    }

    private static int solution(String[] maps) {
        int[] start = new int[3];

        for (int i = 0; i < maps.length; i++) {
            if (maps[i].contains("S")) {
                start[0] = i;
                start[1] = maps[i].indexOf("S");
            }
        }

        int[] lever = findLeverOrExit(start, 'L', maps);

        if (lever == null) return -1;

        int[] exit = findLeverOrExit(lever, 'E', maps);

        if (exit == null) return -1;

        return exit[2];
    }

    private static int[] findLeverOrExit(int[] start, char findChar, String[] maps) {
        int xLength = maps.length;
        int yLength = maps[0].length();

        Queue<int[]> queue = new LinkedList<>();
        queue.add(start);

        boolean[][] visited = new boolean[xLength][yLength];
        visited[start[0]][start[1]] = true;

        while (!queue.isEmpty()) {
            int[] c = queue.poll();

            if (maps[c[0]].charAt(c[1]) == findChar) {
                return c;
            }

            for (int d = 0; d < 4; d++) {
                int nx = c[0] + dx[d];
                int ny = c[1] + dy[d];

                if (nx >= 0 && nx < xLength && ny >= 0 && ny < yLength) {
                    if (!visited[nx][ny] && maps[nx].charAt(ny) != 'X') {
                        visited[nx][ny] = true;
                        queue.offer(new int[]{nx, ny, c[2] + 1});
                    }
                }
            }
        }

        return null;
    }
}
