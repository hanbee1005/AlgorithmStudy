package Apr2024;

import java.util.*;

/**
 * Level 3. 이중 우선순위 큐
 */
public class DoublePriorityQueue {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[]{"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"})));
        System.out.println(Arrays.toString(solution(new String[]{"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"})));
    }

    private static int[] solution(String[] operations) {
        int[] answer = new int[2];

        Queue<Integer> minHeap = new PriorityQueue<>();
        Queue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (String operation : operations) {
            String[] op = operation.split(" ");
            int num = Integer.parseInt(op[1]);
            switch (op[0]) {
                case "I": {
                    minHeap.offer(num);
                    maxHeap.offer(num);
                    break;
                }
                case "D": {
                    if (maxHeap.isEmpty()) break;
                    if (1 == num) {
                        minHeap.remove(maxHeap.poll());
                    } else if (-1 == num) {
                        maxHeap.remove(minHeap.poll());
                    }
                }
            }
        }

        if (!maxHeap.isEmpty()) {
            answer[0] = maxHeap.peek();
            answer[1] = minHeap.peek();
        }

        return answer;
    }
}
