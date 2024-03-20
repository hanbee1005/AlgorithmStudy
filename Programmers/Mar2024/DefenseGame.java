package Mar2024;

import java.util.PriorityQueue;

/**
 * Level 2. 디펜스 게임
 */
public class DefenseGame {
    public static void main(String[] args) {
        System.out.println(solution(7, 3, new int[]{4, 2, 4, 5, 3, 3, 1}));
        System.out.println(solution(2, 4, new int[]{3, 3, 3, 3}));
    }

    private static int solution(int n, int k, int[] enemy) {
        int answer = 0;

        if (k >= enemy.length) return enemy.length;

        PriorityQueue<Integer> topK = new PriorityQueue<>();

        for (int i = 0; i < enemy.length; i++) {
            topK.offer(enemy[i]);
            if (topK.size() > k) {
                n -= topK.poll();
                if (n < 0) {
                    break;
                }
            }
            answer++;
        }

        return answer;
    }
}
