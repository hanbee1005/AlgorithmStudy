package array;

import java.util.Arrays;

public class SetMismatch_645 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(findErrorNums(new int[]{1,2,2,4})));
        System.out.println(Arrays.toString(findErrorNums(new int[]{1,1})));
    }

    private static int[] findErrorNums(int[] nums) {
        int[] findNums = new int[nums.length + 1];
        for (int num : nums) {
            findNums[num]++;
        }

        int[] answer = new int[2];

        for (int i = 1; i < findNums.length; i++) {
            if (findNums[i] == 2) answer[0] = i;
            if (findNums[i] == 0) answer[1] = i;
        }

        return answer;
    }
}
