import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BJAlgo_1260 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int[] nmv = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Map<Integer, ArrayList> nodes = new HashMap<>();
        for (int i = 0; i < nmv[1]; i++) {
            int[] nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            if (nodes.containsKey(nums[0])) {
                nodes.get(nums[0]).add(nums[1]);
            } else {
                nodes.put(nums[0], new ArrayList(Arrays.asList(nums[1])));
            }

            if (nodes.containsKey(nums[1])) {
                nodes.get(nums[1]).add(nums[0]);
            } else {
                nodes.put(nums[1], new ArrayList(Arrays.asList(nums[0])));
            }
        }

        for (Integer v : dfs(nodes, nmv[2])) {
            sb.append(v).append(" ");
        }

        sb.append("\n");

        for (Integer v : bfs(nodes, nmv[2])) {
            sb.append(v).append(" ");
        }

        System.out.println(sb);
    }

    private static ArrayList<Integer> dfs(Map<Integer, ArrayList> nodeList, int startNode) {
        ArrayList<Integer> needVisit = new ArrayList<>();
        ArrayList<Integer> visited = new ArrayList<>();

        needVisit.add(startNode);
        while (!needVisit.isEmpty()) {
            int node = needVisit.remove(needVisit.size() - 1);
            if (!visited.contains(node)) {
                visited.add(node);
                if (nodeList.containsKey(node)) {
                    Collections.sort(nodeList.get(node));
                    Collections.reverse(nodeList.get(node));
                    needVisit.addAll(nodeList.get(node));
                }
            }
        }

        return visited;
    }

    private static ArrayList<Integer> bfs(Map<Integer, ArrayList> nodeList, int startNode) {
        ArrayList<Integer> needVisit = new ArrayList<>();
        ArrayList<Integer> visited = new ArrayList<>();

        needVisit.add(startNode);
        while (!needVisit.isEmpty()) {
            int node = needVisit.remove(0);
            if (!visited.contains(node)) {
                visited.add(node);
                if (nodeList.containsKey(node)) {
                    Collections.sort(nodeList.get(node));
                    needVisit.addAll(nodeList.get(node));
                }
            }
        }

        return visited;
    }
}
