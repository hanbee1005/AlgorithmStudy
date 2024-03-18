package Mar2024;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Level 1. 공원 산책
 */
public class WalkInThePark {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[]{"SOO", "OOO", "OOO"}, new String[]{"E 2", "S 2", "W 1"})));
        System.out.println(Arrays.toString(solution(new String[]{"SOO","OXX","OOO"}, new String[]{"E 2","S 2","W 1"})));
        System.out.println(Arrays.toString(solution(new String[]{"OSO","OOO","OXO","OOO"}, new String[]{"E 2","S 3","W 1"})));
    }

    private static int[] solution(String[] park, String[] routes) {
        int[] answer = new int[2];

        boolean[][] parkStatus = new boolean[park.length][park[0].length()];
        for (int i = 0; i < park.length; i++) {
            for (int j = 0; j < park[i].length(); j++) {
                char cur = park[i].charAt(j);
                if (cur == 'S') {
                    answer[0] = i;
                    answer[1] = j;
                }

                parkStatus[i][j] = cur != 'X';
            }
        }

        Map<String, int[]> direction = new HashMap<>(){{
            put("N", new int[]{-1, 0});
            put("S", new int[]{1, 0});
            put("W", new int[]{0, -1});
            put("E", new int[]{0, 1});
        }};

        for (String route : routes) {
            String[] dd = route.split(" ");
            int move = Integer.parseInt(dd[1]);
            int[] direct = direction.get(dd[0]);

            int nx = answer[0];
            int ny = answer[1];

            boolean canMove = true;
            for (int i = 0; i < move; i++) {
                nx += direct[0];
                ny += direct[1];

                if ((nx < 0 || nx >= parkStatus.length || ny < 0 || ny >= parkStatus[0].length)
                || !parkStatus[nx][ny]) {
                    canMove = false;
                    break;
                }
            }

            if (canMove) {
                answer[0] = nx;
                answer[1] = ny;
            }
        }

        return answer;
    }
}
