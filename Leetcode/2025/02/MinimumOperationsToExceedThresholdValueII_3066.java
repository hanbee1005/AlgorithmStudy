package heap;

import java.util.PriorityQueue;

public class MinimumOperationsToExceedThresholdValueII_3066 {
    public static void main(String[] args) {
        System.out.println(minOperations(new int[]{2,11,10,1,3}, 10));
        System.out.println(minOperations(new int[]{1,1,2,4,9}, 20));
        System.out.println(minOperations(new int[]{999999999,999999999,999999999}, 1000000000));
    }

    private static int minOperations(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num : nums) {
            if(num < k) pq.add(num);
        }

        int answer = 0;

        while (!pq.isEmpty()) {
            int x = pq.poll();
            answer++;

            if (pq.isEmpty()) break;

            int y = pq.poll();
            long up = 2L * x + y;
            if (up < k) pq.add((int) up);
        }

        return answer;
    }
}
