package Apr2024;

import java.util.*;

/**
 * Level 3. 가장 먼 노드 (그래프)
 */
public class FurthestNode {
    public static void main(String[] args) {
        System.out.println(solution(6, new int[][]{{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}}));
    }

    private static int solution(int n, int[][] edge) {
        int answer = 0;

        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] ed : edge) {
            if (map.containsKey(ed[0])) {
                map.get(ed[0]).add(ed[1]);
            } else {
                map.put(ed[0], new ArrayList<>(){{add(ed[1]);}});
            }

            if (map.containsKey(ed[1])) {
                map.get(ed[1]).add(ed[0]);
            } else {
                map.put(ed[1], new ArrayList<>(){{add(ed[0]);}});
            }
        }

        Queue<int[]> graph = new LinkedList<>();
        boolean[] visited = new boolean[n+1];
        graph.add(new int[]{1, 0});
        visited[1] = true;

        int max = 0;

        while (!graph.isEmpty()) {
            int[] node = graph.poll();
            List<Integer> linked = map.get(node[0]);

            int cnt = 0;
            for (boolean v : visited) {
                if (v) cnt++;
            }

            if (cnt == n) {
                if (max < node[1]) {
                    max = node[1];
                    answer = 1;
                } else if (max == node[1]) {
                    answer++;
                }
            }

            for (Integer idx : linked) {
                if (!visited[idx]) {
                    visited[idx] = true;
                    graph.add(new int[]{idx, node[1] + 1});
                }
            }
        }

        return answer;
    }
}
