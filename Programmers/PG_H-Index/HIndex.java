package programmers;

import java.util.Arrays;

public class HIndex {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{0, 0, 0, 1}));
    }

    private static int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);
        for (int i = citations.length - 1; i >= 0; i--) {
            if (citations[i] > answer) {
                answer++;
            } else {
                break;
            }
        }
        return answer;
    }
}
