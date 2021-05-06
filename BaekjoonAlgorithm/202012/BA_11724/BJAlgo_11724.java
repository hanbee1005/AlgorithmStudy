import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BJAlgo_11724 {

    private static List<ArrayList<Integer>> graph;
    private static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        visited = new boolean[n + 1];
        int count = 0;

        for (int i = 1; i < n + 1; i++) {
            if (!visited[i]) {
                dfs(i);
                count += 1;
            }
        }

        System.out.println(count);
    }

    private static void dfs(int start) {
        visited[start] = true;

        for (int n : graph.get(start)) {
            if (!visited[n]) {
                dfs(n);
            }
        }
    }
}
