package bit;

public class LongestSubarrayWithMaximumBitwiseAND_2419 {
    public static void main(String[] args) {
        System.out.println(longestSubarray(new int[]{1,2,3,3,2,2}));
        System.out.println(longestSubarray(new int[]{1,2,3,4}));
        System.out.println(longestSubarray(new int[]{311155,311155,311155,311155,311155,311155,311155,311155,201191,311155}));
    }

    private static int longestSubarray(int[] nums) {
        int max = 0;
        // 최댓값 찾기
        for (int num : nums) {
            max = Math.max(max, num);
        }

        int maxLen = 0;
        int currentLen = 0;

        for (int num : nums) {
            if (num == max) {
                currentLen++;
                maxLen = Math.max(maxLen, currentLen);
            } else {
                currentLen = 0;
            }
        }

        return maxLen;
    }
}
