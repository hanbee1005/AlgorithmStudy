package math;

public class DivisibleAndNon_divisibleSumsDifference_2894 {
    public static void main(String[] args) {
        System.out.println(differenceOfSums(10, 3));
        System.out.println(differenceOfSums(5, 6));
        System.out.println(differenceOfSums(5, 1));
    }

    private static int differenceOfSums(int n, int m) {
        int num1 = 0;
        int num2 = 0;

        for (int i = 1; i <= n; i++) {
            if (i % m != 0) {
                num1 += i;
            } else {
                num2 += i;
            }
        }

        return num1 - num2;
    }
}
