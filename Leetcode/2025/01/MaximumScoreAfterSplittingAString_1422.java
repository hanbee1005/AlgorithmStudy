package string;

public class MaximumScoreAfterSplittingAString_1422 {
    public static void main(String[] args) {
        System.out.println(maxScore("011101"));
        System.out.println(maxScore("00111"));
        System.out.println(maxScore("1111"));
        System.out.println(maxScore("00"));
    }

    private static int maxScore(String s) {
        int zeroScore = s.charAt(0) == '0' ? 1 : 0;
        int oneScore = 0;

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                oneScore++;
            }
        }

        int maxScore = zeroScore + oneScore;
        for (int i = 1; i < s.length() - 1; i++) {
            if (s.charAt(i) == '0') {
                zeroScore++;
            } else {
                oneScore--;
            }

            maxScore = Math.max(maxScore, zeroScore + oneScore);
        }

        return maxScore;
    }
}
