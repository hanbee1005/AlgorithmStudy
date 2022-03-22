package Mar2022;

import java.util.*;

public class DividePowerIntoTwo {
    public static void main(String[] args) {
        System.out.println(solution(3, new int[][]{{1,2},{2,3}}));
    }

    private static int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;

        // 전력망 구성하기
        Map<Integer, List<Integer>> powerGrid = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            powerGrid.put(i, new ArrayList<>());
        }

        for (int[] wire : wires) {
            powerGrid.get(wire[0]).add(wire[1]);
            powerGrid.get(wire[1]).add(wire[0]);
        }

        // 전선 하나씩 끊으며
        for (int[] wire : wires) {
            // 전력망 개수 차이 구하기
            answer = Math.min(answer, bfs(powerGrid, wire));
        }

        return answer;
    }

    private static int bfs(Map<Integer, List<Integer>> grid, int[] start) {
        int[] count = new int[2];

        for (int i = 0; i < start.length; i++) {
            Stack<Integer> needVisit = new Stack<>();
            boolean[] visited = new boolean[grid.size() + 1];
            needVisit.push(start[i]);
            visited[start[i]] = true;

            while (!needVisit.isEmpty()) {
                int cp = needVisit.pop();

                for (int np : grid.get(cp)) {
                    if (np != start[1 - i] && !visited[np]) {
                        needVisit.push(np);
                        visited[np] = true;
                        count[i]++;
                    }
                }
            }
        }

        return Math.abs(count[0] - count[1]);
    }
}
