package dynamicprogramming;

public class BestTimeToBuyAndSellStockII_122 {
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7,1,5,3,6,4}));
    }

    private static int maxProfit(int[] prices) {
        int l = 0;
        int r = 1;

        int max = 0;

        while (r < prices.length) {
            if (prices[l] < prices[r]) {
                max += prices[r] - prices[l];
                l++;
            } else {
                l = r;
            }

            r++;
        }

        return max;
    }
}
