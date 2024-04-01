package Jan2022;

import java.util.HashMap;
import java.util.Map;

public class NumberStringAndEnglishWords {
    public static void main(String[] args) {
        System.out.println(solution("123"));
    }

    private static int solution(String s) {
        Map<String, Integer> nums = new HashMap<>();
        nums.put("zero", 0);
        nums.put("one", 1);
        nums.put("two", 2);
        nums.put("three", 3);
        nums.put("four", 4);
        nums.put("five", 5);
        nums.put("six", 6);
        nums.put("seven", 7);
        nums.put("eight", 8);
        nums.put("nine", 9);

        StringBuilder answer = new StringBuilder();

        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                answer.append(c);
                continue;
            }

            sb.append(c);

            if (nums.containsKey(sb.toString())) {
                answer.append(nums.get(sb.toString()));
                sb.delete(0, sb.length());
            }
        }

        return Integer.parseInt(answer.toString());
    }
}
