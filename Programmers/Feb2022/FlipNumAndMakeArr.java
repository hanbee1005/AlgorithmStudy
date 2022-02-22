package Feb2022;

import java.util.Arrays;

public class FlipNumAndMakeArr {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(1000000000)));
    }

    private static int[] solution(long n) {
        String[] strN = String.valueOf(n).split("");
        int[] answer = new int[strN.length];

        for (int i = 0; i < strN.length; i++) {
            answer[i] = Integer.parseInt(strN[strN.length - (i+1)]);
        }

        return answer;
    }
}
