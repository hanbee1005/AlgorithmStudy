package array;

import java.util.Arrays;

public class FindMissingAndRepeatedValues_2965 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(findMissingAndRepeatedValues(new int[][]{{1,3},{2,2}})));
        System.out.println(Arrays.toString(findMissingAndRepeatedValues(new int[][]{{9,1,7},{8,9,2},{3,4,6}})));
    }

    private static int[] findMissingAndRepeatedValues(int[][] grid) {
        int[] answer = new int[2];
        int[] nums = new int[grid.length * grid.length + 1];
        for (int[] row : grid) {
            for (int col : row) {
                nums[col]++;
            }
        }

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == 2) answer[0] = i;
            if (nums[i] == 0) answer[1] = i;
        }

        return answer;
    }
}
