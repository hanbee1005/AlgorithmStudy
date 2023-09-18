package Sep2023;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Top Coder BinaryFlips SRM443 Div 1 Level 2
 */
public class TopCoderBinaryFlips {
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

        int[] array = new int[A + B + 1];
        Arrays.fill(array, -1);

        Queue<Integer> q = new LinkedList<>();
        q.add(A);
        array[A] = 0;

        while (!q.isEmpty()) {
            int i = q.poll();  // i는 0의 수

            // j는 0을 뒤집는 수
            for (int j = Math.max(0, K - (A + B + i)); j < Math.min(i, K); j++) {
                int nextzero = i + (K - 2 * j); // 다음 상태의 0의 수
                if (array[nextzero] == -1) { // 처음 도착하는 곳이라면 다음 탐색에 추가합니다.
                    if (nextzero == 0) return array[i] + 1;  // 답을 찾으면 이것을 리턴합니다.
                    array[nextzero] = array[i] + 1;
                    q.add(nextzero);
                }
            }
        }

        return -1;
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
