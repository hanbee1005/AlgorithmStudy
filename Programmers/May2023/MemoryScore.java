package May2023;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Level 1. 추억 점수
 */
public class MemoryScore {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[]{"may", "kein", "kain", "radi"}, new int[]{5, 10, 1, 3}, new String[][]{{"may", "kein", "kain", "radi"},{"may", "kein", "brin", "deny"}, {"kon", "kain", "may", "coni"}})));
    }

    private static int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];

        Map<String, Integer> scores = new HashMap<>();
        for (int i = 0; i < name.length; i++) {
            scores.put(name[i], yearning[i]);
        }

        for (int i = 0; i < photo.length; i++) {
            for (int j = 0; j < photo[i].length; j++) {
                answer[i] += scores.getOrDefault(photo[i][j], 0);
            }
        }

        return answer;
    }
}
