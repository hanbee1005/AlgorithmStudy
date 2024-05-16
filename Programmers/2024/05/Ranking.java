package May2024;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Level 3. 순위 (그래프)
 */
public class Ranking {
    public static void main(String[] args) {
        System.out.println(solution(5, new int[][]{{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}}));
    }

    private static int solution(int n, int[][] results) {
        int answer = 0;

        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(i, new ArrayList<>());
        }
        for (int[] result : results) {
            map.get(result[0] - 1).add(result[1] - 1);
        }

        int[][] result = new int[n][2];
        for (int i = 0; i < n; i++) {
            dfs(map, result, new boolean[n], i, i);
        }

        for (int i = 0; i < n; i++) {
            if (result[i][0] + result[i][1] == n - 1) {
                answer++;
            }
        }

        return answer;
    }

    private static void dfs(Map<Integer, List<Integer>> map, int[][] result, boolean[] visited, int cur, int base) {
        visited[cur] = true;
        if (cur != base) {
            result[base][1] += 1;
            result[cur][0] += 1;
        }

        for (Integer next : map.get(cur)) {
            if (!visited[next]) {
                dfs(map, result, visited, next, base);
            }
        }
    }
}
