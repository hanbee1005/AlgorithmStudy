package Sep2023;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Top Coder BinaryFlips SRM443 Div 1 Level 2
 */
public class TopCoderBinaryFlips {
    private static int[] array;
    private static int k;
    private static Queue<Integer> q;

    public static void main(String[] args) {
        System.out.println(minimalMoves(3, 0, 3));
        System.out.println(minimalMoves(4, 0, 3));
        System.out.println(minimalMoves(4, 1, 3));
        System.out.println(minimalMoves(3, 2, 5));
        System.out.println(minimalMoves(100000, 100000, 578));
        System.out.println(minimalMoves(0, 0, 1));
        System.out.println(minimalMoves(4, 44, 50));
    }

    private static int minimalMoves(int A, int B, int K) {
        if (A == 0) return 0;  // 움직일 필요가 없는 경우
        if (A + B < K) return -1;  // 뒤집을 수 없는 경우

        array = new int[A + B + 1];
        Arrays.fill(array, -1);

        k = K;

        q = new LinkedList<>();
        q.add(A);
        array[A] = 0;

        while (!q.isEmpty()) {
            int i = q.poll();  // i는 0의 수

            check(i, Math.max(0, K - (A + B - i)));  // 0을 최대한 증가시킵니다.
            check(i, Math.min(i, K));  // 1을 최대한 증가시킵니다.
            check(i, Math.min(Math.max((i + 1) / 2, K - ((A + B) - i)), K));  // K에 위부터 접근합니다.
            check(i, Math.min(Math.max(i / 2, K - ((A + B) - i)), K));  // K에 아래부터 접근합니다.
        }

        return array[0];
    }

    private static void check(int nowzero, int usezero) {
        // 가능한 0을 증가시킵니다. = 최대한 1을 많이 뒤집습니다.
        int nextzero = nowzero + k - 2 * usezero;
        if (array[nextzero] == -1) { // 처음 도착하는 곳이라면 다음 탐색에 추가합니다.
            array[nextzero] = array[nowzero] + 1;
            q.add(nextzero);
        }
    }

    // 수학적인 풀이 방법
//    private static int minimalMoves(int A, int B, int K) {
//        for (long i = 0; i < A + B; i++) {
//            long rest = i * K - A;
//            long use = ((i / 2) * B + ((i - 1) / 2) * A) * 2;
//            if (rest >= 0 && rest % 2 == 0 && rest <= use) {
//                return (int) i;
//            }
//        }
//            return -1;
//    }
}
