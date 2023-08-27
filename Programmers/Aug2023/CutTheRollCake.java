package Aug2023;

import java.util.HashMap;
import java.util.Map;

/**
 * Level 2. 롤케이크 자르기
 */
public class CutTheRollCake {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 2, 1, 3, 1, 4, 1, 2}));
    }

    private static int solution(int[] topping) {
        int answer = 0;

        Map<Integer, Integer> leftMap = new HashMap<>();
        Map<Integer, Integer> rightMap = new HashMap<>();
        for (int top : topping) {
            rightMap.put(top, rightMap.getOrDefault(top, 0) + 1);
        }

        for (int cur : topping) {
            if (rightMap.containsKey(cur)) {
                rightMap.put(cur, rightMap.get(cur) - 1);
                if (rightMap.get(cur) <= 0) rightMap.remove(cur);
            }

            leftMap.put(cur, leftMap.getOrDefault(cur, 0) + 1);

            if (leftMap.keySet().size() == rightMap.keySet().size()) answer++;
        }


        return answer;
    }
}
