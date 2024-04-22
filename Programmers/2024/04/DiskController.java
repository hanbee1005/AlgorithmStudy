package Apr2024;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class DiskController {
    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{0, 3}, {1, 9}, {2, 6}}));
    }

    private static int solution(int[][] jobs) {
        int answer = 0;

        Queue<int[]> queue = new PriorityQueue<>((j1, j2) -> j1[0] == j2[0] ? j1[1] - j2[1] : j1[0] - j2[0]);
        for (int[] job : jobs) {
            queue.offer(new int[]{job[0], job[1], 0});
        }

        int sum = 0;
        while (!queue.isEmpty()) {
            int[] job = queue.poll();

            int nextStart = job[0] + job[1];
            sum += job[1] + job[2];

            List<int[]> tmp = new ArrayList<>();
            for (int[] que : queue) {
                if (nextStart >= que[0]) {
                    tmp.add(new int[]{nextStart, que[1], que[2] + (nextStart - que[0])});
                } else {
                    tmp.add(que);
                }
            }

            queue.clear();
            queue.addAll(tmp);
        }

        answer = sum / jobs.length;
        return answer;
    }

    /**
     * 다른 풀이
     * class Solution {
     *     public int solution(int[][] jobs) {
     *         int answer = 0;
     *
     *         Arrays.sort(jobs, (a, b) -> a[0] - b[0]);
     *
     *         PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
     *
     *         int index = 0;
     *         int count = 0;
     *         int total = 0;
     *         int end = 0;
     *         while(count < jobs.length) {
     *
     *             while(index < jobs.length && jobs[index][0] <= end) {
     *                 pq.add(jobs[index++]);
     *             }
     *
     *             if(pq.isEmpty()) {
     *                 end = jobs[index][0];
     *             } else {
     *                 int[] cur = pq.poll();
     *                 total += cur[1] + end - cur[0];
     *                 end += cur[1];
     *                 count++;
     *             }
     *         }
     *         return total / jobs.length;
     *     }
     * }
     */
}
