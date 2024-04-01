package Feb2024;

/**
 * Level 1. 푸드 파이트 대회
 */
public class FoodFightContest {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 3, 4, 6}));
        System.out.println(solution(new int[]{1, 7, 1, 2}));
    }

    private static String solution(int[] food) {
        StringBuilder answer = new StringBuilder("0");

        for (int i = food.length - 1; i >= 0; i--) {
            String f = String.valueOf(i).repeat(food[i] / 2);
            answer.insert(0, f).append(f);
        }

        return answer.toString();
    }
}
