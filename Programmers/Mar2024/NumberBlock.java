package Mar2024;

import java.util.Arrays;

/**
 * Level 2. 숫자 블록
 */
public class NumberBlock {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(1, 10))); // 0, 1, 1, 2, 1, 3, 1, 4, 3, 5
        System.out.println(Arrays.toString(solution(999995000, 1000000000)));
        System.out.println(Arrays.toString(solution(1, 5001)));
    }

    private static int[] solution(long begin, long end) {
        int first = (int)begin;
        int last = (int)end;
        int[] answer = new int[last - first + 1];

        for (int now = first; now < last + 1; now++) {
            answer[now - first] = 1;

            for (int div = 2; div <= Math.floor(Math.sqrt(now)); div++) {
                if (now % div == 0) {
                    if (now / div <= 10000000) {
                        answer[now - first] = now / div;
                        break;
                    }

                    answer[now - first] = div;
                }
            }
        }

        if (first == 1) answer[0] = 0;

        return answer;
    }
}
