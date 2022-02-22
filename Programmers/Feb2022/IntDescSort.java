package Feb2022;

import java.util.Arrays;
import java.util.Comparator;

public class IntDescSort {
    public static void main(String[] args) {
        System.out.println(solution(118372));
    }

    private static long solution(long n) {
        String[] arr = Arrays.stream(String.valueOf(n).split(""))
                        .sorted(Comparator.reverseOrder())
                        .toArray(String[]::new);

        StringBuilder sb = new StringBuilder();
        for (String s : arr) {
            sb.append(s);
        }

        long answer = Long.parseLong(sb.toString());

        return answer;
    }
}
