package Feb2024;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Level 1. 가장 많이 받은 선물
 */
public class TheMostGiftedGift {
    public static void main(String[] args) {
        System.out.println(solution(new String[]{"muzi", "ryan", "frodo", "neo"},
                new String[]{"muzi frodo", "muzi frodo", "ryan muzi", "ryan muzi", "ryan muzi", "frodo muzi", "frodo ryan", "neo muzi"}));
        System.out.println(solution(new String[]{"joy", "brad", "alessandro", "conan", "david"},
                new String[]{"alessandro brad", "alessandro joy", "alessandro conan", "david alessandro", "alessandro david"}));
        System.out.println(solution(new String[]{"a", "b", "c"}, new String[]{"a b", "b a", "c a", "a c", "a c", "c a"}));
    }

    private static int solution(String[] friends, String[] gifts) {
        int answer = 0;

        int len = friends.length;

        Map<String, Integer> friendsOrder = new HashMap<>();
        for (int i = 0; i < len; i++) {
            friendsOrder.put(friends[i], i);
        }

        int[][] giftStatus = new int[len][len];
        int[] giftIndex = new int[len];

        for (String gift : gifts) {
            String[] sr = gift.split(" ");
            int sender = friendsOrder.get(sr[0]);
            int receiver = friendsOrder.get(sr[1]);

            giftStatus[sender][receiver] += 1;
            giftIndex[sender] += 1;
            giftIndex[receiver] -= 1;
        }

        int[] next = new int[len];
        for (int i = 0; i < len - 1; i++) {
            for (int j = i; j < len; j++) {
                next[i] += giftStatus[i][j] > giftStatus[j][i] ? 1
                        : (giftStatus[i][j] == giftStatus[j][i] && giftIndex[i] > giftIndex[j]) ? 1 : 0;
                next[j] += giftStatus[i][j] < giftStatus[j][i] ? 1
                        : (giftStatus[i][j] == giftStatus[j][i] && giftIndex[i] < giftIndex[j]) ? 1 : 0;
            }
        }

        answer = Arrays.stream(next).max().orElse(0);
        return answer;
    }
}
