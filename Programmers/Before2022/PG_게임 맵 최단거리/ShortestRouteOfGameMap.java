import java.util.LinkedList;
import java.util.Queue;

public class ShortestRouteOfGameMap {
    private static int[] dx = {0, 1, 0, -1};
    private static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,0},{0,0,0,0,1}}));
    }

    private static int solution(int[][] maps) {
        int answer = 0;

        int n = maps.length;
        int m = maps[0].length;

        Queue<int[]> needVisit = new LinkedList<>();
        needVisit.add(new int[]{0, 0, 1});

        boolean[][] visited = new boolean[n][m];
        visited[0][0] = true;

        while(true) {
            if (needVisit.isEmpty()) {
                answer = -1;
                break;
            }

            int[] node = needVisit.poll();

            for (int i = 0; i < 4; i++) {
                int x = node[0] + dx[i];
                int y = node[1] + dy[i];

                if (x == n - 1 && y == m - 1) {
                    return node[2] + 1;
                }

                if (x >= 0 && x < n && y >= 0 && y < m) {
                    if (!visited[x][y] && maps[x][y] == 1) {
                        needVisit.add(new int[]{x, y, node[2] + 1});
                        visited[x][y] = true;
                    }
                }
            }
        }

        return answer;
    }
}
