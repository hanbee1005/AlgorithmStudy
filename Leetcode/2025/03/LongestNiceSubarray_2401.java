package bit;

public class LongestNiceSubarray_2401 {
    public static void main(String[] args) {
        System.out.println(longestNiceSubarray(new int[]{1,3,8,48,10}));
        System.out.println(longestNiceSubarray(new int[]{3,1,5,11,13}));
    }

    private static int longestNiceSubarray(int[] nums) {
        int maxLength = 1;
        int left = 0;
        int usedBits = 0;

        for (int right = 0; right < nums.length; right++) {
            while ((usedBits & nums[right]) != 0) {
                usedBits ^= nums[left];
                left++;
            }

            usedBits |= nums[right];
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}
