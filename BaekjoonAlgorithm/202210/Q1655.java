package Oct2022;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Q1655 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            int val = Integer.parseInt(br.readLine());

            if (minHeap.size() == maxHeap.size()) {
                maxHeap.add(val);
            } else {
                minHeap.add(val);
            }

            if (!minHeap.isEmpty() && !maxHeap.isEmpty()) {
                if (minHeap.peek() < maxHeap.peek()) {
                    int tmp = minHeap.poll();
                    minHeap.add(maxHeap.poll());
                    maxHeap.add(tmp);
                }
            }

            sb.append(maxHeap.peek()).append("\n");
        }

        System.out.println(sb);
    }
}
