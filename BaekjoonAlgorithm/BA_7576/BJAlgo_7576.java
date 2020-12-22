import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJAlgo_7576 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[][] tomato = new int[n][m];
        for (int i = 0; i < n; i++) {
            tomato[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        int total_day = 0;
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] ints, int[] t1) {
                return ints[0] - t1[0];
            }
        });
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (tomato[i][j] == 1) {
                    queue.offer(new int[]{0, i, j});
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] t = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = t[1] + dx[i];
                int ny = t[2] + dy[i];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if (tomato[nx][ny] == 0) {
                        tomato[nx][ny] = 1;
                        queue.offer(new int[]{t[0] + 1, nx, ny});
                        total_day = Math.max(total_day, t[0] + 1);
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (tomato[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }
            }
        }

        System.out.println(total_day);
    }
}
