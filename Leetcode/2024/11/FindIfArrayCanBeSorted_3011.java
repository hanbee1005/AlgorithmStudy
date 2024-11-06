package array;

import java.util.Arrays;

public class FindIfArrayCanBeSorted_3011 {
    public static void main(String[] args) {
        System.out.println(canSortArray(new int[]{8,4,2,30,15}));
        System.out.println(canSortArray(new int[]{1,2,3,4,5}));
        System.out.println(canSortArray(new int[]{3,16,8,4,2}));
    }

    private static boolean canSortArray(int[] nums) {
        int n = nums.length;

        // Copy the original array to values
        int[] values = Arrays.copyOf(nums, n);

        // First Pass: Iterate from left to right
        // Goal: Move the maximum value of each segment as far right as possible
        for (int i = 0; i < n - 1; i++) {
            if (values[i] <= values[i + 1]) continue;

            // Return false if they cannot be swapped
            if (Integer.bitCount(values[i]) != Integer.bitCount(values[i + 1])) {
                return false;
            }

            // Count the number of set bits using Integer.bitCount
            // Swap them if they have the same number of set bits
            int temp = values[i];
            values[i] = values[i + 1];
            values[i + 1] = temp;
        }

        // Second Pass: Iterate from right to left
        // Goal: Move the minimum value of each segment as far left as possible
        for (int i = n - 1; i >= 1; i--) {
            if (values[i] >= values[i - 1]) continue;

            // Return false if they cannot be swapped
            if (Integer.bitCount(values[i]) != Integer.bitCount(values[i - 1])) {
                return false;
            }

            // Count the number of set bits using Integer.bitCount
            // Swap them if they have the same number of set bits
            int temp = values[i];
            values[i] = values[i - 1];
            values[i - 1] = temp;
        }

        // If both passes complete without returning false, the array can be sorted
        return true;
    }
}
