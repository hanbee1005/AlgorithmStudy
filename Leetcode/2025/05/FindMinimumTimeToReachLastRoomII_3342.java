package graph;

import java.util.PriorityQueue;
import java.util.Queue;

public class FindMinimumTimeToReachLastRoomII_3342 {
    private static final int[][] DIRS = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
    private static int m;
    private static int n;

    public static void main(String[] args) {
        System.out.println(minTimeToReach(new int[][]{{0,4},{4,4}}));
        System.out.println(minTimeToReach(new int[][]{{0,0,0,0},{0,0,0,0}}));
        System.out.println(minTimeToReach(new int[][]{{0,1},{1,2}}));
    }

    private static int minTimeToReach(int[][] moveTime) {
        m = moveTime.length;
        n = moveTime[0].length;
        return dijkstra(moveTime);
    }

    private static int dijkstra(int[][] moveTime) {
        Queue<int[]> heap = new PriorityQueue<>((a, b) -> a[1] - b[1]);

        heap.offer(new int[] { 0, 0, 1 }); // 2 - even, 1 - odd
        moveTime[0][0] = -1;

        while (!heap.isEmpty()) {
            int[] curr = heap.poll();
            int r = curr[0] / n;
            int c = curr[0] % n;
            int time = curr[1];
            int odd = curr[2];

            for (int[] dir : DIRS) {
                int rr = r + dir[0];
                int cc = c + dir[1];
                int nextNode = rr * n + cc;

                if (!isValid(rr, cc) || moveTime[rr][cc] == -1) {
                    continue;
                }

                int newTime = Math.max(time, moveTime[rr][cc]) + odd;
                if (rr == m - 1 && cc == n - 1) {
                    return newTime;
                }
                heap.offer(new int[] { nextNode, newTime, 3 - odd });
                moveTime[rr][cc] = -1;
            }
        }
        return -1;
    }

    private static boolean isValid(int r, int c) {
        return r >= 0 && r < m && c >= 0 && c < n;
    }
}
