package greedy;

import java.util.Arrays;

public class MinimumDifferenceBetweenLargestAndSmallestValueInThreeMoves_1509 {
    public static void main(String[] args) {
        System.out.println(minDifference(new int[]{5,3,2,4}));
        System.out.println(minDifference(new int[]{1,5,0,10,14}));
        System.out.println(minDifference(new int[]{3,100,20}));
        System.out.println(minDifference(new int[]{6,6,0,1,1,4,6}));
    }

    private static int minDifference(int[] nums) {
        if (nums.length <= 4) return 0;

        int answer = 2000000000;

        Arrays.sort(nums);
        int s = 0;
        int e = nums.length - 4;
        while (e < nums.length) {
            answer = Math.min(answer, nums[e] - nums[s]);
            s++;
            e++;
        }

        return answer;
    }
}
