package array;

import java.util.Arrays;

public class RangeSumOfSortedSubarraySums_1508 {
    public static void main(String[] args) {
        System.out.println(rangeSum(new int[]{1,2,3,4}, 4, 1, 5));
        System.out.println(rangeSum(new int[]{1,2,3,4}, 4, 3, 4));
        System.out.println(rangeSum(new int[]{1,2,3,4}, 4, 1, 10));
    }

    private static int rangeSum(int[] nums, int n, int left, int right) {
        int[] arr= new int[n * (n + 1) / 2];
        for(int i = 0, k = 0; i < n; i++){
            int sum = 0;
            for(int j = i; j < n; j++){
                sum += nums[j];
                arr[k++] = sum;
            }
        }

        Arrays.sort(arr);
        int answer = 0;
        final int mod = (int)1e9+7;
        for(int i = left; i <= right; i++){
            answer = (answer + arr[i - 1]) % mod;
        }

        return answer;
    }
}
