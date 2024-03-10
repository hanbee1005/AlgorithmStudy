package Feb2024;

/**
 * Level 1. 숫자 짝꿍
 */
public class NumberPartner {
    public static void main(String[] args) {
        System.out.println(solution("100", "2345"));
        System.out.println(solution("100", "203045"));
        System.out.println(solution("100", "123450"));
        System.out.println(solution("12321", "42531"));
        System.out.println(solution("5525", "1255"));
    }

    private static String solution(String X, String Y) {
        int[] xNum = new int[10];
        for (char x : X.toCharArray()) {
            xNum[x - '0']++;
        }

        int[] yNum = new int[10];
        for (char y : Y.toCharArray()) {
            yNum[y - '0']++;
        }

        StringBuilder answer = new StringBuilder();

        for (int i = 9; i > 0; i--) {
            if (xNum[i] != 0 && yNum[i] != 0) {
                answer.append(String.valueOf(i).repeat(Math.min(xNum[i], yNum[i])));
            }
        }

        if (xNum[0] != 0 && yNum[0] != 0) {
            if (answer.length() == 0) {
                answer.append(0);
            } else {
                answer.append(String.valueOf(0).repeat(Math.min(xNum[0], yNum[0])));
            }
        }

        if (answer.toString().isEmpty()) return "-1";
        return answer.toString();
    }
}
