package Aug2023;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Collections.reverseOrder;
import static java.util.Map.Entry.comparingByValue;

public class PickATangerine {
    public static void main(String[] args) {
        System.out.println(solution(6, new int[]{1, 3, 2, 5, 4, 5, 2, 3}));
        System.out.println(solution(4, new int[]{1, 3, 2, 5, 4, 5, 2, 3}));
        System.out.println(solution(2, new int[]{1, 1, 1, 1, 2, 2, 2, 3}));
    }

    private static int solution(int k, int[] tangerine) {
        int answer = 0;

        Map<Integer, Integer> map = new LinkedHashMap<>();
        for (int t : tangerine) {
            map.put(t, map.getOrDefault(t, 0) + 1);
        }

        List<Integer> collect = map.entrySet().stream()
                .sorted(reverseOrder(comparingByValue()))
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());

        for (int c : collect) {
            k -= c;
            answer++;
            if (k <= 0) break;
        }

        return answer;
    }
}
