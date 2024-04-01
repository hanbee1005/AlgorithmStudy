package Jan2022;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class LottoHighestAndLowestRank {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{44, 1, 0, 0, 31, 25}, new int[]{31, 10, 45, 1, 6, 19})));
    }

    private static int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];

        int zeroCount = 0;
        for (int lotto : lottos) {
            if (lotto == 0) zeroCount++;
        }

        Set<Integer> winNums = Arrays.stream(win_nums).boxed().collect(Collectors.toSet());
        Set<Integer> lottoNums = Arrays.stream(lottos).boxed().collect(Collectors.toSet());

        winNums.retainAll(lottoNums);  // 맞은 갯수

        answer[0] = Math.max(7 - ((zeroCount + winNums.size()) == 0 ? 1 : (zeroCount + winNums.size())), 1);
        answer[1] = Math.min(7 - winNums.size(), 6);

        return answer;
    }
}
