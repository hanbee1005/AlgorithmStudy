package array;

import java.util.Arrays;

public class IntersectionOfTwoArrayII_350 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(intersect(new int[]{1, 2, 2, 1}, new int[]{2, 2})));
        System.out.println(Arrays.toString(intersect(new int[]{4,9,5}, new int[]{9,4,9,8,4})));
        System.out.println(Arrays.toString(intersect(new int[]{1,2,2,1}, new int[]{2})));
    }

    private static int[] intersect(int[] nums1, int[] nums2) {
        int[] nums = new int[1001];
        int[] answer = new int[1000];

        for (int n1 : nums1) {
            nums[n1]++;
        }

        int idx = 0;
        for (int n2 : nums2) {
            if (nums[n2]-- > 0) {
                answer[idx++] = n2;
            }
        }

        return Arrays.copyOf(answer, idx);
    }
}
