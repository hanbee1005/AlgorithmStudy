package Jun2024;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Level 3. N으로 표현하기 (DP)
 */
public class ExpressionInN {
    public static void main(String[] args) {
        System.out.println(solution(5, 12));
        System.out.println(solution(2, 11));
    }

    private static int solution(int N, int number) {
        if (N == number) return 1;

        List<Set<Integer>> dp = new ArrayList<>();
        for (int i = 0; i <= 8; i++) {
            dp.add(new HashSet<>());
        }

        dp.get(1).add(N);

        for (int i = 2; i <= 8; i++) {
            // 초기 N을 i개 사용한 경우 추가
            dp.get(i).add(Integer.parseInt(String.valueOf(N).repeat(i)));

            // N을 i개 사용할 때 사칙 연산으로 나올 수 있는 수 구하기
            for (int j = 1; j < i; j++) {
                int k = i - j;
                for (int n : dp.get(j)) {
                    for (int m : dp.get(k)) {
                        dp.get(i).add(n + m);
                        dp.get(i).add(n - m);
                        dp.get(i).add(n * m);
                        if (m != 0) {
                            dp.get(i).add(n / m);
                        }
                    }
                }
            }

            if (dp.get(i).contains(number)) return i;
        }

        return -1;
    }
}
