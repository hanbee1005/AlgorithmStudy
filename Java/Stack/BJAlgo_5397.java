import java.io.*;
import java.util.*;

public class BJAlgo_5397 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            String L = br.readLine();
            System.out.println(findPassword(L));
        }
    }

    private static String findPassword(String L) {
        Deque<Character> left = new ArrayDeque<>();
        Deque<Character> right = new ArrayDeque<>();

        for (int index = 0; index < L.length(); index++) {
            switch (L.charAt(index)) {
                case '<':
                    if (!left.isEmpty()) {
                        right.addFirst(left.pollLast());
                    }
                    break;
                case '>':
                    if (!right.isEmpty()) {
                        left.addLast(right.pollFirst());
                    }
                    break;
                case '-':
                    if (!left.isEmpty()) {
                        left.pollLast();
                    }
                    break;
                default:
                    left.add(L.charAt(index));
                    break;
            }
        }

        StringBuilder sb = new StringBuilder();

        while (!left.isEmpty()) {
            sb.append(left.pollFirst());
        }

        while (!right.isEmpty()) {
            sb.append(right.pollFirst());
        }

        return sb.toString();
    }
}
