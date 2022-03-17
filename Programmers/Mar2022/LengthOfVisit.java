package Mar2022;

import java.util.*;

public class LengthOfVisit {
    private static Map<Character, int[]> directions = new HashMap<>(){{
        put('U', new int[]{-1, 0});
        put('D', new int[]{1, 0});
        put('R', new int[]{0, 1});
        put('L', new int[]{0, -1});
    }};

    public static void main(String[] args) {
        System.out.println(solution("ULURRDLLU"));
    }

    private static int solution(String dirs) {
        Set<Line> set = new HashSet<>();

        int sx = 0;
        int sy = 0;

        for (Character dir : dirs.toCharArray()) {
            int nx = sx + directions.get(dir)[0];
            int ny = sy + directions.get(dir)[1];

            if (nx >= -5 && nx <= 5 && ny >= -5 && ny <= 5) {
                set.add(new Line(sx, sy, nx, ny));
                sx = nx;
                sy = ny;
            }
        }

        return set.size();
    }

    private static class Line {
        private int[] pos1;
        private int[] pos2;

        public Line(int sx, int sy, int ex, int ey) {
            pos1 = new int[]{sx, sy};
            pos2 = new int[]{ex, ey};
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Line line = (Line) o;

            if ((Arrays.equals(pos1, line.pos1) && Arrays.equals(pos2, line.pos2))) return true;
            return Arrays.equals(pos1, line.pos2) && Arrays.equals(pos2, line.pos1);
        }

        @Override
        public int hashCode() {
            int result = 31 * (Arrays.hashCode(pos1) + Arrays.hashCode(pos2));
            return result;
        }
    }
}