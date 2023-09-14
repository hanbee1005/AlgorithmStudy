package Sep2023;

/**
 * Top Coder CirclesCountry SRM443 Div 2 Level 2
 */
public class TopCoderCirclesCountry {
    public static void main(String[] args) {
        System.out.println(leastBorders(new int[]{0}, new int[]{0}, new int[]{2}, -5, 1, 5, 1));
        System.out.println(leastBorders(new int[]{0, -6, 6}, new int[]{0, 1, 2}, new int[]{2, 2, 2}, -5, 1, 5, 1));
        System.out.println(leastBorders(new int[]{1, -3, 2, 5, -4, 12, 12}, new int[]{1, -1, 2, 5, 5, 1, 1}, new int[]{8, 1, 2, 1, 1, 1, 2}, -5, 1, 12, 1));
        System.out.println(leastBorders(new int[]{-3, 2, 2, 0, -4, 12, 12, 12}, new int[]{-1, 2, 3, 1, 5, 1, 1, 1}, new int[]{1, 3, 1, 7, 1, 1, 2, 3}, 2, 3, 13, 2));
        System.out.println(leastBorders(new int[]{-107, -38, 140, 148, 198, 172, -179, 148, 176, 153, -56, -187},
                                        new int[]{175, -115, 23, -2, -49, -151, -52, 42, 0, 68, 109, -174},
                                        new int[]{135, 42, 70, 39, 89, 39, 43, 150, 10, 120, 16, 8},
                                        102, 16, 19, -108));
    }

    private static int leastBorders(int[] X, int[] Y, int[] R, int x1, int y1, int x2, int y2) {
        int answer = 0;
        int n = X.length;

        for (int i = 0; i < n; i++) {
            if (inside(R[i], X[i], Y[i], x1, y1) != inside(R[i], X[i], Y[i], x2, y2)) {
                answer++;
            }
        }

        return answer;
    }

    private static boolean inside(int r, int cx, int cy, int x, int y) {
        return Math.pow(r, 2) > (Math.pow(cx - x, 2) + Math.pow(cy - y, 2));
    }
}
