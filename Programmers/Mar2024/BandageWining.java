package Mar2024;

/**
 * Level 1. 붕대 감기
 */
public class BandageWining {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{5, 1, 5}, 30, new int[][]{{2, 10}, {9, 15}, {10, 5}, {11, 5}}));
        System.out.println(solution(new int[]{3, 2, 7}, 20, new int[][]{{1, 15}, {5, 16}, {8, 6}}));
        System.out.println(solution(new int[]{4, 2, 7}, 20, new int[][]{{1, 15}, {5, 16}, {8, 6}}));
        System.out.println(solution(new int[]{1, 1, 1}, 5, new int[][]{{1, 2}, {3, 2}}));
    }

    private static int solution(int[] bandage, int health, int[][] attacks) {
        int nowHealth = health;
        int beforeAttackedTime = 0;
        int combo = bandage[0];

        int diffTime;
        int addMoreBandage;
        for (int[] attack : attacks) {
            if (nowHealth <= 0) {
                return -1;
            }

            diffTime = attack[0] - beforeAttackedTime - 1;
            addMoreBandage = diffTime / combo;

            beforeAttackedTime = attack[0];
            nowHealth = Math.min(health, nowHealth + (diffTime * bandage[1]));
            nowHealth = Math.min(health, nowHealth + (addMoreBandage * bandage[2]));

            nowHealth -= attack[1];
        }

        return nowHealth <= 0 ? -1 : nowHealth;
    }
}
