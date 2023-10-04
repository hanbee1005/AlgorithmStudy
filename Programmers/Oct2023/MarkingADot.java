package Oct2023;

/**
 * Level 2. 점 찍기
 */
public class MarkingADot {
    public static void main(String[] args) {
        System.out.println(solution(2, 4));
        System.out.println(solution(1, 5));
    }

    private static long solution(int k, int d) {
        long answer = 0;

        for (int x = 0; x <= d; x += k) {
            double y = Math.sqrt(Math.pow(d, 2) - Math.pow(x, 2));
            answer += Math.floor(y / k) + 1;
        }

        return answer;
    }
}
