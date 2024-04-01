package Feb2022;

import java.util.Arrays;

public class DividedNumberArr {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{5, 9, 7, 10}, 5)));
    }

    private static int[] solution(int[] arr, int divisor) {
        int[] answer = Arrays.stream(arr)
                .filter(num -> num % divisor == 0)
                .toArray();

        if (answer.length == 0) return new int[]{-1};

        Arrays.sort(answer);

        return answer;
    }
}
