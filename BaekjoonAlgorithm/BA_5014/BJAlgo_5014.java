import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJAlgo_5014 {
    private static int f;
    private static int s;
    private static int g;
    private static int u;
    private static int d;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        f = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        g = Integer.parseInt(st.nextToken());
        u = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        int result = bfs();
        if (result == -1) {
            System.out.println("use the stairs");
        } else {
            System.out.println(result);
        }
    }

    private static int bfs() {
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] t1, int[] t2) {
                return t1[0] - t2[0];
            }
        });
        queue.offer(new int[]{0, s});

        boolean[] visited = new boolean[f + 1];
        visited[s] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            if (current[1] == g) {
                return current[0];
            }

            // 위로 올라가는 경우
            int next_up_floor = current[1] + u;

            if (next_up_floor > 0 && next_up_floor <= f && !visited[next_up_floor]) {
                queue.offer(new int[]{current[0] + 1, next_up_floor});
                visited[next_up_floor] = true;
            }

            // 아래로 내려가는 경우
            int next_down_floor = current[1] - d;
            if (next_down_floor > 0 && next_down_floor <= f && !visited[next_down_floor]) {
                queue.offer(new int[]{current[0] + 1, next_down_floor});
                visited[next_down_floor] = true;
            }
        }

        return -1;
    }
}
