package dynamicprogramming;

public class HouseRobberII_213 {
    public static void main(String[] args) {
        System.out.println(rob(new int[]{2,3,2}));
        System.out.println(rob(new int[]{1,2,3,1}));
        System.out.println(rob(new int[]{1,2,1,1}));
        System.out.println(rob(new int[]{0}));
        System.out.println(rob(new int[]{0,0}));
    }

    private static int rob(int[] nums) {
        int[] dpL = new int[nums.length];
        int[] dpR = new int[nums.length];

        dpL[0] = nums[0];
        dpR[0] = nums[nums.length - 1];

        if (nums.length > 1) {
            dpL[1] = Math.max(nums[0], nums[1]);
            dpR[1] = Math.max(nums[nums.length - 1], nums[nums.length - 2]);
        }

        for (int i = 2; i < nums.length; i++) {
            if (i == nums.length - 1) {
                dpL[i] = Math.max(dpL[i - 2], dpL[i - 1]);
                dpR[i] = Math.max(dpR[i - 2], dpR[i - 1]);
            } else {
                dpL[i] = Math.max(dpL[i - 2] + nums[i], dpL[i - 1]);
                dpR[i] = Math.max(dpR[i - 2] + nums[nums.length - (i + 1)], dpR[i - 1]);
            }
        }

        return Math.max(dpL[dpL.length - 1], dpR[dpR.length - 1]);
    }
}
