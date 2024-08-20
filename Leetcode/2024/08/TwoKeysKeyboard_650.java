package math;

public class TwoKeysKeyboard_650 {
    public static void main(String[] args) {
        System.out.println(minSteps(3));
        System.out.println(minSteps(1));
    }

    private static int minSteps(int n) {
        if (n == 1) return 0;

        int steps = 0;
        int factor = 2;

        while (n > 1) {
            while (n % factor == 0) {
                steps += factor;
                n /= factor;
            }
            factor++;
        }

        return steps;
    }
}
