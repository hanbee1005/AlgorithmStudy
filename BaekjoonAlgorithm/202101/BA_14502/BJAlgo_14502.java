import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BJAlgo_14502 {
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};

    private static int n;
    private static int m;

    private static int[][] labs;
    private static boolean[][] visited;

    private static ArrayList<int[]> virus = new ArrayList<>();
    private static ArrayList<int[]> combi = new ArrayList<>();

    private static int maxSafeArea = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        labs = new int[n][m];
        for (int i = 0; i < n; i++) {
            int[] tmp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < m; j++) {
                if (tmp[j] == 0) {  // 초기 바이러스가 없고 벽을 세울 수 있는 빈 공간 위치 저장하기
                    combi.add(new int[]{i, j});
                } else if (tmp[j] == 2) {  // 초기 바이러스의 위치 저장하기
                    virus.add(new int[]{i, j});
                }

                labs[i] = tmp;
            }
        }

        for (int i = 0; i < combi.size() - 3; i++) {
            for (int j = i + 1; j < combi.size() - 2; j++) {
                for (int k = j + 1; k < combi.size() - 1; k++) {
                    // 새로운 벽 3개 세우기
                    int[] newWall = new int[]{i, j, k};
                    makeWall(newWall, true);

                    // 바이러스 퍼트리기
                    visited = new boolean[n][m];
                    bfs();

                    // 안전 지역 파악하기
                    int cnt = 0;
                    for (int a = 0; a < n; a++) {
                        for (int b = 0; b < m; b++) {
                            if (!visited[a][b] && labs[a][b] == 0) {
                                cnt += 1;
                            }
                        }
                    }

                    if (cnt > maxSafeArea) {
                        maxSafeArea = cnt;
                    }

                    // 새로 세운 벽 없애기
                    makeWall(newWall, false);
                }
            }
        }

        System.out.println(maxSafeArea);
    }

    private static void makeWall(int[] wall, boolean isBuilt) {
        if (isBuilt) {
            for (int w : wall) {
                labs[combi.get(w)[0]][combi.get(w)[1]] = 1;
            }
        } else {
            for (int w : wall) {
                labs[combi.get(w)[0]][combi.get(w)[1]] = 0;
            }
        }
    }

    private static void bfs() {
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] t1, int[] t2) {
                return t1[0] - t2[0];
            }
        });

        for (int[] v : virus) {
            queue.offer(new int[]{0, v[0], v[1]});
            visited[v[0]][v[1]] = true;
        }

        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = current[1] + dx[i];
                int ny = current[2] + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if (labs[nx][ny] == 0 && !visited[nx][ny]) {
                        queue.offer(new int[]{current[0] + 1, nx, ny});
                        visited[nx][ny] = true;
                    }
                }
            }
        }
    }
}
