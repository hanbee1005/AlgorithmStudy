package array;

import java.util.List;

public class MaximumDistanceInArrays_624 {
    public static void main(String[] args) {
        System.out.println(maxDistance(List.of(List.of(1,2,3), List.of(4,5), List.of(1,2,3))));
        System.out.println(maxDistance(List.of(List.of(1), List.of(1))));
    }

    private static int maxDistance(List<List<Integer>> arrays) {
        int min = Integer.MAX_VALUE;
        int minIdx = -1;
        int secMin = min;

        int max = Integer.MIN_VALUE;
        int maxIdx = -1;
        int secMax = max;

        for (int i = 0; i < arrays.size(); i++) {
            List<Integer> arr = arrays.get(i);
            int curMin = arr.get(0);
            int curMax = arr.get(arr.size() - 1);

            if (min > curMin) {
                secMin = min;
                min = curMin;
                minIdx = i;
            } else if (secMin > curMin) {
                secMin = curMin;
            }

            if (max < curMax) {
                secMax = max;
                max = curMax;
                maxIdx = i;
            } else if (secMax < curMax) {
                secMax = curMax;
            }
        }

        return minIdx == maxIdx ? Math.max(max - secMin, secMax - min) : max - min;
    }
}
