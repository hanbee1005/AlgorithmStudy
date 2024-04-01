package Aug2023;

import java.util.HashSet;
import java.util.Set;

/**
 * Level 2. 연속 부분 수열 합의 개수
 */
public class NumberOfConsecutivePartialSequenceSums {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{7,9,1,1,4}));
    }

    private static int solution(int[] elements) {
        Set<Integer> set = new HashSet<>();
        int[] dp = new int[elements.length];

        for (int len = 1; len <= elements.length; len++) {
            for (int i = 0; i < elements.length; i++) {
                dp[i] += elements[(len + i - 1) % elements.length];
                set.add(dp[i]);
            }
        }

        return set.size();
    }
}
