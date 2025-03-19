package bit;

public class MinimumOperationsToMakeBinaryArrayElementsEqualToOneI_3191 {
    public static void main(String[] args) {
        System.out.println(minOperations(new int[]{0,1,1,1,0,0}));
        System.out.println(minOperations(new int[]{0,1,1,1}));
    }

    private static int minOperations(int[] nums) {
        int n = nums.length;
        int count = 0;
        for (int i = 0; i < n - 2; i++) {
            if (nums[i] == 1) {
                continue;
            }

            nums[i] = nums[i] ^ 1;
            nums[i + 1] = nums[i + 1] ^ 1;
            nums[i + 2] = nums[i + 2] ^ 1;
            count++;
        }

        if (nums[n - 2] == 0 || nums[n - 1] == 0) return -1;

        return count;
    }
}
