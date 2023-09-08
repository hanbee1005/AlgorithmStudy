package Sep2023;

/**
 * Level 2. 택배 배달과 수거하기
 */
public class DeliveryAndCollectionOfParcels {
    public static void main(String[] args) {
        System.out.println(solution(4, 5, new int[]{1, 0, 3, 1, 2}, new int[]{0, 3, 0, 4, 0}));
        System.out.println(solution(2,	7,	new int[]{1, 0, 2, 0, 1, 0, 2}, new int[]{0, 2, 0, 1, 0, 2, 0}));
    }

    private static long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0L;

        int deliveryBox = 0;
        int pickupBox = 0;

        for (int i = n - 1; i >= 0; i--) {
            if (deliveries[i] > 0 || pickups[i] > 0) {
                deliveryBox -= deliveries[i];
                pickupBox -= pickups[i];

                if (deliveryBox < 0 || pickupBox < 0) {
                    int cnt = Math.max((-deliveryBox - 1) / cap + 1, (-pickupBox - 1) / cap + 1);
                    answer += cnt * (i + 1) * 2L;
                    deliveryBox += cnt * cap;
                    pickupBox += cnt * cap;
                }
            }
        }

        return answer;
    }
}
