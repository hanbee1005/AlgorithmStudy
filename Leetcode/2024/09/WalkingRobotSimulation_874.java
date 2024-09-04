package array;

import java.util.HashSet;
import java.util.Set;

public class WalkingRobotSimulation_874 {
    public static void main(String[] args) {
        System.out.println(robotSim(new int[]{4,-1,3}, new int[][]{}));
        System.out.println(robotSim(new int[]{4,-1,4,-2,4}, new int[][]{{2,4}}));
        System.out.println(robotSim(new int[]{6,-1,-1,6}, new int[][]{}));
        System.out.println(robotSim(new int[]{-2,-1,8,9,6}, new int[][]{{-1,3},{0,1},{-1,5},{-2,-4},{5,4},{-2,-3},{5,-1},{1,-1},{5,5},{5,2}}));
    }

    private static int robotSim(int[] commands, int[][] obstacles) {
        Set<String> obsSet = new HashSet<>();
        for (int[] obstacle : obstacles) {
            obsSet.add(obstacle[0] + "," + obstacle[1]);
        }

        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        int d = 0;

        int max = 0;
        int[] curXY = {0,0};

        for (int command : commands) {
            if (command == -1) {
                d = d == 3 ? 0 : d + 1;
            } else if (command == -2) {
                d = d == 0 ? 3 : d - 1;
            } else {
                int nx = 0;
                int ny = 0;

                // 장애물 확인한 뒤
                if (d == 0 || d == 2) {
                    for (int y = 1; y <= command; y++) {
                        if (obsSet.contains(curXY[0] + "," + (curXY[1] + y * dy[d]))) {
                            break;
                        }

                        ny = y * dy[d];
                    }
                } else if (d == 1 || d == 3) {
                    for (int x = 1; x <= command; x++) {
                        if (obsSet.contains((curXY[0] + x * dx[d]) + "," + curXY[1])) {
                            break;
                        }

                        nx = x * dx[d];
                    }
                }

                curXY[0] += nx;
                curXY[1] += ny;
                
                max = Math.max(max, curXY[0] * curXY[0] + curXY[1] * curXY[1]);
            }
        }

        return max;
    }
}
