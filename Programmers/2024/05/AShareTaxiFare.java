package May2024;

import java.util.*;

/**
 * Level 3. 합승 택시 요금
 */
public class AShareTaxiFare {
    public static void main(String[] args) {
        System.out.println(solution(6, 4, 6, 2, new int[][]{{4, 1, 10}, {3, 5, 24}, {5, 6, 2}, {3, 1, 41}, {5, 1, 24}, {4, 6, 50}, {2, 4, 66}, {2, 3, 22}, {1, 6, 25}}));
        System.out.println(solution(7, 3, 4, 1, new int[][]{{5, 7, 9}, {4, 6, 4}, {3, 6, 1}, {3, 2, 3}, {2, 1, 6}}));
        System.out.println(solution(6, 4, 5, 6, new int[][]{{2,6,6}, {6,3,7}, {4,6,7}, {6,5,11}, {2,5,12}, {5,3,20}, {2,4,8}, {4,3,9}}));
    }

    private static int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = 20000001;

        Map<Integer, List<int[]>> map = new HashMap<>();
        for (int[] fare : fares) {
            if (map.containsKey(fare[0])) {
                map.get(fare[0]).add(new int[]{fare[1], fare[2]});
            } else {
                map.put(fare[0], new ArrayList<>(){{add(new int[]{fare[1], fare[2]});}});
            }

            if (map.containsKey(fare[1])) {
                map.get(fare[1]).add(new int[]{fare[0], fare[2]});
            } else {
                map.put(fare[1], new ArrayList<>(){{add(new int[]{fare[0], fare[2]});}});
            }
        }

        int[] start = dijkstra(n, s, map);
        int[] startA = dijkstra(n, a, map);
        int[] startB = dijkstra(n, b, map);

        for (int i = 1; i <= n; i++) {
            answer = Math.min(answer, start[i] + startA[i] + startB[i]);
        }

        return answer;
    }

    private static int[] dijkstra(int n, int start, Map<Integer, List<int[]>> map) {
        int[] dist = new int[n + 1];
        Arrays.fill(dist, 20000001);

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{start, 0});
        dist[start] = 0;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int[] node : map.get(cur[0])) {
                int d = cur[1] + node[1];
                if (dist[node[0]] > d) {
                    dist[node[0]] = d;
                    queue.offer(new int[]{node[0], d});
                }
            }
        }

        return dist;
    }
}
