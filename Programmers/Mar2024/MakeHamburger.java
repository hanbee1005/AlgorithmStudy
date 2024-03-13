package Mar2024;

/**
 * Level 1. 햄버거 만들기
 */
public class MakeHamburger {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{2, 1, 1, 2, 3, 1, 2, 3, 1}));  // 2
        System.out.println(solution(new int[]{1, 3, 2, 1, 2, 1, 3, 1, 2}));  // 0
        System.out.println(solution(new int[]{1, 2, 1, 2, 3, 1, 3, 1, 2}));  // 2
        System.out.println(solution(new int[]{1, 2, 1, 2, 3, 1, 3, 1}));     // 2
        System.out.println(solution(new int[]{1, 2, 3, 1, 2, 3, 1, 1}));     // 2
        System.out.println(solution(new int[]{1, 1, 2, 3, 1, 2, 3, 1}));     // 2
    }

    private static int solution(int[] ingredient) {
        int answer = 0;

        if (ingredient.length < 4) {
            return 0;
        }

        StringBuilder sb = new StringBuilder();
        for (int i : ingredient) {
            sb.append(i);
            if (sb.length() > 3 && sb.subSequence(sb.length() - 4, sb.length()).equals("1231")) {
                answer++;
                sb.delete(sb.length() - 4, sb.length());
            }
        }

        return answer;
    }
}
