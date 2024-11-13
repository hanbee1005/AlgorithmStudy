package search;

import java.util.Arrays;

public class CountTheNumberOfFairPairs_2563 {
    public static void main(String[] args) {
        System.out.println(countFairPairs(new int[]{0,1,7,4,4,5}, 3, 6));
        System.out.println(countFairPairs(new int[]{1,7,9,2,5}, 11, 11));
    }

    private static long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        return countLess(nums, upper) - countLess(nums, lower - 1);
    }

    private static long countLess(int[] nums, int sum) {
        long answer = 0;
        for (int i = 0, j = nums.length - 1; i < j; ++i) {
            while (i < j && nums[i] + nums[j] > sum) {
                --j;
            }
            answer += j - i;
        }
        return answer;
    }
}
