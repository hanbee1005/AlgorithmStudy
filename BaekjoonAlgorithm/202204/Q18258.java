package Apr2022;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Q18258 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());

        Deque<Integer> deque = new ArrayDeque<>();
        StringBuffer buffer = new StringBuffer();

        for (int i = 0; i < N; i++) {
            String[] command = reader.readLine().split(" ");

            switch (command[0]) {
                case "push":
                    deque.add(Integer.parseInt(command[1]));
                    break;
                case "pop":
                    buffer.append(deque.isEmpty() ? -1 : deque.pop()).append("\n");
                    break;
                case "size":
                    buffer.append(deque.size()).append("\n");
                    break;
                case "empty":
                    buffer.append(deque.isEmpty() ? 1 : 0).append("\n");
                    break;
                case "front":
                    buffer.append(deque.isEmpty() ? -1 : deque.getFirst()).append("\n");
                    break;
                case "back":
                    buffer.append(deque.isEmpty() ? -1 : deque.getLast()).append("\n");
                    break;
            }
        }

        System.out.println(buffer);
    }
}