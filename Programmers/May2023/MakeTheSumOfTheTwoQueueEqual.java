package May2023;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Level 2. 두 큐 합 같게 만들기
 */
public class MakeTheSumOfTheTwoQueueEqual {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{3, 2, 7, 2}, new int[]{4, 6, 5, 1}));
        System.out.println(solution(new int[]{1, 2, 1, 2}, new int[]{1, 10, 1, 2}));
        System.out.println(solution(new int[]{1, 1}, new int[]{1, 5}));
        System.out.println(solution(new int[]{1, 4}, new int[]{4, 8}));
    }

    private static int solution(int[] queue1, int[] queue2) {
        int answer = 0;

        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();

        long sum1 = 0;
        long sum2 = 0;

        for (int i = 0; i < queue1.length; i++) {
            q1.offer(queue1[i]);
            q2.offer(queue2[i]);

            sum1 += queue1[i];
            sum2 += queue2[i];
        }

        while (!q1.isEmpty() && !q2.isEmpty()) {
            if (sum1 == sum2) {
                return answer;
            }

            if (answer > Math.min(600000, Math.pow(queue1.length, 2))) {
                break;
            }

            if (sum1 > sum2) {
                int num = q1.poll();
                sum1 -= num;
                sum2 += num;
                q2.offer(num);
            } else {
                int num = q2.poll();
                sum1 += num;
                sum2 -= num;
                q1.offer(num);
            }

            answer += 1;
        }

        return -1;
    }
}
