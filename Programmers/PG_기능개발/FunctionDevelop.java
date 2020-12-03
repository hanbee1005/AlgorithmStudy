import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class FunctionDevelop {
    public static void main(String[] args) throws Exception {
        int[] progresses = {93, 30, 55};
        int[] speeds = {1, 30, 5};

        Queue<Integer> queue = new ArrayDeque<>();
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < progresses.length; i++) {
            int wd = (100 - progresses[i]) / speeds[i];
            if ((100 - progresses[i]) % speeds[i] != 0) {
                wd += 1;
            }

            if (queue.isEmpty() || queue.peek() >= wd) {
                queue.add(wd);
            } else {
                int count = 0;
                while (!queue.isEmpty()) {
                    queue.poll();
                    count++;
                }
                result.add(count);
                queue.add(wd);
            }
        }

        if (!queue.isEmpty()) {
            int count = 0;
            while (!queue.isEmpty()) {
                queue.poll();
                count++;
            }
            result.add(count);
        }

        int[] answer = result.stream().mapToInt(i -> i).toArray();

        System.out.println(answer);
    }
}
