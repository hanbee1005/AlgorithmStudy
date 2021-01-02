import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BJAlgo_2589 {
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};

    private static int n;
    private static int m;

    private static String[] island;
    private static Deque<int[]> deque = new ArrayDeque<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 보물섬 지도의 높이, 너비 입력 받기
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        // 땅과 바다 위치 입력 받기
        island = new String[n];
        for (int i = 0; i < n; i++) {
            island[i] = br.readLine();
        }

        int time = 0;  // 가장 먼 섬까지 가는데 걸리는 최대 시간 저장 (정답)

        // 전체 지도를 확인하면서
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (island[i].charAt(j) == 'L') {  // 땅인 경우
                    // 해당 땅과 연결된 가장 먼 땅까지 가는데 걸리는 시간 구하기
                    time = Math.max(time, bfs(i, j));
                }
            }
        }

        System.out.println(time);
    }

    private static int bfs(int x, int y) {
        int[][] count = new int[n][m];  // 해당 땅을 몇 시간만에 방문했는지 저장
        deque.add(new int[]{x, y});  // 처음 시작 땅의 위치를 큐에 저장
        count[x][y] = 1;  // 처음 시작하는 위치를 방문한 것으로 우선 처리
        int num = 0;  // 가장 먼 땅까지 가는데 걸리는 시간

        while (!deque.isEmpty()) {
            int[] current = deque.pollFirst();

            for (int i = 0; i < 4; i++) {
                int nx = current[0] + dx[i];
                int ny = current[1] + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if (island[nx].charAt(ny) == 'L' && count[nx][ny] == 0) {  // 땅이면서 아직 방문하지 않은 경우
                        count[nx][ny] = count[current[0]][current[1]] + 1;  // 다음 위치까지 이동한 시간 저장 (현재 위치까지 이동한 시간 + 1)
                        num = Math.max(num, count[nx][ny]);  // 이동 시간의 최대 값 저장
                        deque.add(new int[]{nx, ny});  // 다음 위치를 큐에 저장하기
                    }
                }
            }
        }

        return num - 1;  // 처음 방문한 땅의 값도 추가되었으므로 제거
    }
}
