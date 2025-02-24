package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MostProfitablePathInATree_2467 {
    public static void main(String[] args) {
        System.out.println(mostProfitablePath(new int[][]{{0,1},{1,2},{1,3},{3,4}}, 3, new int[]{-2,4,2,-4,6}));
        System.out.println(mostProfitablePath(new int[][]{{0,1}}, 1, new int[]{-7280,2350}));
    }

    private static List<Integer>[] tree;
    private static int[] amounts;
    private static int[] bobTime;
    private static int maxProfit;

    private static int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        int n = amount.length;
        tree = new List[n];
        bobTime = new int[n];
        amounts = amount;
        maxProfit = Integer.MIN_VALUE;
        Arrays.setAll(tree, k -> new ArrayList<>());
        Arrays.fill(bobTime, n);

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            tree[u].add(v);
            tree[v].add(u);
        }

        // Bob의 도착 시간 계산
        calculateBobTime(bob, -1, 0);
        bobTime[bob] = 0;

        // Alice의 최대 이익 계산
        calculateMaxProfit(0, -1, 0, 0);

        return maxProfit;
    }

    private static boolean calculateBobTime(int node, int parent, int time) {
        if (node == 0) {
            bobTime[node] = time;
            return true;
        }
        for (int neighbor : tree[node]) {
            // 이웃 노드가 이전에 지나친 노드가 아니고 시간 계산이 된 경우
            if (neighbor != parent && calculateBobTime(neighbor, node, time + 1)) {
                bobTime[node] = time;
                return true;
            }
        }
        return false;
    }

    private static void calculateMaxProfit(int node, int parent, int time, int currentProfit) {
        if (time == bobTime[node]) {
            currentProfit += amounts[node] / 2;
        } else if (time < bobTime[node]) {
            currentProfit += amounts[node];
        }

        boolean isLeaf = true;
        for (int neighbor : tree[node]) {
            if (neighbor != parent) {
                isLeaf = false;
                calculateMaxProfit(neighbor, node, time + 1, currentProfit);
            }
        }

        if (isLeaf) {
            maxProfit = Math.max(maxProfit, currentProfit);
        }
    }
}
