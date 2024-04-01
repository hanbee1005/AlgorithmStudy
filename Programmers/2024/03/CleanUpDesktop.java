package Mar2024;

import java.util.Arrays;

/**
 * Level 1. 바탕화면 정리
 */
public class CleanUpDesktop {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[]{".#...", "..#..", "...#."})));
        System.out.println(Arrays.toString(solution(new String[]{"..........", ".....#....", "......##..", "...##.....", "....#....."})));
        System.out.println(Arrays.toString(solution(new String[]{".##...##.", "#..#.#..#", "#...#...#", ".#.....#.", "..#...#..", "...#.#...", "....#...."})));
        System.out.println(Arrays.toString(solution(new String[]{"..", "#."})));
    }

    private static int[] solution(String[] wallpaper) {
        int[] answer = new int[4];
        answer[0] = 51;
        answer[1] = 51;

        for (int i = 0; i < wallpaper.length; i++) {
            for (int j = 0; j < wallpaper[i].length(); j++) {
                char paper = wallpaper[i].charAt(j);
                if ('.' == paper) {
                    continue;
                }

                answer[0] = Math.min(answer[0], i);
                answer[1] = Math.min(answer[1], j);
                answer[2] = Math.max(answer[2], i+1);
                answer[3] = Math.max(answer[3], j+1);
            }
        }

        return answer;
    }
}
