package search;

public class MinimumNumberOfDaysToMakeMBouquets_1482 {
    public static void main(String[] args) {
        System.out.println(minDays(new int[]{1,10,3,10,2}, 3, 1));
        System.out.println(minDays(new int[]{1,10,3,10,2}, 3, 2));
        System.out.println(minDays(new int[]{7,7,7,7,12,7,7}, 2, 3));
    }

    private static int minDays(int[] bloomDay, int m, int k) {
        if (bloomDay.length < (long)m * (long)k) return -1;

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int bd : bloomDay) {
            min = Math.min(min, bd);
            max = Math.max(max, bd);
        }

        while (min <= max) {
            int mid = (min + max) / 2;

            if (makeBouquet(bloomDay, mid, m, k)) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }

        return min;
    }

    private static boolean makeBouquet(int[] bloomDay, int day, int m, int k) {
        int count = 0;
        int adjacent = 0;
        for (int bd : bloomDay) {
            if (bd <= day) {
                adjacent++;

                if (adjacent == k) {
                    count++;
                    adjacent = 0;
                }
            } else {
                adjacent = 0;
            }

            if (count >= m) return true;
        }

        return false;
    }
}
