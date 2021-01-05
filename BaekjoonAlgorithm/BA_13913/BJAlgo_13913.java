import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class BJAlgo_13913 {
    private static int n;
    private static int k;

    private static int[][] visited = new int[100001][2];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        for (int i = 0; i < 100001; i++) {
            Arrays.fill(visited[i], -1);
        }

        System.out.println(bfs(n));

        StringBuilder sb = new StringBuilder();
        sb.append(k);
        while (visited[k][1] != -1) {
            sb.insert(0, visited[k][1] + " ");
            k = visited[k][1];
        }

        System.out.println(sb);
    }

    private static int bfs(int start) {
        Deque<Integer> deque = new ArrayDeque<>();
        deque.add(start);
        visited[start][0] = 0;

        while (!deque.isEmpty()) {
            int current = deque.pollFirst();

            if (current == k) {
                return visited[current][0];
            }

            for (int i = 0; i < 3; i++) {
                int next = move(i, current);

                if (next >= 0 && next < 100001 && visited[next][0] == -1) {
                    visited[next][0] = visited[current][0] + 1;
                    visited[next][1] = current;
                    deque.add(next);
                }
            }
        }

        return -1;
    }

    private static int move(int idx, int c) {
        int result = -1;
        switch (idx) {
            case 0:
                result = c * 2;
                break;
            case 1:
                result = c + 1;
                break;
            case 2:
                result = c - 1;
                break;
        }

        return result;
    }
}
