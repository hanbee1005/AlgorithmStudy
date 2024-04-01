package Sep2023;

import java.util.Arrays;

/**
 * Top Coder KiwiJuiceEasy SRM478 Div 2 Level 1
 */
public class TopCoderKiwiJuice {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(thePouring(new int[]{10, 10}, new int[]{5, 8}, new int[]{0}, new int[]{1})));
        System.out.println(Arrays.toString(thePouring(new int[]{30, 20, 10}, new int[]{10, 5, 5}, new int[]{0, 1, 2}, new int[]{1, 2, 0})));
    }

    private static int[] thePouring(int[] capacities, int[] bottles, int[] fromId, int[] toId) {
        for (int i = 0; i < fromId.length; i++) {
            int fromIdx = fromId[i];
            int toIdx = toId[i];

            int canMoveAmount = Math.min(bottles[fromIdx], capacities[toIdx] - bottles[toIdx]);
            bottles[fromIdx] -= canMoveAmount;
            bottles[toIdx] += canMoveAmount;

            // 또는 아래와 같이 해결할 수도 있음.
            // int sum = bottles[fromIdx] + bottles[toIdx];
            // bottles[toIdx] = Math.min(sum, capacities[toIdx]);
            // bottles[fromIdx] = sum - bottles[toIdx];
        }

        return bottles;
    }
}
