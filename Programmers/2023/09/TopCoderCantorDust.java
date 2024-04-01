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
        String fractal = makeFractal(time);
        int fLength = fractal.length();

        // 가로 세로 길이
        int yLength = pattern[0].length();
        int xLength = pattern.length;

        // 각 행과 열에 X를 포함할지 여부
        boolean[] xArr = new boolean[xLength], yArr = new boolean[yLength];

        // 각 행과 열이 'X'를 포함하고 있는지 여부
        boolean flag = false;

        int x, y;

        for (x = 0; x < xLength; x++) {
            for (y = 0; y < yLength; y++) {
                if (pattern[x].charAt(y) == 'X') {
                    xArr[x] = yArr[y] = flag = true;  // 모순이 있으면 포함하지 않는 것이므로 0을 리턴
                }
            }
        }

        for (x = 0; x < xLength; x++) {
            for (y = 0; y < yLength; y++) {
                if ((pattern[x].charAt(y) == 'X') != (xArr[x] && yArr[y])) {
                    return 0;
                }
            }
        }

        // 가로의 일치 수 확인
        int p = checkMatch(xLength, fLength, fractal, xArr);

        // 세로의 일치 수 확인
        int q = checkMatch(yLength, fLength, fractal, yArr);

        if (flag) return (p * q);  // 'X'를 포함하는 경우
        else return (p * (fLength - yLength + 1) + (fLength - xLength + 1) * q - p * q);  // 'X'를 포함하지 않는 경우
    }

    private static String makeFractal(int i) {
        if (i == 0) {
            return "X";
        }

        String f = makeFractal(i - 1);
        String empty = ".".repeat((int) Math.pow(3, i - 1));
        return f + empty + f;
    }

    private static int checkMatch(int M, int L, String fractal, boolean[] arr) {
        int p = 0;

        for (int k = 0; k + M <= L; ++k) {
            int x;
            for (x = 0; x < M; ++x) {
                if ((fractal.charAt(k + x) == 'X') != arr[x]) break;
            }
            if (x == M) ++p;
        }

        return p;
    }
}
