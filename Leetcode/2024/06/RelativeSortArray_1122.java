package array;

import java.util.*;

public class RelativeSortArray_1122 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(relativeSortArray(new int[]{2,3,1,3,2,4,6,7,9,2,19}, new int[]{2,1,4,3,9,6})));
        System.out.println(Arrays.toString(relativeSortArray(new int[]{28,6,22,8,44,17}, new int[]{22,28,8,6})));
    }

    private static int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] freq = new int[1001];

        for (int n : arr1) {
            freq[n]++;
        }

        int[] ans = new int[arr1.length];

        int idx = 0;
        for(int num: arr2) {
            while(freq[num] > 0) {
                ans[idx++] = num;
                freq[num]--;
            }
        }

        for(int i = 0; i < freq.length; i++) {
            while(freq[i] > 0) {
                ans[idx++] = i;
                freq[i]--;
            }
        }

        return ans;
    }
}
