package greedy;

import java.util.Arrays;

public class DivideArrayIntoArraysWithMaxDifference_2966 {
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(divideArray(new int[]{1,3,4,8,7,9,3,5,1}, 2)));
        System.out.println(Arrays.deepToString(divideArray(new int[]{2,4,2,2,5,2}, 2)));
        System.out.println(Arrays.deepToString(divideArray(new int[]{4,2,9,8,2,12,7,12,10,5,8,5,5,7,9,2,5,11}, 14)));
    }

    private static int[][] divideArray(int[] nums, int k) {
        Arrays.sort(nums);
        int[][] answer = new int[nums.length / 3][3];
        for (int i = 0; i < nums.length; i += 3) {

            if (nums[i + 2] - nums[i] > k) {
                return new int[0][0];
            }

            answer[i / 3] = new int[]{nums[i], nums[i + 1], nums[i + 2]};
        }

        return answer;
    }
}
