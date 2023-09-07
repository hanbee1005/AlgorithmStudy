package Sep2023;

import java.util.*;

/**
 * Level 2. 이모티콘 할인 행사
 */
public class DiscountEventForEmoticons {
    private static int[] answer = new int[2];
    private static List<int[]> allCaseDiscountRate = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[][]{{40, 10000}, {25, 10000}}, new int[]{7000, 9000})));
    }

    private static int[] solution(int[][] users, int[] emoticons) {
        allCasesOfDiscountRate(new int[]{10, 20, 30, 40}, new int[emoticons.length], 0);

        for (int[] discountRate : allCaseDiscountRate) {
            int[][] us = new int[users.length][];
            for (int i = 0; i < users.length; i++) {
                us[i] = Arrays.copyOf(users[i], users[i].length);
            }

            int numberOfMembership = 0;
            int sellAmount = 0;

            for (int[] user : us) {
                int purchaseAmount = 0;
                for (int i = 0; i < discountRate.length; i++) {
                    if (user[0] <= discountRate[i]) {
                        purchaseAmount += (int) (emoticons[i] * ((100 - discountRate[i]) * 0.01));
                    }
                }

                if (user[1] - purchaseAmount <= 0) {
                    numberOfMembership++;
                } else {
                    sellAmount += purchaseAmount;
                }
            }

            if (answer[0] < numberOfMembership || (answer[0] == numberOfMembership && answer[1] < sellAmount)) {
                answer[0] = numberOfMembership;
                answer[1] = sellAmount;
            }
        }

        return answer;
    }

    private static void allCasesOfDiscountRate(int[] discountRateAllCases, int[] discountRate, int depth) {
        if (discountRate.length == depth) {
            allCaseDiscountRate.add(Arrays.copyOf(discountRate, discountRate.length));
            return;
        }

        for (int discountRateAllCase : discountRateAllCases) {
            discountRate[depth] = discountRateAllCase;
            allCasesOfDiscountRate(discountRateAllCases, discountRate, depth + 1);
        }
    }
}
