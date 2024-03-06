package Feb2024;

/**
 * Level 1. 콜라 문제
 */
public class ColaQuestion {
    public static void main(String[] args) {
        System.out.println(solution(2, 1, 20));
        System.out.println(solution(3, 1, 20));
    }

    private static int solution(int a, int b, int n) {
        return (n - b) / (a - b) * b;
    }
}
