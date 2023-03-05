package dynamicprogramming;

public class BestTimeToBuyAndSellStock_121 {
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(maxProfit(new int[]{7, 6, 4, 3, 1}));
    }

    private static int maxProfit(int[] prices) {
        int buy = 10001;
        int max = 0;

        for (int price : prices) {
            if (price < buy) {
                buy = price;
            }

            max = Math.max(max, price - buy);
        }

        return max;
    }
}
