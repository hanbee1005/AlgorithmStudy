package hashmap;

import java.util.Arrays;

public class FindThePrefixCommonArrayOfTwoArrays_2657 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(findThePrefixCommonArray(new int[]{1,3,2,4}, new int[]{3,1,2,4})));
        System.out.println(Arrays.toString(findThePrefixCommonArray(new int[]{2,3,1}, new int[]{3,1,2})));
    }

    private static int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int[] answer = new int[n];
        int[] cnt = new int[n + 1];
        int max = 0;
        for (int i = 0; i < n; i++) {
            if (++cnt[A[i]] == 2) max++;
            if (++cnt[B[i]] == 2) max++;
            answer[i] = max;
        }

        return answer;
    }
}
