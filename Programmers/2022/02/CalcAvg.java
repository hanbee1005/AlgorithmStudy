package Feb2022;

import java.util.Arrays;

public class CalcAvg {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{1,2,3,4}));
    }

    private static double solution(int[] arr) {
        double answer = Arrays.stream(arr).average().getAsDouble();
        return answer;
    }
}
