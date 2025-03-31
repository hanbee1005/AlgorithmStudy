import java.util.Arrays;

public class ApplyOperationsToAnArray_2460 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(applyOperations(new int[]{1, 2, 2, 1, 1, 0})));
        System.out.println(Arrays.toString(applyOperations(new int[]{0, 1})));
    }

    private static int[] applyOperations(int[] nums) {
        if (nums.length == 1) return nums;

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                nums[i] *= 2;
                nums[i + 1] = 0;
            }
        }

        int[] answer = new int[nums.length];
        int idx = 0;

        for (int num : nums) {
            if (num != 0) {
                answer[idx++] = num;
            }
        }

        return answer;
    }
}
