package Aug2023;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Level 2. 택배상자
 */
public class DeliveryBox {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{4, 3, 1, 2, 5}));
        System.out.println(solution(new int[]{5, 4, 3, 2, 1}));
    }

    private static int solution(int[] order) {
        int answer = 0;

        Queue<Integer> container = new LinkedList<>();
        for (int i = 1; i <= order.length; i++) {
            container.add(i);
        }

        Stack<Integer> subContainer = new Stack<>();

        int curIndex = 0;

        while (!container.isEmpty() || !subContainer.isEmpty()) {
            int cur = !container.isEmpty() ? container.peek() : 0;
            int top = !subContainer.isEmpty() ? subContainer.peek() : 0;

            if (cur == order[curIndex]) {
                container.poll();
                curIndex++;
            } else if (top == order[curIndex]) {
                subContainer.pop();
                curIndex++;
            } else if (cur < order[curIndex]) {
                subContainer.add(container.poll());
            } else {
                break;
            }
        }

        return curIndex;
    }
}
