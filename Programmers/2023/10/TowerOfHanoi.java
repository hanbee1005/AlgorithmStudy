package Oct2023;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Level 2. 하노이의 탑
 */
public class TowerOfHanoi {
    private static List<int[]> result = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(solution(2)));
    }

    private static int[][] solution(int n) {
        hanoi(n, 1, 3, 2);

        int[][] answer = new int[result.size()][2];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }

        return answer;
    }

    private static void hanoi(int n, int from, int to, int other) {
        if (n == 0) return;
        hanoi(n - 1, from, other, to);
        result.add(new int[]{from, to});
        hanoi(n - 1, other, to, from);
    }

}
