package Sep2023;

import java.util.Arrays;

/**
 * Top Coder StockHistory SRM232 Div 2 Level 3
 */
public class TopCoderStockHistory {
    public static void main(String[] args) {
        System.out.println(maximumEarnings(1000, 0, new String[]{"10 20 30", "15 24 32"}));
        System.out.println(maximumEarnings(1000, 0, new String[]{"10", "9"}));
        System.out.println(maximumEarnings(100, 20, new String[]{"40 50 60", "37 48 55", "100 48 50",
                                                                                                "105 48 47", "110 50 52", "110 50 52",
                                                                                                "110 51 54", "109 49 53"}));
    }

    private static int maximumEarnings(int initialInvestment, int monthlyContribution, String[] stockPrice) {
        int month = stockPrice.length;
        int corp = stockPrice[0].split(" ").length;

        int[][] stocks = new int[month][corp];
        for (int i = 0; i < stockPrice.length; i++) {
            stocks[i] = Arrays.stream(stockPrice[i].split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        boolean[] buy = new boolean[stockPrice.length - 1];
        double[] proportion = new double[stockPrice.length - 1];

        double maxProportion = 0;

        // 반복문을 역으로 돌려 거슬러 올라가면서
        // 각 월까지의 최대 증가율을 사야 하는지 기록합니다.
        for (int i = month - 2; i >= 0; i--) {
            for (int j = 0; j < corp; j++) {
                double d = ((double) stocks[month - 1][j] / stocks[i][j]) - 1;
                if (d >= maxProportion) {
                    buy[i] = true;
                    maxProportion = d;
                    proportion[i] = maxProportion;
                }
            }
        }

        int money = initialInvestment;
        double answer = 0;

        // 처음부터 시작해서 사야 하는 달이 오면 모든 자금을 투자합니다.
        for (int i = 0; i < buy.length; i++) {
            if (buy[i]) {
                answer += money * proportion[i];
                money = 0;
            }

            money += monthlyContribution;
        }

        return (int) Math.round(answer);
    }
}
