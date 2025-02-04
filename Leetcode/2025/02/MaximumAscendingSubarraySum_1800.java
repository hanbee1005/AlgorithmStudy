package array;

public class MaximumAscendingSubarraySum_1800 {
    public static void main(String[] args) {
        System.out.println(maxAscendingSum(new int[]{10,20,30,5,10,50}));
        System.out.println(maxAscendingSum(new int[]{10,20,30,40,50}));
        System.out.println(maxAscendingSum(new int[]{12,17,15,13,10,11,12}));
        System.out.println(maxAscendingSum(new int[]{100,10,1}));
    }

    private static int maxAscendingSum(int[] nums) {
        int increasingSum = nums[0];
        int maxSum = nums[0];

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] < nums[i+1]) {
                increasingSum += nums[i+1];
            } else {
                increasingSum = nums[i+1];
            }

            maxSum = Math.max(maxSum, increasingSum);
        }

        return maxSum;
    }
}
