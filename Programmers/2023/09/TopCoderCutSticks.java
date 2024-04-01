package Sep2023;

/**
 * Top Coder Cut Sticks SRM456 Div 1 Level 2 / Div 2 Level 3
 */
public class TopCoderCutSticks {
    public static void main(String[] args) {
        System.out.println(maxKth(new int[]{5, 8}, 1, 1));
        System.out.println(maxKth(new int[]{5, 8}, 1, 2));
        System.out.println(maxKth(new int[]{5, 8}, 1, 3));
        System.out.println(maxKth(new int[]{1000000000, 1000000000, 1}, 2, 5));
        System.out.println(maxKth(new int[]{76, 594, 17, 6984, 26, 57, 9, 876, 5816, 73, 969, 527, 49}, 789, 459));
    }

    private static double maxKth(int[] sticks, int C, int K) {
        double low = 0;
        double high = 1e9;

        for (int i = 0; i < 100; i++) {
            double mid = (low + high) / 2;
            long count = 0;
            long cut = 0;

            for (int stick : sticks) {
                long next = (long)(stick / mid);  // 만들어진 막대의 수
                cut += Math.max(0, next - 1);  // 절단한 횟수
                count += next;
            }

            count -= Math.max(0, cut - C);
            if (count >= K) {
                low = mid;
            } else {
                high = mid;
            }
        }

        return low;
    }
}
