package dynamicprogramming;

public class MaximumSubarray_53 {
    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
        System.out.println(maxSubArray(new int[]{1}));
        System.out.println(maxSubArray(new int[]{5,4,-1,7,8}));
    }

    private static int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int i = 0;
        int sum = 0;

        while (i < nums.length) {
            if (sum < 0 && nums[i] >= sum) {
                sum = 0;
            }

            sum += nums[i];
            max = Math.max(max, sum);
            i++;
        }

        return max;
    }
}
