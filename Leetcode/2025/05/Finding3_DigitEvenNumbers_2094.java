package array;

import java.util.Arrays;

public class Finding3_DigitEvenNumbers_2094 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(findEvenNumbers(new int[]{2,1,3,0})));
        System.out.println(Arrays.toString(findEvenNumbers(new int[]{2,2,8,8,2})));
        System.out.println(Arrays.toString(findEvenNumbers(new int[]{3,7,5})));
    }

    static int[] answer = new int[451];

    private static int[] findEvenNumbers(int[] digits) {
        int[] count = new int[10];
        for (int d : digits) count[d]++;

        int size = 0;
        for (int i = 1; i < 10; i++) {
            if (count[i] == 0)
                continue;
            --count[i];
            for (int j = 0; j < 10; j++) {
                if (count[j] == 0)
                    continue;
                --count[j];
                for (int k = 0; k < 10; k += 2) {
                    if (count[k] == 0)
                        continue;
                    int num = i * 100 + j * 10 + k;
                    answer[size++] = num;
                }
                ++count[j];
            }
            ++count[i];
        }

        return Arrays.copyOf(answer, size);
    }
}
