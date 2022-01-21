package Dec2021;

import java.util.Arrays;

public class RepeatBinaryTransform {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution("110010101001")));
    }

    private static int[] solution(String s) {
        int[] answer = new int[2];

        int repeatCount = 0;
        int zeroCount = 0;

        while (!"1".equals(s)) {
            int tmp = s.length();

            s = s.replaceAll("0", "");
            zeroCount += (tmp - s.length());

            s = makeBinaryNum(s.length());
            repeatCount++;
        }

        answer[0] = repeatCount;
        answer[1] = zeroCount;

        return answer;
    }

    private static String makeBinaryNum(int num) {
        StringBuilder sb = new StringBuilder();
        while(0 != num) {
            sb.insert(0, num % 2);
            num /= 2;
        }

        return sb.toString();
    }
}