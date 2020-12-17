public class KakaoColoringBook {
    private static int[] dx = {1, -1, 0, 0};
    private static int[] dy = {0, 0, 1, -1};

    private static int mm;
    private static int nn;
    private static int[][] pictures;
    private static int[][] visited;

    public static void main(String[] args) {
        int[][] picture = {{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}};

        int[] answer = solution(6, 4, picture);
        System.out.println("[" + answer[0] + ", " + answer[1] + "]");
    }

    private static int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        mm = m;
        nn = n;
        pictures = picture;

        visited = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (picture[i][j] == 0) { // 색칠 칸이 아닌 경우 패스
                    continue;
                }

                if (visited[i][j] == 0) { // 색칠 칸이지만 방문한 적이 없는 경우
                    int num = dfs(i, j);
                    numberOfArea += 1;
                    maxSizeOfOneArea = Math.max(maxSizeOfOneArea, num);
                }
            }
        }

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }

    private static int dfs(int x, int y) {
        visited[x][y] = 1;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < mm && ny >= 0 && ny < nn) {
                if (visited[nx][ny] == 0 && pictures[x][y] == pictures[nx][ny]) {
                    visited[x][y] += dfs(nx, ny);
                }
            }
        }

        return visited[x][y];
    }
}
