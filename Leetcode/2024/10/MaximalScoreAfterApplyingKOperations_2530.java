package heap;

import java.util.PriorityQueue;

public class MaximalScoreAfterApplyingKOperations_2530 {
    public static void main(String[] args) {
        System.out.println(maxKelements(new int[]{10,10,10,10,10}, 5));
        System.out.println(maxKelements(new int[]{1,10,3,3,3}, 3));
    }

    private static long maxKelements(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for(int i : nums) {
            pq.add(i);
        }

        long score = 0;
        while(k-- > 0 && !pq.isEmpty()) {
            int n = pq.poll();
            score += n;
            pq.offer((n + 2)/ 3);
        }

        return score;
    }
}
