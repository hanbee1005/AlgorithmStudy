import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class BJAlgo_7562 {

    private static int[] dx = {-2, -2, -1, -1, 1, 1, 2, 2};
    private static int[] dy = {-1, 1, -2, 2, -2, 2, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            int[] start = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] end = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            int[][] visited = new int[n][n];
            for (int v = 0; v < n; v++) {
                Arrays.fill(visited[v], -1);
            }

            PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
                @Override
                public int compare(int[] t1, int[] t2) {
                    return t1[0] - t2[0];
                }
            });
            queue.offer(new int[]{0, start[0], start[1]});
            visited[start[0]][start[1]] = 0;

            while (!queue.isEmpty()) {
                int[] current = queue.poll();

                if (current[1] == end[0] && current[2] == end[1]) {
                    System.out.println(current[0]);
                    break;
                }

                for (int j = 0; j < 8; j++) {
                    int nx = current[1] + dx[j];
                    int ny = current[2] + dy[j];

                    if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                        if (visited[nx][ny] == -1) {
                            queue.offer(new int[]{current[0] + 1, nx, ny});
                            visited[nx][ny] = current[0] + 1;
                        }
                    }
                }
            }
        }
    }
}
