package Feb2024;

/**
 * Level 1. 기사 단원의 무기
 */
public class KnightWeapon {
    public static void main(String[] args) {
        System.out.println(solution(5, 3, 2));
        System.out.println(solution(10, 3, 2));
    }

    private static int solution(int number, int limit, int power) {
        int answer = 0;

        int[] nums = new int[number + 1];

        for (int i = 1; i <= number; i++) {
            for (int j = 1; i*j <= number; j++) {
                nums[i*j]++;
            }

            answer += nums[i] > limit ? power : nums[i];
        }

        return answer;
    }
}
