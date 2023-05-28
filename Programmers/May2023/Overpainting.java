package May2023;

/**
 * Level 1. 덧칠하기
 */
public class Overpainting {
    public static void main(String[] args) {
        System.out.println(solution(8, 4, new int[]{2, 3, 6}));
        System.out.println(solution(5, 4, new int[]{1, 3}));
        System.out.println(solution(4, 1, new int[]{1, 2, 3, 4}));
    }

    private static int solution(int n, int m, int[] section) {
        int answer = 0;

        int maxPainted = 0;

        for (int point : section) {
            if (maxPainted <= point) {
                maxPainted = point + m;
                answer++;
            }
        }

        return answer;
    }
}
