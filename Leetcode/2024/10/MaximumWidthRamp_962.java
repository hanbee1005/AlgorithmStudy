package stack;

public class MaximumWidthRamp_962 {
    public static void main(String[] args) {
        System.out.println(maxWidthRamp(new int[]{6,0,8,2,1,5}));
        System.out.println(maxWidthRamp(new int[]{9,8,1,0,1,9,4,0,4,1}));
    }

    private static int maxWidthRamp(int[] nums) {
        int[] maxOnRight = new int[nums.length];
        maxOnRight[nums.length - 1] = nums[nums.length - 1];

        for(int i = nums.length - 2; i >= 0; i--) {
            maxOnRight[i] = Math.max(maxOnRight[i + 1], nums[i]) ;
        }

        int maxRamp = 0;
        int left = 0, right = 0;
        while(right < nums.length) {
            while (left <= right && nums[left] > maxOnRight[right]) {
                left++;
            }
            maxRamp = Math.max(maxRamp, right - left);
            right++;
        }

        return maxRamp;
    }
}
