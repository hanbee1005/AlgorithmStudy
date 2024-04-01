package Mar2022;

public class GameOfNNum {
    public static void main(String[] args) {
        System.out.println(solution(16, 16, 2, 1));
    }

    private static String solution(int n, int t, int m, int p) {
        StringBuilder answer = new StringBuilder();

        // 숫자 늘여 놓기
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while(sb.length() != ((t+1) * m)) {
            for (Character c : Integer.toString(i, n).toCharArray()) {
                sb.append(String.valueOf(c).toUpperCase());

                if (sb.length() == ((t+1) * m)) break;
            }
            i++;
        }

        // 숫자 고르기
        for (int j = p; answer.length() < t; j += m) {
            answer.append(sb.charAt(j - 1));
        }

        return answer.toString();
    }
}
