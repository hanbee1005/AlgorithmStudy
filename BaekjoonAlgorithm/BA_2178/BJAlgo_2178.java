import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJAlgo_2178 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] maze = new int[n][m];
        boolean[][] visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            maze[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
            Arrays.fill(visited[i], false);
        }

        int[][] adj = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] t1, int[] t2) {
                return t1[0] - t2[0];
            }
        });
        queue.offer(new int[]{1, 0, 0});
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            if (current[1] == n - 1 && current[2] == m - 1) {
                System.out.println(current[0]);
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nx = current[1] + adj[i][0];
                int ny = current[2] + adj[i][1];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if (maze[nx][ny] == 1 && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        queue.offer(new int[]{current[0] + 1, nx, ny});
                    }
                }
            }
        }
    }
}
