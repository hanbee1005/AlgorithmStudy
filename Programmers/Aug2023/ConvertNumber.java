package Aug2023;

import java.util.Arrays;

/**
 * Level 2. 숫자 변환하기
 */
public class ConvertNumber {
    public static void main(String[] args) {
        System.out.println(solution(10, 40, 5));
        System.out.println(solution(38, 40, 2));
    }

    private static int solution(int x, int y, int n) {
        int answer = 0;

        int[] arr = new int[y + 1];
        Arrays.fill(arr, Integer.MAX_VALUE);
        arr[x] = 0;

        for (int i = x; i < arr.length; i++) {
            if (i == x || arr[i] != Integer.MAX_VALUE) {
                if (i + n <= y) arr[i + n] = Math.min(arr[i] + 1, arr[i + n]);
                if (i * 2 <= y) arr[i * 2] = Math.min(arr[i] + 1, arr[i * 2]);
                if (i * 3 <= y) arr[i * 3] = Math.min(arr[i] + 1, arr[i * 3]);
            }
        }

        if (arr[y] != Integer.MAX_VALUE) return arr[y]; else return -1;
    }
}
