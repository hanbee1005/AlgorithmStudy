package dynamicprogramming;

public class MaximumNumberOfPointsWithCost_1937 {
    public static void main(String[] args) {
        System.out.println(maxPoints(new int[][]{{1,2,3},{1,5,1},{3,1,1}}));
        System.out.println(maxPoints(new int[][]{{1,5},{2,3},{4,2}}));
        System.out.println(maxPoints(new int[][]{{1,5},{3,2},{4,2}}));
        System.out.println(maxPoints(new int[][]{{0,0,4,1,4},{2,1,2,0,1},{2,2,1,3,4},{5,2,4,5,4},{0,5,4,2,5}}));
        System.out.println(maxPoints(new int[][]{{4,3,2,1},{1,4,3,0},{0,0,1,5},{1,5,3,4},{0,3,3,4}}));
    }

    private static long maxPoints(int[][] points) {
        int cols = points[0].length;
        long[] currentRow = new long[cols], previousRow = new long[cols];

        for (int[] row : points) {
            // runningMax holds the maximum value generated in the previous iteration of each loop
            long runningMax = 0;

            // Left to right pass
            for (int col = 0; col < cols; ++col) {
                runningMax = Math.max(runningMax - 1, previousRow[col]);
                currentRow[col] = runningMax;
            }

            runningMax = 0;
            // Right to left pass
            for (int col = cols - 1; col >= 0; --col) {
                runningMax = Math.max(runningMax - 1, previousRow[col]);
                currentRow[col] = Math.max(currentRow[col], runningMax) + row[col];
            }

            // Update previousRow for next iteration
            previousRow = currentRow;
        }

        // Find maximum points in the last row
        long maxPoints = 0;
        for (int col = 0; col < cols; ++col) {
            maxPoints = Math.max(maxPoints, previousRow[col]);
        }

        return maxPoints;
    }
}
