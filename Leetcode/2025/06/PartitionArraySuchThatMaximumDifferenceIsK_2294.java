package greedy;

import java.util.Arrays;

public class PartitionArraySuchThatMaximumDifferenceIsK_2294 {
    public static void main(String[] args) {
        System.out.println(partitionArray(new int[]{3,6,1,2,5}, 2));
        System.out.println(partitionArray(new int[]{1,2,3}, 1));
        System.out.println(partitionArray(new int[]{2,2,4,5}, 0));
    }

    private static int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);

        int answer = 0;
        int l = 0, r = 0;

        while (r < nums.length) {
            if (nums[r] - nums[l] <= k) {
                r++;
                continue;
            }

            answer++;
            l = r;
            r += 1;
        }

        if (r == nums.length) answer++;
        return answer;
    }
}
