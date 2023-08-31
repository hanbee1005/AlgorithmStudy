package Aug2023;

import java.util.Arrays;

/**
 * Level 2. 연속된 부분 수열의 합
 */
public class SumOfSuccessivePartialSequences {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{1, 2, 3, 4, 5}, 7)));
        System.out.println(Arrays.toString(solution(new int[]{1, 1, 1, 2, 3, 4, 5}, 5)));
        System.out.println(Arrays.toString(solution(new int[]{2, 2, 2, 2, 2}, 6)));
    }

    private static int[] solution(int[] sequence, int k) {
        int[] answer = new int[]{0, sequence.length - 1};

        int left = 0;
        int right = 1;

        int sum = sequence[left];

        while (left < right) {
            if (sum == k) {
                if (right - 1 - left < answer[1] - answer[0]) {
                    answer[0] = left;
                    answer[1] = right - 1;
                }
                sum -= sequence[left++];
            } else if (sum > k) {
                sum -= sequence[left++];
            } else if (right < sequence.length) {
                sum += sequence[right++];
            } else  {
                break;
            }
        }

        return answer;
    }
}
