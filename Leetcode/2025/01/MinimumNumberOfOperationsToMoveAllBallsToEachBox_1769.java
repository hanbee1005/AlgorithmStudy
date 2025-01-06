package string;

import java.util.Arrays;

public class MinimumNumberOfOperationsToMoveAllBallsToEachBox_1769 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(minOperations("110")));
        System.out.println(Arrays.toString(minOperations("001011")));
    }

    private static int[] minOperations(String boxes) {
        char[] ch = boxes.toCharArray();
        int n = boxes.length();
        int right = 0;
        int left = 0;
        int all = 0;

        for (int i = 0; i < n; i++){
            if(ch[i] == '1') {
                all += i;
                right++;
            }
        }

        int[] answer = new int[n];
        answer[0] = all;
        if(ch[0] == '1') {
            left++;
            right--;
        }

        for (int i = 1; i < n; i++) {
            all = all - right;
            all = all + left;

            if(ch[i] == '1') {
                right--;
                left++;
            }

            answer[i] = all;
        }

        return answer;
    }
}
