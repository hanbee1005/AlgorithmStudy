import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJAlgo_15686 {
    private static ArrayList<int[]> home = new ArrayList<>();
    private static ArrayList<int[]> chickens = new ArrayList<>();

    private static ArrayList<ArrayList<int[]>> combi = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            int[] city = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < n; j++) {
                if (city[j] == 1) {
                    home.add(new int[]{i, j});
                } else if (city[j] == 2) {
                    chickens.add(new int[]{i, j});
                }
            }
        }

        combinations(new boolean[chickens.size()], 0, m);

        int result = -1;
        for (ArrayList<int[]> c : combi) {
            if (result == -1) {
                result = findMinDist(c);
            } else {
                result = Math.min(result, findMinDist(c));
            }
        }

        System.out.println(result);
    }

    private static void combinations(boolean[] visited, int start, int r) {
        if (r == 0) {
            ArrayList<int[]> tmp = new ArrayList<>();
            for (int i = 0; i < visited.length; i++) {
                if (visited[i]) {
                    tmp.add(chickens.get(i));
                }
            }
            combi.add(tmp);
            return;
        } else {
            for (int i = start; i < visited.length; i++) {
                visited[i] = true;
                combinations(visited, i + 1, r - 1);
                visited[i] = false;
            }
        }

    }

    private static int findMinDist(ArrayList<int[]> chicken) {
        int minDist = 0;
        for (int[] h : home) {
            int minDistPerHome = 101;
            for (int[] c : chicken) {
                int dist = Math.abs(h[0] - c[0]) + Math.abs(h[1] - c[1]);
                minDistPerHome = Math.min(minDistPerHome, dist);
            }
            minDist += minDistPerHome;
        }

        return minDist;
    }
}
