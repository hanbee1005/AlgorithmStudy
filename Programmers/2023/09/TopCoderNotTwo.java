package Sep2023;

/**
 * Top Coder Not Two SRM452 Div 1 Level 1
 */
public class TopCoderNotTwo {

    public static void main(String[] args) {
        System.out.println(maxStones(3, 2));
        System.out.println(maxStones(3, 3));
        System.out.println(maxStones(8, 5));

    }

    private static int maxStones(int width, int height) {
        int i, j, res = 0;
        for (i = 0; i < 2; i++) {
            for (j = 0; j < 2; j++) {
                res += (((width + i) / 2) * ((height + j) / 2) + 1) / 2;
            }
        }

        return res;
    }
}
