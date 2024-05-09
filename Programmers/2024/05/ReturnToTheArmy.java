package May2024;

import java.util.*;

/**
 * Level 3. 부대 복귀
 */
public class ReturnToTheArmy {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(3, new int[][]{{1, 2}, {2, 3}}, new int[]{2, 3}, 1))); // 1, 2
        System.out.println(Arrays.toString(solution(5, new int[][]{{1, 2}, {1, 4}, {2, 4}, {2, 5}, {4, 5}}, new int[]{1, 3, 5}, 5))); // 2, -1, 0
    }
    private static int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length];

        Map<Integer, List<Integer>> connectedRoad = new HashMap<>();
        for (int[] road : roads) {
            if (connectedRoad.containsKey(road[0])) {
                connectedRoad.get(road[0]).add(road[1]);
            } else {
                connectedRoad.put(road[0], new ArrayList<>(){{add(road[1]);}});
            }

            if (connectedRoad.containsKey(road[1])) {
                connectedRoad.get(road[1]).add(road[0]);
            } else {
                connectedRoad.put(road[1], new ArrayList<>(){{add(road[0]);}});
            }
        }

        int[] minDistances = new int[n + 1];
        Queue<Integer> rollback = new LinkedList<>();
        rollback.add(destination);
        while (!rollback.isEmpty()) {
            int cur = rollback.poll();

            if (connectedRoad.containsKey(cur)) {
                for (int next : connectedRoad.get(cur)) {
                    if (next != destination && minDistances[next] == 0) {
                        minDistances[next] += minDistances[cur] + 1;
                        rollback.offer(next);
                    }
                }
            }
        }

        for (int i = 0; i < sources.length; i++) {
            answer[i] = (sources[i] != destination && minDistances[sources[i]] == 0) ? -1 : minDistances[sources[i]];
        }

        return answer;
    }
}
