package Jan2022;

import java.util.Arrays;

public class MaxMin {
    public static void main(String[] args) {
        System.out.println(solution("-1 -2 -3 -4"));
    }

    private static String solution(String s) {
        StringBuilder answer = new StringBuilder();

        int[] nums = Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray();
        int min = Arrays.stream(nums).min().getAsInt();
        int max = Arrays.stream(nums).max().getAsInt();

        answer.append(min).append(" ").append(max);

        return answer.toString();
    }
}
