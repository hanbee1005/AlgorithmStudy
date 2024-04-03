package Apr2024;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Level 3. 야근 지수
 */
public class OverTimeIndex {
    public static void main(String[] args) {
        System.out.println(solution(4, new int[]{4, 3, 3}));
        System.out.println(solution(1, new int[]{2, 1, 2}));
        System.out.println(solution(3, new int[]{1, 1}));
    }

    private static long solution(int n, int[] works) {
        long answer = 0;

        Queue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for (int work : works) {
            queue.offer(work);
        }

        for (int i = 0; i < n; i++) {
            if (queue.isEmpty()) {
                return answer;
            }

            int maxWork = queue.poll() - 1;
            if (maxWork != 0) queue.offer(maxWork);
        }

        for (int work : queue) {
            answer += (long) work * work;
        }

        return answer;
    }
}
