package dynamicprogramming;

import java.util.Arrays;

public class FillingBookcaseShelves_1105 {
    public static void main(String[] args) {
        System.out.println(minHeightShelves(new int[][]{{1,1},{2,3},{2,3},{1,1},{1,1},{1,1},{1,2}}, 4));
        System.out.println(minHeightShelves(new int[][]{{1,3},{2,4},{3,2}}, 6));
    }

    private static int minHeightShelves(int[][] books, int shelfWidth) {
        int[] dp = new int[books.length + 1];
        dp[books.length] = 0;
        for (int i = books.length - 1; i >= 0; i--) {
            int height = books[i][1];
            int width = books[i][0];
            dp[i] = height + dp[i + 1];
            for (int j = i + 1; j < books.length && (width+books[j][0] <= shelfWidth); j++) {
                height = Math.max(height, books[j][1]);
                width += books[j][0];
                dp[i] = Math.min(dp[i], height + dp[j+1]);
            }
        }
        return dp[0];
    }
}
