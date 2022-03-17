package Mar2022;

import java.util.Arrays;

public class CountNumAfterQuadPress {
    private static int zero = 0;
    private static int one = 0;

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[][]{{1, 1, 0, 0}, {1, 0, 0, 0}, {1, 0, 0, 1}, {1, 1, 1, 1}})));
    }

    private static int[] solution(int[][] arr) {
        int[] answer = new int[2];

        backTracking(arr, 0, arr.length-1, 0, arr[0].length-1);
        answer[0] = zero;
        answer[1] = one;

        return answer;
    }

    private static void backTracking(int[][] arr, int startX, int endX, int startY, int endY) {
        int zeroOrOne = arr[startX][startY];
        boolean allCheck = true;

        loop:
        for(int x = startX; x < endX+1; x++) {
            for (int y = startY; y < endY+1; y++) {
                if (arr[x][y] != zeroOrOne) {
                    allCheck = false;
                    break loop;
                }
            }
        }

        if (allCheck) {
            if (zeroOrOne == 0) zero++;
            else one++;
            return;
        }


        backTracking(arr, startX, (startX+endX)/2, startY, (startY+endY)/2);
        backTracking(arr, startX, (startX+endX)/2, (startY+endY)/2+1, endY);
        backTracking(arr, (startX+endX)/2+1, endX, startY, (startY+endY)/2);
        backTracking(arr, (startX+endX)/2+1, endX, (startY+endY)/2+1, endY);
    }
}