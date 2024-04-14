package Apr2024;

import java.util.*;

/**
 * Level 3. 보석 쇼핑
 */
public class JewelryShopping {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[]{"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"})));
        System.out.println(Arrays.toString(solution(new String[]{"AA", "AB", "AC", "AA", "AC"})));
        System.out.println(Arrays.toString(solution(new String[]{"XYZ", "XYZ", "XYZ"})));
        System.out.println(Arrays.toString(solution(new String[]{"ZZZ", "YYY", "NNNN", "YYY", "BBB"})));
    }
    private static int[] solution(String[] gems) {
        int[] answer = new int[2];

        int start = 0;
        int end = 0;
        Map<String, Integer> gemMap = new HashMap<>();
        for (int i = 0; i < gems.length; i++) {
            if (!gemMap.containsKey(gems[i])) {
                gemMap.put(gems[i], i);
                end = i;
                answer = new int[]{start + 1, end + 1};
            } else {
                gemMap.put(gems[i], i);
                end = i;
                if (gems[start].equals(gems[i])) {
                    start = Math.min(100001, gemMap.values().stream().min(Integer::compareTo).orElse(0));
                    if (answer[1] - answer[0] > end - start) {
                        answer = new int[]{start + 1, end + 1};
                    }
                }
            }
        }

        return answer;
    }
}
