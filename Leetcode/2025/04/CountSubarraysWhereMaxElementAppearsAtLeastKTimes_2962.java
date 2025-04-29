package array;

public class CountSubarraysWhereMaxElementAppearsAtLeastKTimes_2962 {
    public static void main(String[] args) {
        System.out.println(countSubarrays(new int[]{1,3,2,3,3}, 2));
        System.out.println(countSubarrays(new int[]{1,4,2,1}, 3));
    }

    private static long countSubarrays(int[] nums, int k) {
        int max = 0;
        int count = 0;

        for (int num : nums) {
            if (max < num) {
                max = num;
                count = 1;
            } else if (max == num) {
                count++;
            }
        }

        if (count < k) return 0;

        int left = 0;
        long maxCount = 0;
        long answer = 0;
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == max) maxCount++;
            while (maxCount >= k) {
                if (nums[left] == max) maxCount--;
                left++;
            }
            answer += left;
        }

        return answer;
    }
}
