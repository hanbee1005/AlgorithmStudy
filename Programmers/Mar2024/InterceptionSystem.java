package Mar2024;

import java.util.Arrays;

/**
 * Level 2. 요격 시스템
 */
public class InterceptionSystem {
    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{4,5},{4,8},{10,14},{11,13},{5,12},{3,7},{1,4}}));
        System.out.println(solution(new int[][]{{1, 2}, {3, 100}, {4, 5}, {6, 7}}));
    }

    private static int solution(int[][] targets) {
        int answer = 1;

        int last = 0;

        int[][] sortedTargets = Arrays.stream(targets).sorted((t1, t2) -> t1[0] - t2[0]).toArray(int[][]::new);
        for (int[] target : sortedTargets) {
            if (last == 0) {
                last = target[1];
                continue;
            }

            if (target[0] < last) {
                last = Math.min(last, target[1]);
            } else {
                last = target[1];
                answer++;
            }
        }

        return answer;
    }
}
