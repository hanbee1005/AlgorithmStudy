package graph;

import java.util.*;

public class FindChampionII_2924 {
    public static void main(String[] args) {
        System.out.println(findChampion(3, new int[][]{{0,1}, {1,2}}));
        System.out.println(findChampion(4, new int[][]{{0,2}, {1,3}, {1,2}}));
    }

    private static int findChampion(int n, int[][] edges) {
        boolean[] isUndefeated = new boolean[n];
        Arrays.fill(isUndefeated, true);

        for (int[] edge : edges) {
            int loser = edge[1];
            isUndefeated[loser] = false;
        }

        int champion = -1;
        int championCount = 0;

        for (int team = 0; team < n; team++) {
            if (isUndefeated[team]) {
                champion = team;
                championCount++;
            }
        }

        return championCount == 1 ? champion : -1;
    }
}
