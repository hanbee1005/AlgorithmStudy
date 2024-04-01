package Sep2023;

/**
 * Top Coder ColorfulBoxesAndBalls SRM464 Div 2 Level 1
 */
public class TopCoderColorfulBoxesAndBalls {
    public static void main(String[] args) {
        System.out.println(getMaximum(2, 3, 100, 400, 200));
        System.out.println(getMaximum(2, 3, 100, 400, 300));
        System.out.println(getMaximum(5, 5, 464, 464, 464));
        System.out.println(getMaximum(1, 4, 20, -30, -10));
        System.out.println(getMaximum(9, 1, -1, -10, 4));
    }

    private static int getMaximum(int numRed, int numBlue, int onlyRed, int onlyBlue, int bothColors) {
        int min = Math.min(numRed, numBlue);
        int answer = Integer.MIN_VALUE;

        for (int i = 0; i <= min; i++) {
            int tmp = (numRed - i) * onlyRed + (numBlue - i) * onlyBlue + (bothColors * i * 2);
            answer = Math.max(answer, tmp);
        }

        return answer;
    }
}
