package Mar2024;

import java.util.ArrayList;
import java.util.List;

/**
 * Level 2. 혼자서 하는 딕텍토
 */
public class DictectoAlone {
    public static void main(String[] args) {
        System.out.println(solution(new String[]{"O.X", ".O.", "..X"}));
        System.out.println(solution(new String[]{"OOO", "...", "XXX"}));
        System.out.println(solution(new String[]{"...", ".X.", "..."}));
        System.out.println(solution(new String[]{"...", "...", "..."}));
        System.out.println(solution(new String[]{"XXO", ".OX", "O.."}));
    }

    private static int solution(String[] board) {
        int o = 0;
        int x = 0;

        for (String row : board) {
            for (String column : row.split("")) {
                if ("O".equals(column)) {
                    o++;
                } else if ("X".equals(column)) {
                    x++;
                }
            }
        }

        List<String> all = new ArrayList<>(List.of(board));

        all.add("" + board[0].charAt(0) + board[1].charAt(0) + board[2].charAt(0));
        all.add("" + board[0].charAt(1) + board[1].charAt(1) + board[2].charAt(1));
        all.add("" + board[0].charAt(2) + board[1].charAt(2) + board[2].charAt(2));

        all.add("" + board[0].charAt(0) + board[1].charAt(1) + board[2].charAt(2));
        all.add("" + board[0].charAt(2) + board[1].charAt(1) + board[2].charAt(0));

        if ((o == 3 && x == 3) || (o == 4 && x == 4)) {
            if (!all.contains("OOO")) {
                return 1;
            }
        } else if ((o == 4 && x == 3) || (o == 5 && x == 4)) {
            if (!all.contains("XXX")) {
                return 1;
            }
        } else if ((o <= 5 && x <= 4 && o - 1 == x)
                || (o == 0 && x == 0) || (o == 1 && x == 1) || (o == 2 && x == 2)) {
            return 1;
        }

        return 0;
    }
}
