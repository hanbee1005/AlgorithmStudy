package Feb2024;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Level 1. 명예의 전당 (1)
 */
public class TheHallOfFame1 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(3, new int[]{10, 100, 20, 150, 1, 100, 200})));
        System.out.println(Arrays.toString(solution(4, new int[]{0, 300, 40, 300, 20, 70, 150, 50, 500, 1000})));
    }

    private static int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        Queue<Integer> hallOfFame = new PriorityQueue<>();

        for (int i = 0; i < score.length; i++) {
            hallOfFame.offer(score[i]);

            if (hallOfFame.size() > k) {
                hallOfFame.poll();
            }

            answer[i] = hallOfFame.peek();
        }

        return answer;
    }
}
