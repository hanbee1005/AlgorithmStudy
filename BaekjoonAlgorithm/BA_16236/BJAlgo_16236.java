import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class BJAlgo_16236 {
    private static int[] dx = {-1, 0, 0, 1};
    private static int[] dy = {0, -1, 1, 0};

    private static int shark_x = 0;
    private static int shark_y = 0;
    private static int shark_weight = 2;

    private static int n;
    private static int[][] fish;
    private static boolean[][] visited;

    private static int time = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        fish = new int[n][n];
        for (int i = 0; i < n; i++) {
            int[] tmp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < tmp.length; j++) {
                if (tmp[j] == 9) {  // 상어의 위치를 알게되는 경우
                    shark_x = i;  // 상어 위치 저장 (x)
                    shark_y = j;  // 상어 위치 저장 (y)
                    tmp[j] = 0;  // 원래 상어 위치에는 물고기가 없으므로 0으로 수정
                }
            }
            fish[i] = tmp;  // 구역 내 물고기 위치 저장
        }

        int numOfEatenFish = 0;

        while (true) {
            visited = new boolean[n][n];
            visited[shark_x][shark_y] = true;

            if (!bfs(shark_x, shark_y)) {  // 더 이상 잡아먹을 물고기가 없는 경우
                break;
            }

            numOfEatenFish += 1;

            if (numOfEatenFish == shark_weight) {  // 먹은 물고기 수가 상어의 크기와 같은 경우
                shark_weight += 1;  // 상어 크기 증가
                numOfEatenFish = 0;  // 먹은 물고기 수 초기화
            }
        }

        System.out.println(time);  // 엄마 상어에게 도움 요청하기까지 최종 시간 출력
    }

    private static boolean bfs(int x, int y) {
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] t1, int[] t2) {
                return t1[0] - t2[0] != 0 ? t1[0] - t2[0] : (t1[1] - t2[1] != 0 ? t1[1] - t2[1] : t1[2] - t2[2]);
            }
        });
        queue.offer(new int[]{0, x, y});

        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            if (fish[current[1]][current[2]] > 0 && fish[current[1]][current[2]] < shark_weight) {  // 현재 위치의 물고기를 먹을 수 있는 경우
                time += current[0];  // 지금까지 이동하는데 걸린 시간 추가
                shark_x = current[1];  // 상어 위치 이동 (x)
                shark_y = current[2];  // 상어 위치 이동 (y)
                fish[current[1]][current[2]] = 0;  // 원래 있던 물고기가 먹혔으므로 물고기가 없음(0)으로 변경
                return true;
            }

            for (int i = 0; i < 4; i++) {
                int nx = current[1] + dx[i];
                int ny = current[2] + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < n) {  // 다음 이동 위치가 구역 내에 있고
                    if (fish[nx][ny] <= shark_weight && !visited[nx][ny]) {  // 다음 이동 위치가 상어의 무게보다 작거나 같고 아직 방문한 적이 없는 경우
                        queue.offer(new int[]{current[0] + 1, nx, ny});  // 다음 위치 우선순위 큐에 추가
                        visited[nx][ny] = true;  // 다음 위치를 방문한 것으로 처리
                    }
                }
            }
        }
        return false;
    }
}
