package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SortTheJumbledNumbers_2191 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortJumbled(new int[]{8, 9, 4, 0, 2, 1, 3, 5, 7, 6}, new int[]{991, 338, 38})));
        System.out.println(Arrays.toString(sortJumbled(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9}, new int[]{789, 456, 123})));
    }

    private static int[] sortJumbled(int[] mapping, int[] nums) {
        List<int[]> storePairs = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int mappedValue = 0;
            int temp = nums[i];
            int place = 1;

            if (temp == 0) {
                storePairs.add(new int[]{mapping[0], i});
                continue;
            }

            while (temp != 0) {
                mappedValue = place * mapping[temp % 10] + mappedValue;
                place *= 10;
                temp /= 10;
            }

            storePairs.add(new int[]{mappedValue, i});
        }

        storePairs.sort((a, b) -> a[0] - b[0]);

        int[] answer = new int[nums.length];
        for (int i = 0; i < storePairs.size(); i++) {
            answer[i] = nums[storePairs.get(i)[1]];
        }

        return answer;
    }
}
