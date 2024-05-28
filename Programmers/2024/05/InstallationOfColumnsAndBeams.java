package May2024;

import java.util.Arrays;

/**
 * Level 3. 기둥과 보 설치
 */
public class InstallationOfColumnsAndBeams {
    static final int PILLAR = 0, BAR = 1, REMOVE = 0, ADD = 1;
    static boolean[][] pillar;
    static boolean[][] bar;

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(solution(5, new int[][]{{1, 0, 0, 1}, {1, 1, 1, 1}, {2, 1, 0, 1}, {2, 2, 1, 1}, {5, 0, 0, 1}, {5, 1, 0, 1}, {4, 2, 1, 1}, {3, 2, 1, 1}})));
        System.out.println(Arrays.deepToString(solution(5, new int[][]{{0, 0, 0, 1}, {2, 0, 0, 1}, {4, 0, 0, 1}, {0, 1, 1, 1}, {1, 1, 1, 1}, {2, 1, 1, 1}, {3, 1, 1, 1}, {2, 0, 0, 0}, {1, 1, 1, 0}, {2, 2, 0, 1}})));
        System.out.println(Arrays.deepToString(solution(5, new int[][]{{1, 0, 0, 1}, {2, 0, 0, 1}, {0, 1, 1, 1}, {1, 1, 1, 1}, {1, 0, 0, 0}})));
    }

    private static int[][] solution(int n, int[][] build_frame) {
        pillar = new boolean[n + 1][n + 1];
        bar = new boolean[n + 1][n + 1];

        int count = 0;
        for (int[] frame : build_frame) {
            int x = frame[0];
            int y = frame[1];

            if (frame[2] == PILLAR) { // 기둥을
                if (frame[3] == ADD) { // 설치한다
                    if (checkPillar(x, y)) {
                        pillar[x][y] = true;
                        count++;
                    }
                } else if (frame[3] == REMOVE) { //삭제한다
                    pillar[x][y] = false;
                    if (!canRemove(n)) pillar[x][y] = true;
                    else count--;
                }
            } else if (frame[2] == BAR) { //보를
                if (frame[3] == ADD) {
                    if (checkBar(x, y)) { //설치한다
                        bar[x][y] = true;
                        count++;
                    }
                } else if (frame[3] == REMOVE) { //삭제한다
                    bar[x][y] = false;
                    if (!canRemove(n)) bar[x][y] = true;
                    else count--;
                }
            }
        }

        int[][] answer = new int[count][3];
        int idx = 0;
        for(int i = 0; i <= n; i++) {
            for(int j = 0; j <= n; j++) {
                if(pillar[i][j]) {
                    answer[idx][0] = i;
                    answer[idx][1] = j;
                    answer[idx++][2] = 0;
                }
                if(bar[i][j]) {
                    answer[idx][0] = i;
                    answer[idx][1] = j;
                    answer[idx++][2] = 1;
                }
            }
        }
        return answer;
    }

    public static boolean canRemove(int n) {
        for(int i = 0; i <= n; i++) {
            for(int j = 0; j <= n; j++) {
                if(pillar[i][j] && !checkPillar(i, j))  return false; // 기둥이 해당 위치에 있을 수 없다면 false
                else if(bar[i][j] && !checkBar(i, j)) return false; // 바닥이 해당 위치에 있을 수 없다면 false
            }
        }
        return true;
    }

    public static boolean checkPillar(int x, int y) {
        if(y == 0) return true; //바닥에 설치하는 경우
        else if(y > 0 && pillar[x][y - 1]) return true; //아래 기둥이 있는 경우
        else return x > 0 && bar[x - 1][y] || bar[x][y];
    }

    public static boolean checkBar(int x, int y) {
        if(y > 0 && pillar[x][y - 1] || pillar[x + 1][y - 1]) return true; // 한쪽 끝에 기둥이 있는 경우
        else return x > 0 && bar[x - 1][y] && bar[x + 1][y]; //양쪽 끝이 보와 동시에 연결되어 있는 경우
    }
}
