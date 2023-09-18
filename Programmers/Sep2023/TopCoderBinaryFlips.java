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

    private static int minimalMoves(int A, int B, int K) {
        if (A == 0) return 0;  // 움직일 필요가 없는 경우
        if (A + B < K) return -1;  // 뒤집을 수 없는 경우

        int minvalue = A, maxvalue = A;

        // 0의 장수의 현재 최대치와 최소치를 저장합니다.
        // 짝수인지 홀수인지 밖에 없다는 것에 주의
        for (int i = 0; i < A + B; i++) {
            int nextminvalue, nextmaxvalue;

            // 일단 가능한 0을 줄입니다. = 1로 많이 뒤집습니다.
            if (minvalue <= K && maxvalue >= K) {
                // 최대치와 최소치 사이에 K가 있는 경우
                if (minvalue % 2 == K % 2) return i + 1; // 홀수라면 모두 1이 됩니다.
                else nextminvalue = 1; // 홀수가 아니라면 0이 1장 남습니다.
            } else {
                nextminvalue = Math.min(Math.abs(K - minvalue), Math.abs(K - maxvalue));
            }

            // 마찬가지로 최대값도 생각합니다.
            if (minvalue <= (A + B - K) && maxvalue >= (A + B - K)) {
                if ((A + B - maxvalue) % 2 == K % 2) nextmaxvalue = A + B;
                else nextmaxvalue = A + B - 1;
            } else {
                nextmaxvalue = A + B - Math.min(Math.abs((A + B - K) - minvalue), Math.abs((A + B - K) - maxvalue));
            }

            minvalue =nextminvalue;
            maxvalue = nextmaxvalue;
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
