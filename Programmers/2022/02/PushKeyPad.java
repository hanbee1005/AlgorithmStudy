package Feb2022;

import java.util.HashMap;
import java.util.Map;

public class PushKeyPad {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0}, "right"));
    }

    private static String solution(int[] numbers, String hand) {
        StringBuilder answer = new StringBuilder();

        Map<Character, int[]> position = new HashMap<>(){{
            put('1', new int[]{0, 0});
            put('2', new int[]{0, 1});
            put('3', new int[]{0, 2});
            put('4', new int[]{1, 0});
            put('5', new int[]{1, 1});
            put('6', new int[]{1, 2});
            put('7', new int[]{2, 0});
            put('8', new int[]{2, 1});
            put('9', new int[]{2, 2});
            put('*', new int[]{3, 0});
            put('0', new int[]{3, 1});
            put('#', new int[]{3, 2});
        }};

        char leftPos = '*';
        char rightPos = '#';

        for (int number : numbers) {
            char p;
            if (number % 3 == 1) {
                p = 'L';
            } else if (number != 0 && number % 3 == 0) {
                p = 'R';
            } else {
                int[] lp = position.get(leftPos);
                int[] rp = position.get(rightPos);

                int[] np = position.get(Character.forDigit(number, 10));

                p = Math.abs(lp[0] - np[0]) + Math.abs(lp[1] - np[1]) > Math.abs(rp[0] - np[0]) + Math.abs(rp[1] - np[1]) ? 'R'
                        : Math.abs(lp[0] - np[0]) + Math.abs(lp[1] - np[1]) < Math.abs(rp[0] - np[0]) + Math.abs(rp[1] - np[1]) ? 'L'
                        : hand.equals("right") ? 'R' : 'L';
            }

            if (p == 'L') leftPos = Character.forDigit(number, 10);
            else rightPos = Character.forDigit(number, 10);

            answer.append(p);
        }
        return answer.toString();
    }
}
