import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BJAlgo_1325 {
    private static List<ArrayList<Integer>> adj = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int[] nm = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        for (int i = 0; i < nm[0] + 1; i++) {
            adj.add(i, new ArrayList<>());
        }

        for (int i = 0; i < nm[1]; i++) {
            int[] ab = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            adj.get(ab[1]).add(ab[0]);
        }

        ArrayList<Integer> result = new ArrayList<>();
        int max_value = -1;

        for (int i = 1; i < adj.size(); i++) {
            int c = bfs(i);

            if (c > max_value) {
                result.clear();
                result.add(i);
                max_value = c;
            } else if (c == max_value) {
                result.add(i);
            }
        }

        for (int r : result) {
            sb.append(r).append(" ");
        }

        System.out.println(sb);
    }

    private static int bfs(int v) {
        Deque<Integer> deque = new ArrayDeque<>();
        deque.add(v);

        boolean[] visited = new boolean[adj.size() + 1];
        int count = 1;

        while (!deque.isEmpty()) {
            int n = deque.pollFirst();
            for (int e : adj.get(n)) {
                if (!visited[e]) {
                    deque.add(e);
                    visited[e] = true;
                    count += 1;
                }
            }
        }

        return count;
    }
}
