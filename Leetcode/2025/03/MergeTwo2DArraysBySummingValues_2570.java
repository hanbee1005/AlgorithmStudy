import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeTwo2DArraysBySummingValues_2570 {
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(mergeArrays(new int[][]{{1,2},{2,3},{4,5}}, new int[][]{{1,4},{3,2},{4,1}})));
        System.out.println(Arrays.deepToString(mergeArrays(new int[][]{{2,4},{3,6},{5,5}}, new int[][]{{1,3},{4,3}})));
    }

    private static int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        int m = nums1.length, n = nums2.length;
        int i = 0, j = 0;
        List<int[]> result = new ArrayList<>();

        while (i < m && j < n) {
            if (nums1[i][0] == nums2[j][0]) {
                result.add(new int[]{nums1[i][0], nums1[i][1] + nums2[j][1]});
                i++; j++;
            } else if (nums1[i][0] < nums2[j][0]) {
                result.add(nums1[i]);
                i++;
            } else {
                result.add(nums2[j]);
                j++;
            }
        }

        while (i < m) {
            result.add(nums1[i]);
            i++;
        }

        while (j < n) {
            result.add(nums2[j]);
            j++;
        }

        return result.toArray(new int[result.size()][]);
    }
}
