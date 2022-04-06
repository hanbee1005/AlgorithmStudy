package Apr2022;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Q5430 {
    public static void main(String[] args) throws IOException {
        StringBuffer answer = new StringBuffer();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            String[] p = br.readLine().split("");
            int n = Integer.parseInt(br.readLine());
            String arr = br.readLine();
            String[] numbers = arr.substring(1, arr.length() - 1).split(",");

            Deque<Integer> deque = new ArrayDeque<>();
            if (n != 0) {
                Arrays.stream(numbers).mapToInt(Integer::parseInt)
                        .forEach(deque::add);
            }

            boolean convert = false;
            for (String s : p) {
                if ("R".equals(s)) {
                    convert = !convert;
                } else if ("D".equals(s)) {
                    if (deque.isEmpty()) {
                        deque = null;
                        break;
                    }

                    if (convert) {
                        deque.pollLast();
                    } else {
                        deque.pollFirst();
                    }
                }
            }

            if (deque == null) {
                answer.append("error").append("\n");
                continue;
            }

            answer.append("[");
            while (!deque.isEmpty()) {
                if (convert) {
                    answer.append(deque.pollLast());
                } else {
                    answer.append(deque.pollFirst());
                }

                if (!deque.isEmpty()) {
                    answer.append(",");
                }
            }
            answer.append("]").append("\n");
        }

        System.out.println(answer);
    }
}