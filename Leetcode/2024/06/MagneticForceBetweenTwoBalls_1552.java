package search;

import java.util.Arrays;

public class MagneticForceBetweenTwoBalls_1552 {
    public static void main(String[] args) {
        System.out.println(maxDistance(new int[]{1,2,3,4,7}, 3));
        System.out.println(maxDistance(new int[]{5,4,3,2,1,1000000000}, 2));
    }

    private static int maxDistance(int[] position, int m) {
        Arrays.sort(position);

        int low = 1;
        int high = position[position.length - 1] - position[0];

        while(low <= high) {
            int mid = (low + high) / 2;

            if(canPlace(position, m, mid)) {
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }

        return high;
    }

    private static boolean canPlace(int[] position, int m, int mid) {
        int placed = 1;
        int last = position[0];
        for(int i = 1; i < position.length; i++) {
            if(position[i] - last >= mid) {
                placed++;
                last = position[i];
            }
        }

        return placed >= m;
    }
}
