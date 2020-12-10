import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BJAlgo_10282 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int test = Integer.parseInt(br.readLine());
        for (int i = 0; i < test; i++) {
            int[] ndc = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            List<ArrayList<int[]>> computers = new ArrayList<>();
            for (int n = 0; n < ndc[0] + 1; n++) {
                computers.add(new ArrayList<>());
            }

            for (int j = 0; j < ndc[1]; j++) {
                int[] abs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                computers.get(abs[1]).add(new int[]{abs[0], abs[2]});
            }

            int[] result = dijkstra(computers, ndc[2]);
            int count = 0;
            int max_time = -1;
            for (int r : result) {
                if (r != 100000001) {
                    count += 1;
                    if (max_time < r) {
                        max_time = r;
                    }
                }
            }

            System.out.println(count + " " + max_time);
        }
    }

    private static int[] dijkstra(List<ArrayList<int[]>> computers, int start) {
        int[] time = new int[computers.size()];
        Arrays.fill(time, 100000001);
        time[start] = 0;

        PriorityQueue<int[]> queue = new PriorityQueue<>((int[] c1, int[] c2) -> c1[0] <= c2[0] ? 1 : -1);
        queue.offer(new int[]{0, start});

        while (!queue.isEmpty()) {
            int[] current = queue.poll();  // 0: current_time, 1: current_node

            if (current[0] > time[current[1]]) {
                continue;
            }

            for (int[] adj : computers.get(current[1])) {  // 0: adj, 1: time
                int dist = adj[1] + current[0];
                if (time[adj[0]] > dist) {
                    time[adj[0]] = dist;
                    queue.offer(new int[]{dist, adj[0]});
                }
            }
        }

        return time;
    }
}
