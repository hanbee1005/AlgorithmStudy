package May2024;

import java.util.ArrayList;
import java.util.List;

/**
 * Level 3. 양과 늑대
 */
public class SheepAndWolf {
    static int answer = 0;
    static int[] Info;
    static List<List<Integer>> children;

    public static void main(String[] args) {
        System.out.println(solution(new int[]{0,0,1,1,1,0,1,0,1,0,1,1}, new int[][]{{0,1},{1,2},{1,4},{0,8},{8,7},{9,10},{9,11},{4,3},{6,5},{4,6},{8,9}}));
        System.out.println(solution(new int[]{0,1,0,1,1,0,1,0,0,1,0}, new int[][]{{0,1},{0,2},{1,3},{1,4},{2,5},{2,6},{3,7},{4,8},{6,9},{9,10}}));
    }

    private static int solution(int[] info, int[][] edges) {
        Info = info;
        children = new ArrayList<>();
        for (int i = 0; i < info.length; i++) {
            children.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            children.get(edge[0]).add(edge[1]);
        }

        dfs(0, 0, 0, new ArrayList<>(){{add(0);}});

        return answer;
    }

    private static void dfs(int cur, int sheep, int wolf, List<Integer> canMove) {
        if (Info[cur] == 0) {
            sheep += 1;
        } else {
            wolf += 1;
        }

        if (wolf >= sheep) return;

        answer = Math.max(answer, sheep);

        // 다음에 갈 수 있는 곳 갱신
        List<Integer> next = new ArrayList<>(canMove);
        next.remove(Integer.valueOf(cur)); // 현재는 탐색했으므로 빼주고
        next.addAll(children.get(cur));

        for (int n : next) {
            dfs(n, sheep, wolf, next);
        }
    }
}
