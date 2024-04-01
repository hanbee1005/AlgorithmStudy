package Sep2023;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Top Coder InterestingDigits SRM150 Div 2 Level 2
 */
public class TopCoderInterestingDigits {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(digits(10)));
        System.out.println(Arrays.toString(digits(3)));
        System.out.println(Arrays.toString(digits(9)));
        System.out.println(Arrays.toString(digits(26)));
        System.out.println(Arrays.toString(digits(30)));
    }

    private static int[] digits(int base) {
        List<Integer> answer = new ArrayList<>();
        for (int i = 2; i < base; i++) {
            if ((base - 1)% i == 0) answer.add(i);
        }

        return answer.stream().mapToInt(i -> i).toArray();
    }
}
