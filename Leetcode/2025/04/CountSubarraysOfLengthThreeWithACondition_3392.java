package array;

public class CountSubarraysOfLengthThreeWithACondition_3392 {
    public static void main(String[] args) {
        System.out.println(countSubarrays(new int[]{1,2,1,4,1}));
        System.out.println(countSubarrays(new int[]{1,1,1}));
    }

    private static int countSubarrays(int[] nums) {
        int answer = 0;

        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i+1] % 2 == 0 && nums[i] + nums[i+2] == nums[i+1]/2) {
                answer++;
            }
        }

        return answer;
    }
}
