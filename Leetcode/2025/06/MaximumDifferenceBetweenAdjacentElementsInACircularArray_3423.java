package array;

public class MaximumDifferenceBetweenAdjacentElementsInACircularArray_3423 {
    public static void main(String[] args) {
        System.out.println(maxAdjacentDistance(new int[]{1,2,4}));
        System.out.println(maxAdjacentDistance(new int[]{-5,-10,-5}));
    }

    private static int maxAdjacentDistance(int[] nums) {
        int n = nums.length;
        int answer = Math.abs(nums[0] - nums[n - 1]);

        for (int i = 0; i < n - 1; ++i) {
            answer = Math.max(answer, Math.abs(nums[i] - nums[i + 1]));
        }

        return answer;
    }
}
