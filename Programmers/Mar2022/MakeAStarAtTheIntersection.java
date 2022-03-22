package Mar2022;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MakeAStarAtTheIntersection {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[][]{{2, -1, 4}, {-2, -1, 4}, {0, -1, 1}, {5, -8, -12}, {5, 8, 12}})));
    }

    private static String[] solution(int[][] line) {
        List<long[]> intersections = new ArrayList<>();

        for (int i = 0; i < line.length - 1; i++) {
            for (int j = i + 1; j < line.length; j++) {
                if (isExistIntersection(line[i][0], line[i][1], line[j][0], line[j][1])) {
                    double[] intersection = findIntersection(line[i][0], line[i][1], line[i][2], line[j][0], line[j][1], line[j][2]);
                    // 정수로 딱 떨어지는 경우
                    if (Math.ceil(intersection[0]) == Math.floor(intersection[0]) && Math.ceil(intersection[1]) == Math.floor(intersection[1])) {
                        intersections.add(new long[]{(long)intersection[0], (long)intersection[1]});
                    }
                }
            }
        }

        long maxX = Long.MIN_VALUE;
        long minX = Long.MAX_VALUE;
        long maxY = Long.MIN_VALUE;
        long minY = Long.MAX_VALUE;

        for (long[] inter : intersections) {
            maxX = Math.max(maxX, inter[0]);
            minX = Math.min(minX, inter[0]);
            maxY = Math.max(maxY, inter[1]);
            minY = Math.min(minY, inter[1]);
        }

        String[] answer = new String[(int) (maxY - minY + 1)];

        int idx = 0;
        for (long i = maxY; i >= minY; i--) {
            StringBuilder buffer = new StringBuilder();
            for (long j = minX; j <= maxX; j++) {
                if (isContain(intersections, j, i)) {
                    buffer.append("*");
                } else {
                    buffer.append(".");
                }
            }
            answer[idx] = buffer.toString();
            idx++;
        }

        return answer;
    }

    private static boolean isExistIntersection(long a1, long b1, long a2, long b2) {
        return (a1*b2 - a2*b1) != 0;
    }

    private static double[] findIntersection(long a1, long b1, long c1, long a2, long b2, long c2) {
        double px = (double) (b1*c2 - b2*c1) / (a1*b2 - a2*b1);
        double py = (double) (c1*a2 - a1*c2) / (a1*b2 - a2*b1);

        return new double[]{px, py};
    }

    private static boolean isContain(List<long[]> intersection, long x, long y) {
        return intersection.stream().anyMatch(inter -> inter[0] == x && inter[1] == y);
    }
}
