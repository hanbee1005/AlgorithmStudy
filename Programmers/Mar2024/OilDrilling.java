package Mar2024;

import java.util.*;

/**
 * Level 2. 석유 시추
 */
public class OilDrilling {
    // 가로, 세로 길이
    static int n, m;
    // 시추관 위치별 석유량
    static int[] oil;

    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{0, 0, 0, 1, 1, 1, 0, 0}, {0, 0, 0, 0, 1, 1, 0, 0}, {1, 1, 0, 0, 0, 1, 1, 0}, {1, 1, 1, 0, 0, 0, 0, 0}, {1, 1, 1, 0, 0, 0, 1, 1}}));
        System.out.println(solution(new int[][]{{1, 0, 1, 0, 1, 1}, {1, 0, 1, 0, 0, 0}, {1, 0, 1, 0, 0, 1}, {1, 0, 0, 1, 0, 0}, {1, 0, 0, 1, 0, 1}, {1, 0, 0, 0, 0, 0}, {1, 1, 1, 1, 1, 1}}));
    }

    private static int solution(int[][] land) {
        int answer = 0;

        n = land.length;
        m = land[0].length;
        oil = new int[m];

        boolean[][] visited = new boolean[n][m];
        for (int y = 0; y < m; y++) {
            for (int x = 0; x < n; x++) {
                if (land[x][y] == 1 && !visited[x][y]) {
                    bfs(land, visited, x, y);
                }
            }
        }

        answer = Arrays.stream(oil).max().orElse(0);
        return answer;
    }

    public static void bfs(int[][] land, boolean[][] visited, int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        visited[x][y] = true;

        // 상, 하, 좌, 우 이동
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        // 석유 덩어리 개수
        int count = 1;
        // 석유 덩어리의 열 위치 저장
        Set<Integer> set = new HashSet<>();

        while (!q.isEmpty()) {
            int[] now = q.poll();
            set.add(now[1]);

            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];

                // 땅 범위를 넘지 않으면서
                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    // 빈 땅이거나, 방문한 적이 있는 경우
                    if (land[nx][ny] == 1 && !visited[nx][ny]) {
                        q.add(new int[]{nx, ny});
                        visited[nx][ny] = true;
                        count += 1;
                    }
                }
            }
        }

        for (int index : set) {
            oil[index] += count;
        }
    }
}
