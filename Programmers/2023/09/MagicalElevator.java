package Sep2023;

/**
 * Level 2. 마법의 엘리베이터
 */
public class MagicalElevator {
    public static void main(String[] args) {
        System.out.println(solution(16));
        System.out.println(solution(2554));
        System.out.println(solution(99));
        System.out.println(solution(69));
        System.out.println(solution(15));
        System.out.println(solution(75));
    }

    private static int solution(int storey) {
        int answer = 0;

        while (storey > 0) {
            int num = storey % 10;
            storey /= 10;

            answer += num > 5 ? 10 - num : num;

            if (num > 5 || (num == 5 && storey % 10  >= 5)) {
                storey++;
            }
        }

        return answer;
    }
}
