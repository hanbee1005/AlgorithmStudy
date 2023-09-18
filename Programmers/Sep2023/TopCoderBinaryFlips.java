package Sep2023;

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

    // 수학적인 풀이 방법
    private static int minimalMoves(int A, int B, int K) {
        for (long i = 0; i < A + B; i++) {
            long rest = i * K - A;
            long use = ((i / 2) * B + ((i - 1) / 2) * A) * 2;
            if (rest >= 0 && rest % 2 == 0 && rest <= use) {
                return (int) i;
            }
        }
            return -1;
    }
}
