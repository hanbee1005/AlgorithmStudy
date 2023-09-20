package Sep2023;

/**
 * Top Coder CantorDust Member Beta Div 1 Level 2
 */
public class TopCoderCantorDust {

    public static void main(String[] args) {
        System.out.println(occurrencesNumber(new String[]{".X", ".."}, 1));
        System.out.println(occurrencesNumber(new String[]{".."}, 1));
        System.out.println(occurrencesNumber(new String[]{"."}, 2));
        System.out.println(occurrencesNumber(new String[]{"X...X"}, 2));
        System.out.println(occurrencesNumber(new String[]{"X"}, 9));
    }

    private static int occurrencesNumber(String[] pattern, int time) {
        int answer = 0;

        String fractal = makeFractal(time);

        int yLength = pattern[0].length();
        int xLength = pattern.length;

        for (int x = 0; x <= fractal.length() - xLength; x++) {
            for (int y = 0; y <= fractal.length() - yLength; y++) {
                if (checkMatch(x, y, fractal, pattern)) {
                    answer++;
                }
            }
        }

        return answer;
    }

    private static String makeFractal(int i) {
        if (i == 0) {
            return "X";
        }

        String f = makeFractal(i - 1);
        String empty = ".".repeat((int) Math.pow(3, i - 1));
        return f + empty + f;
    }

    private static boolean checkMatch(int sx, int sy, String fractal, String[] pattern) {
        for (int i = 0; i < pattern.length; i++) {
            for (int j = 0; j < pattern[i].length(); j++) {
                char c = fractal.charAt(sx + i) == 'X' && fractal.charAt(sy + j) == 'X' ? 'X' : '.';
                if (pattern[i].charAt(j) != c) {
                    return false;
                }
            }
        }

        return true;
    }
}
