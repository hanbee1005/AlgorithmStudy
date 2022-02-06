package Feb2022;

import java.util.Arrays;

public class Budget {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{1,3,2,5,4}, 9));
    }

    private static int solution(int[] d, int budget) {
        int answer = 0;

        Arrays.sort(d);

        int sum = 0;
        for(int i = 0; i < d.length; i++) {
            sum += d[i];
            if (sum > budget) break;
            answer++;
        }

        return answer;
    }
}
