import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class BJAlgo_2606 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int v = Integer.parseInt(br.readLine());
        Map<Integer, ArrayList> nodes = new HashMap<>();
        for (int i = 0; i < v; i++) {
            int[] ab = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            if (nodes.containsKey(ab[0])) {
                nodes.get(ab[0]).add(ab[1]);
            } else {
                nodes.put(ab[0], new ArrayList(Arrays.asList(ab[1])));
            }

            if (nodes.containsKey(ab[1])) {
                nodes.get(ab[1]).add(ab[0]);
            } else {
                nodes.put(ab[1], new ArrayList(Arrays.asList(ab[0])));
            }
        }

        System.out.println(bfs(nodes, 1));
    }

    private static int bfs(Map<Integer, ArrayList> node_list, int start) {
        ArrayList<Integer> need_visit = new ArrayList<>();
        ArrayList<Integer> visited = new ArrayList<>();

        need_visit.add(start);
        while (!need_visit.isEmpty()) {
            int node = need_visit.remove(0);
            if (!visited.contains(node)) {
                visited.add(node);
                if (node_list.containsKey(node)) {
                    need_visit.addAll(node_list.get(node));
                }
            }
        }

        return visited.size() - 1;
    }
}
