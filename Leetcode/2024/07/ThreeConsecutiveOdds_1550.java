package array;

public class ThreeConsecutiveOdds_1550 {
    public static void main(String[] args) {
        System.out.println(threeConsecutiveOdds(new int[]{2,6,4,1}));
        System.out.println(threeConsecutiveOdds(new int[]{1,2,34,3,4,5,7,23,12}));
    }

    private static boolean threeConsecutiveOdds(int[] arr) {
        int cnt = 0;
        for (int a : arr) {
            if (a % 2 == 1) {
                cnt++;
            } else {
                cnt = 0;
            }

            if (cnt == 3) return true;
        }

        return false;
    }
}
