package bit;

import java.util.Arrays;

public class MaximumXORForEachQuery_1829 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(getMaximumXor(new int[]{0,1,1,3}, 2)));
        System.out.println(Arrays.toString(getMaximumXor(new int[]{2,3,4,7}, 3)));
        System.out.println(Arrays.toString(getMaximumXor(new int[]{0,1,2,2,5,7}, 3)));
    }

    private static int[] getMaximumXor(int[] nums, int maximumBit) {
        int n = nums.length;
        int xorr = nums[0];
        int maxXor = (1 << maximumBit) - 1;

        for (int i = 1; i < n; i++) {
            xorr ^= nums[i];
        }

        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = xorr ^ maxXor;
            xorr ^= nums[n - 1 - i];
        }

        return ans;
    }
}
