import java.util.LinkedList;
import java.util.Queue;

public class Printer {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{2, 1, 3, 2}, 2));
    }

    private static int solution(int[] priorities, int location) {
        int answer = 0;

        int[] contains = new int[10];
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < priorities.length; i++) {
            queue.offer(new int[]{priorities[i], i});
            contains[priorities[i]]++;
        }

        while (!queue.isEmpty()) {
            int[] n = queue.poll();

            boolean pop = true;

            int i = n[0] + 1;
            while(i < contains.length) {
                if (contains[i] > 0) {
                    queue.offer(n);
                    pop = false;
                    break;
                }

                i++;
            }

            if (pop) {
                answer++;

                if (n[1] == location) {
                    break;
                }

                if (contains[n[0]] != 0) {
                    contains[n[0]]--;
                }
            }
        }

        return answer;
    }
}
