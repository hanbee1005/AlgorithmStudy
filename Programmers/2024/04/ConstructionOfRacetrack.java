package Apr2024;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Level 3. 경주로 건설
 */
public class ConstructionOfRacetrack {
    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{0,0,0},{0,0,0},{0,0,0}}));  // 900
        System.out.println(solution(new int[][]{{0,0,0,0,0,0,0,1},{0,0,0,0,0,0,0,0},{0,0,0,0,0,1,0,0},{0,0,0,0,1,0,0,0},
                {0,0,0,1,0,0,0,1},{0,0,1,0,0,0,1,0},{0,1,0,0,0,1,0,0},{1,0,0,0,0,0,0,0}}));  // 3800
        System.out.println(solution(new int[][]{{0,0,1,0},{0,0,0,0},{0,1,0,1},{1,0,0,0}}));  // 2100
        System.out.println(solution(new int[][]{{0,0,0,0,0,0},{0,1,1,1,1,0},{0,0,1,0,0,0},{1,0,0,1,0,1},{0,1,0,0,0,1},{0,0,0,0,0,0}}));  // 3200
        System.out.println(solution(new int[][]{{0, 0, 0, 0, 0}, {0, 1, 1, 1, 0}, {0, 0, 1, 0, 0}, {1, 0, 0, 0, 1}, {1, 1, 1, 0, 0}}));  // 3000
    }

    private static int solution(int[][] board) {
        int answer = Integer.MAX_VALUE;

        int n = board.length;
        int m = board[0].length;

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        Queue<int[]> roads = new LinkedList<>();
        roads.add(new int[]{0, 0, -1});

        int[][][] cost = new int[n][m][4];
        cost[0][0][0] = 0;
        cost[0][0][1] = 0;
        cost[0][0][2] = 0;
        cost[0][0][3] = 0;

        while (!roads.isEmpty()) {
            int[] road = roads.poll();
            int x = road[0];
            int y = road[1];
            int dir = road[2] == -1 ? 0 : road[2];

            if (x == n - 1 && y == m - 1) {
                answer = Math.min(answer, cost[x][y][dir]);
            }

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if (board[nx][ny] == 0) {
                        int nextCost = cost[x][y][dir] + (isCorner(road[2], d) ? 600 : 100);
                        if (cost[nx][ny][d] == 0 || nextCost <= cost[nx][ny][d]) {
                            cost[nx][ny][d] = nextCost;
                            roads.add(new int[]{nx, ny, d});
                        }
                    }
                }
            }
        }

        return answer;
    }

    private static boolean isCorner(int before, int current) {
        return before >= 0
                && (((before % 2 == 0) && (current % 2 == 1)) || ((before % 2 == 1) && (current % 2 == 0)));
    }
}
