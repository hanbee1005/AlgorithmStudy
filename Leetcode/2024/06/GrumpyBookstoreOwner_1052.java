package search;

public class GrumpyBookstoreOwner_1052 {
    public static void main(String[] args) {
        System.out.println(maxSatisfied(new int[]{1,0,1,2,1,1,7,}, new int[]{0,1,0,1,0,1,0,1}, 3));
        System.out.println(maxSatisfied(new int[]{1}, new int[]{0}, 1));
    }

    private static int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int n = grumpy.length;
        int i = 0;
        int curWin = 0;
        int maxWin = 0;

        // 참기 기능을 통해 만족한 애들(원래 불만족) 애들의 최대 값 구하기
        for (int j = 0; j < n; j++) {
            curWin += customers[j] * grumpy[j];
            maxWin = Math.max(curWin, maxWin);
            if (j >= minutes - 1) { // 참기 기간을 벗어난 경우
                curWin -= customers[i] * grumpy[i++];
            }
        }

        int answer = maxWin;
        // 원래부터 만족했던 애들 더하기
        for (i = 0; i < grumpy.length; i++) {
            answer += customers[i] * (1 - grumpy[i]);
        }

        return answer;
    }
}
