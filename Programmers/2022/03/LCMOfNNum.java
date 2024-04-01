package Mar2022;

import java.util.Arrays;

public class LCMOfNNum {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{2,6,8,14}));
    }

    private static int solution(int[] arr) {
        int answer = 0;

        Arrays.sort(arr);

        int i = 2;

        while(answer == 0) {
            int num = arr[arr.length - 1] * i;
            boolean isFound = true;

            for (int a : arr) {
                if (num % a != 0) {
                    isFound = false;
                    break;
                }
            }

            if (isFound) answer = num;
            else i++;
        }

        return answer;
    }
}
