package Mar2022;

import java.util.Arrays;

public class MakeMin {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 2}, new int[]{3, 4}));
    }

    private static int solution(int []A, int []B) {
        Arrays.sort(A);
        Arrays.sort(B);

        int answer = 0;
        for (int i = 0; i < A.length; i++) {
            answer += A[i] * B[(B.length - 1) - i];
        }

        return answer;
    }
}
