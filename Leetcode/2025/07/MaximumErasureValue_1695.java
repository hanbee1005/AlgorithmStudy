package hashmap;

public class MaximumErasureValue_1695 {
    public static void main(String[] args) {
        System.out.println(maximumUniqueSubarray(new int[]{4,2,4,5,6}));
        System.out.println(maximumUniqueSubarray(new int[]{5,2,1,2,5,2,1,2,5}));
        System.out.println(maximumUniqueSubarray(new int[]{10000,1,10000,1,1,1,1,1,1}));
    }

    private static int maximumUniqueSubarray(int[] nums) {
        boolean[] seen = new boolean[10001];
        int left = 0;
        int currentSum = 0;
        int maxSum = 0;

        for (int num : nums) {
            while (seen[num]) {
                currentSum -= nums[left];
                seen[nums[left]] = false;
                left++;
            }
            currentSum += num;
            seen[num] = true;
            if (currentSum > maxSum) {
                maxSum = currentSum;
            }
        }

        return maxSum;
    }
}
