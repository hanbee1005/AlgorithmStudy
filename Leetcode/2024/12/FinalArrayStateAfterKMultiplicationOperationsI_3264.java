package array;

import java.util.Arrays;

public class FinalArrayStateAfterKMultiplicationOperationsI_3264 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(getFinalState(new int[]{2, 1, 3, 5, 6}, 5, 2)));
        System.out.println(Arrays.toString(getFinalState(new int[]{1, 2}, 3, 4)));
    }

    private static int[] getFinalState(int[] nums, int k, int multiplier) {
        while (k > 0) {
            int x = 0;
            for (int i = 1; i < nums.length;i++) {
                if (nums[i] < nums[x]) {
                    x = i;
                }
            }

            nums[x] = nums[x] * multiplier;
            k--;
        }

        return nums;
    }
}
