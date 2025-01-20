package hashmap;

public class FirstCompletelyPaintedRowOrColumn_2661 {
    public static void main(String[] args) {
        System.out.println(firstCompleteIndex(new int[]{1,3,4,2}, new int[][]{{1,4}, {2,3}}));
        System.out.println(firstCompleteIndex(new int[]{2,8,7,4,1,3,5,6,9}, new int[][]{{3,2,5},{1,4,6},{8,7,9}}));
        System.out.println(firstCompleteIndex(new int[]{1,4,5,2,6,3}, new int[][]{{4,3,5},{1,2,6}}));
    }

    private static int firstCompleteIndex(int[] arr, int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int[] rowMat = new int[n * m + 1];
        int[] colMat = new int[n * m + 1];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                int num = mat[i][j];
                rowMat[num] = i;
                colMat[num] = j;
            }
        }

        int[] row = new int[n];
        int[] col = new int[m];

        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            row[rowMat[num]]++;
            col[colMat[num]]++;

            if (row[rowMat[num]] >= m || col[colMat[num]] >= n) {
                return i;
            }
        }

        return arr.length - 1;
    }
}
