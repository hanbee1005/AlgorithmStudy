package array;

public class FindLuckyIntegerInAnArray_1394 {
    public static void main(String[] args) {
        System.out.println(findLucky(new int[]{2,2,3,4}));
        System.out.println(findLucky(new int[]{1,2,2,3,3,3}));
        System.out.println(findLucky(new int[]{2,2,2,3,3}));
        System.out.println(findLucky(new int[]{5,4,7,8,4,8,8,3,7,7,6,3,7,6,5,6,8,4,5,7,4,7,7,5,2,5,6,6,8,1,6,8,8,8,9,3,2,9}));
    }

    private static int findLucky(int[] arr) {
        int answer = -1;
        int[] nums = new int[501];

        for (int n : arr) {
            nums[n]++;
        }

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == i) {
                answer = Math.max(answer, i);
            }
        }

        return answer;
    }
}
