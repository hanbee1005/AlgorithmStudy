package Apr2024;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Level 2. 도넛과 막대 그래프
 */
public class DoughnutAndStickGraph {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[][]{{2, 3}, {4, 3}, {1, 1}, {2, 1}})));  // {2, 1, 1, 0}
        System.out.println(Arrays.toString(solution(new int[][]{{4, 11}, {1, 12}, {8, 3}, {12, 7}, {4, 2}, {7, 11}, {4, 8},
                {9, 6}, {10, 11}, {6, 10}, {3, 5}, {11, 1}, {5, 3}, {11, 9}, {3, 8}})));  // {4, 0, 1, 2}
    }

    public static int[] solution(int[][] edges) {
        int[] answer = new int[4];

        Map<Integer, int[]> map = new HashMap<>();
        for (int[] edge : edges) {
            if (!map.containsKey(edge[0])) {
                map.put(edge[0], new int[2]);
            }

            if (!map.containsKey(edge[1])) {
                map.put(edge[1], new int[2]);
            }

            map.get(edge[0])[0] += 1;  // 해당 지점에서 나간 간선의 수
            map.get(edge[1])[1] += 1;  // 해당 지점으로 들어온 간선의 수
        }

        map.forEach((key, value) -> {
            if (value[0] >= 2 && value[1] == 0) {
                answer[0] = key;
            } else if (value[0] == 0 && value[1] > 0) {
                answer[2] += 1;
            } else if (value[0] >= 2 && value[1] >= 2) {
                answer[3] += 1;
            }
        });

        answer[1] = map.get(answer[0])[0] - answer[2] - answer[3];

        return answer;
    }
}
