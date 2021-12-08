package Dec;

import java.util.Arrays;

public class NoMoreThenTwoBits {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new long[]{2, 7})));
    }

    private static long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 2 == 0) {
                answer[i] = numbers[i] + 1;
            } else {
                String binaryString = Long.toBinaryString(numbers[i]);
                String[] strings = binaryString.split("0+");
                int cnt = strings[strings.length - 1].length();
                answer[i] = numbers[i] + (long) Math.pow(2, (cnt - 1));
            }
        }
        return answer;
    }
}
