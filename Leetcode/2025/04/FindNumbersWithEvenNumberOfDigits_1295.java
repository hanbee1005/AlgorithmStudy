package math;

public class FindNumbersWithEvenNumberOfDigits_1295 {
    public static void main(String[] args) {
        System.out.println(findNumbers(new int[]{12,345,2,6,7896}));
        System.out.println(findNumbers(new int[]{555,901,482,1771}));
    }

    private static int findNumbers(int[] nums) {
        int answer = 0;

        for (int num : nums) {
            int count = 0;
            while (num > 0) {
                count++;
                num /= 10;
            }

            if (count % 2 == 0) answer++;
        }

        return answer;

        /* 반복 없이 구하는 방법
        int result = 0;
        for (int number: nums) {
            if ((number > 9 && number < 100) || (number > 999 && number < 10000) || (number == 100000)) result++;
        }
        return result;
         */
    }
}
