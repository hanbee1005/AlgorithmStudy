package Feb2022;

public class DartGame {
    public static void main(String[] args) {
        System.out.println(solution("1D2S0T"));
    }

    private static int solution(String dartResult) {
        int answer = 0;

        int[] scores = new int[3];

        int i = -1;
        int score = 0;
        for (char dr : dartResult.toCharArray()) {
            if (Character.isDigit(dr)) {
                if (dr == '0' && score != 0) score *= 10;
                else {
                    i++;
                    score = Integer.parseInt(String.valueOf(dr));
                }
                continue;
            }

            scores[i] = dr == 'S' ? score : dr == 'D' ? (int) Math.pow(score, 2) : dr == 'T' ?(int) Math.pow(score, 3) : scores[i];

            if (dr == '*') {
                scores[i] *= 2;
                if (i > 0) scores[i-1] *= 2;
            } else if (dr == '#') {
                scores[i] *= -1;
            }

            score = 0;
        }

        for (int s : scores) {
            answer += s;
        }

        return answer;
    }
}
