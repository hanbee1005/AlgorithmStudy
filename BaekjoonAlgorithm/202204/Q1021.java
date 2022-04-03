package Apr2022;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q1021 {
    public static void main(String[] args) throws IOException {
        int answer = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] nm = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int[] nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 1; i <= nm[0]; i++) {
            deque.add(i);
        }

        for (int i = 0; i < nums.length; i++) {
            int findNum = nums[i];
            Deque<Integer> frontPollQue = new LinkedList<>(deque);
            Deque<Integer> backPollQue = new LinkedList<>(deque);

            int frontToBack = 0;
            while (true) {
                int frontNum = frontPollQue.peek();

                if (frontNum == findNum) {
                    break;
                }

                frontPollQue.addLast(frontPollQue.pollFirst());
                frontToBack++;
            }


            int backToFront = 0;
            while (true) {
                int backNum = backPollQue.peekLast();

                if (backNum == findNum) {
                    break;
                }

                backPollQue.addFirst(backPollQue.pollLast());
                backToFront++;
            }

            if (frontToBack < backToFront + 1) {
                frontPollQue.pollFirst();
                deque = frontPollQue;
                answer += frontToBack;
            } else {
                backPollQue.pollLast();
                deque = backPollQue;
                answer += (backToFront + 1);
            }
        }

        System.out.println(answer);
    }
}
