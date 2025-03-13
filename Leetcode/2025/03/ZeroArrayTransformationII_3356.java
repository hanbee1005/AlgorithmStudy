package prefixsum;

public class ZeroArrayTransformationII_3356 {
    public static void main(String[] args) {
        System.out.println(minZeroArray(new int[]{2,0,2}, new int[][]{{0,2,1},{0,2,1},{1,1,3}}));
        System.out.println(minZeroArray(new int[]{4,3,2,1}, new int[][]{{1,3,2},{0,2,1}}));
    }

    private static int minZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int sum = 0, queryCount = 0;
        int[] diffArray = new int[n + 1];

        for (int i = 0; i < n; i++) {
            while (sum + diffArray[i] < nums[i]) {
                queryCount++;
                if (queryCount > queries.length) return -1;

                int left = queries[queryCount - 1][0];
                int right = queries[queryCount - 1][1];
                int value = queries[queryCount - 1][2];

                if (right >= i) {
                    diffArray[Math.max(left, i)] += value;
                    if (right + 1 < diffArray.length) {
                        diffArray[right + 1] -= value;
                    }
                }
            }
            sum += diffArray[i];
        }
        return queryCount;
    }
}
