package Sep2023;

import java.util.Arrays;

/**
 * Level 2. 숫자 카드 나누기
 */
public class DivideTheNumberCards {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{14, 35, 119}, new int[]{18, 30, 102}));
        System.out.println(solution(new int[]{10, 17}, new int[]{5, 20}));
        System.out.println(solution(new int[]{10, 20}, new int[]{5, 17}));
        System.out.println(solution(new int[]{100000000}, new int[]{8}));
    }

    private static int solution(int[] arrayA, int[] arrayB) {
        int a = findGCD(arrayA);
        int b = findGCD(arrayB);

        return checkGCD(arrayA, b) || checkGCD(arrayB, a) ? Math.max(a, b) : 0;
    }

    private static boolean checkGCD(int[] array, int d) {
        return Arrays.stream(array).allMatch(n -> n % d != 0);
    }

    private static int findGCD(int[] array) {
        int result = array[0];
        for (int i = 1; i < array.length; i++) {
            result = gcd(result, array[i]);
        }
        return result;
    }

    private static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}
