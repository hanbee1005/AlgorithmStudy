package Apr2024;

/**
 * Level 3. 연속 펄스 부분 수열의 합
 */
public class SumOfContinuousPulsePartialSequences {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{2, 3, -6, 1, 3, -1, 2, 4}));
    }

    private static long solution(int[] sequence) {
        long answer = 0;

        long pulse1 = 0;
        long pulse2 = 0;

        boolean isPulse = true;

        for (int seq : sequence) {
            pulse1 += isPulse ? seq : -seq;
            pulse2 += isPulse ? -seq : seq;

            pulse1 = Math.max(0, pulse1);
            pulse2 = Math.max(0, pulse2);

            answer = Math.max(answer, Math.max(pulse1, pulse2));

            isPulse = !isPulse;
        }

        return answer;
    }
}
