package Aug2023;

import java.util.HashMap;
import java.util.Map;

/**
 * Level 2. 할인 행사
 */
public class DiscountEvent {
    public static void main(String[] args) {
        System.out.println(solution(new String[]{"banana", "apple", "rice", "pork", "pot"}
                , new int[]{3, 2, 2, 2, 1}
                , new String[]{"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"}));
    }

    private static int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < want.length; i++) {
            map.put(want[i], number[i]);
        }

        for (int i = 0; i < 10; i++) {
            if (map.containsKey(discount[i])) map.put(discount[i], map.get(discount[i]) - 1);
        }
        if (map.values().stream().allMatch(v -> v <= 0)) answer++;

        for (int i = 1; i <= discount.length - 10; i++) {
            String before = discount[i - 1];
            String newOne = discount[i + 9];

            if (map.containsKey(before)) map.put(before, map.get(before) + 1);
            if (map.containsKey(newOne)) map.put(newOne, map.get(newOne) - 1);
            if (map.values().stream().allMatch(v -> v <= 0)) answer++;
        }

        return answer;
    }
}
