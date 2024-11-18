package array;

import java.util.Arrays;

public class DefuseTheBomb_1652 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(decrypt(new int[]{5, 7, 1, 4}, 3)));
        System.out.println(Arrays.toString(decrypt(new int[]{1, 2, 3, 4}, 0)));
        System.out.println(Arrays.toString(decrypt(new int[]{2, 4, 9, 3}, -2)));
    }

    private static int[] decrypt(int[] code, int k) {
        int n = code.length;
        int[] answer = new int[n];
        int start = 0, end = 0;

        if (k == 0) return answer;

        if (k > 0) {
            start = 1;
            end = k ;
        } else {
            start = n - Math.abs(k);
            end = n - 1;
        }

        int sum = 0;
        for (int i = start; i <= end; i++) {
            sum += code[i];
        }

        for (int i = 0; i < n; i++) {
            answer[i] = sum ;
            sum -= code[(start) % n];
            sum += code[(end + 1) % n];
            start++;
            end++;
        }

        return answer;
    }
}
