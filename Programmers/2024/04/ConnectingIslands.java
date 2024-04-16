package Apr2024;

import java.util.*;

/**
 * Level 3. 섬 연결하기 (탐욕법)
 */
public class ConnectingIslands {
    public static void main(String[] args) {
        System.out.println(solution(4, new int[][]{{0,1,1},{0,2,2},{1,2,5},{1,3,1},{2,3,8}}));
    }

    private static int solution(int n, int[][] costs) {
        int answer = 0;

        int[][] islands = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(islands[i], Integer.MAX_VALUE);
        }

        for (int[] cost : costs) {
            islands[cost[0]][cost[1]] = cost[2];
            islands[cost[1]][cost[0]] = cost[2];
        }

        Queue<int[]> bridges = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        boolean[] visited = new boolean[n];
        visited[0] = true;
        for (int i = 1; i < n; i++) {
            if (islands[0][i] != Integer.MAX_VALUE) bridges.offer(new int[]{i, islands[0][i]});
        }

        while (!bridges.isEmpty()) {
            int[] cur = bridges.poll();
            int idx = cur[0];
            if (!visited[idx]) {
                visited[idx] = true;
                answer += cur[1];
                for (int i = 1; i < n; i++) {
                    if (islands[idx][i] != Integer.MAX_VALUE) bridges.offer(new int[]{i, islands[idx][i]});
                }
            }
        }

        return answer;
    }

    /**
     * 크루스칼 알고리즘 사용
     * private static int solution(int n, int[][] costs) {
     *         int answer = 0;
     *
     *         int[] parents = new int[n];
     *         for (int i = 0; i < n; i++) {
     *             parents[i] = i;
     *         }
     *
     *         // 건설 비용이 낮은 순으로 정렬
     *         Arrays.sort(costs, (c1, c2) -> c1[2] - c2[2]);
     *
     *         for (int[] cost : costs) {
     *             if (findParent(parents, cost[0]) != findParent(parents, cost[1])) {
     *                 answer += cost[2];
     *                 updateParent(parents, cost[0], cost[1]);
     *             }
     *         }
     *
     *         return answer;
     *     }
     *
     *     private static void updateParent(int[] parents, int c1, int c2) {
     *         int p1 = findParent(parents, c1);
     *         int p2 = findParent(parents, c2);
     *
     *         if (p1 < p2) parents[p2] = p1;
     *         else parents[p1] = p2;
     *     }
     *
     *     private static int findParent(int[] parents, int c) {
     *         if (parents[c] == c) {
     *             return c;
     *         }
     *
     *         return findParent(parents, parents[c]);
     *     }
     */
}
