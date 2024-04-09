package Apr2024;

import java.util.*;

/**
 * Level 3. 숫자 게임
 */
public class NumberGame {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{5,1,3,7}, new int[]{2,2,6,8}));
        System.out.println(solution(new int[]{2,2,2,2}, new int[]{1,1,1,1}));
    }

    private static int solution(int[] A, int[] B) {
        int answer = 0;

        int[] sortedA = Arrays.stream(A).sorted().toArray();
        int[] sortedB = Arrays.stream(B).sorted().toArray();

        int aIdx = 0;
        int bIdx = 0;
        while (aIdx < A.length && bIdx < B.length) {
            if (sortedA[aIdx] >= sortedB[bIdx]) {
                bIdx++;
                continue;
            }

            answer++;
            aIdx++;
            bIdx++;
        }

        return answer;
    }
}
