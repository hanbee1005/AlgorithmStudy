package May2024;

import java.util.Arrays;

/**
 * Level 3. 좌물쇠와 열쇠
 */
public class LockAndKey {
    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{0, 0, 0}, {1, 0, 0}, {0, 1, 1}}, new int[][]{{1, 1, 1}, {1, 1, 0}, {1, 0, 1}}));
        System.out.println(solution(new int[][]{{0, 0, 0}, {1, 0, 0}, {0, 1, 1}}, new int[][]{{1, 1, 1}, {1, 1, 1}, {1, 1, 1}}));
        System.out.println(solution(new int[][]{{0, 0, 0}, {1, 0, 0}, {0, 1, 1}}, new int[][]{{1, 1, 1}, {1, 1, 0}, {1, 1, 0}}));
    }

    private static boolean solution(int[][] key, int[][] lock) {
        boolean answer = false;

        int minX = 21;
        int minY = 21;
        int maxX = 0;
        int maxY = 0;

        boolean isAllLock = true;

        for (int x = 0; x < lock.length; x++) {
            for (int y = 0; y < lock[x].length; y++) {
                if (lock[x][y] == 0) {
                    isAllLock = false;
                    minX = Math.min(minX, x);
                    minY = Math.min(minY, y);
                    maxX = Math.max(maxX, x);
                    maxY = Math.max(maxY, y);
                }
            }
        }

        if (isAllLock) {
            return true;
        }

        int xLength = Math.min(lock.length, Math.abs(maxX - minX + 1));
        int yLength = Math.min(lock.length, Math.abs(maxY - minY + 1));

        if (xLength > key.length || yLength > key[0].length) {
            return false;
        }

        int[][] validLock = new int[xLength][yLength];
        if (minX > maxX || minY > maxY) {
            for (int[] l : validLock) {
                Arrays.fill(l, 1);
            }
        } else {
            for (int x = minX; x <= maxX; x++) {
                for (int y = minY; y <= maxY; y++) {
                    validLock[x - minX][y - minY] = lock[x][y];
                }
            }
        }

        for (int i = 0; i < 4; i++) {
            int xl = validLock.length;
            int yl = validLock[0].length;

            for (int x = 0; x <= key.length - xl; x++) {
                for (int y = 0; y <= key[0].length - yl; y++) {
                    int[][] copied = new int[xl][yl];
                    for (int xx = x; xx < x + xl; xx++) {
                        System.arraycopy(key[xx], y, copied[xx - x], 0, yl);
                    }

                    if (isMatched(copied, validLock)) {
                        return true;
                    }
                }
            }
            validLock = rotateArray(validLock);
        }

        return answer;
    }

    private static int[][] rotateArray(int[][] origin) {
        int[][] rotated = new int[origin[0].length][origin.length];
        for (int x = 0; x < origin.length; x++) {
            for (int y = 0; y < origin[0].length; y++) {
                rotated[y][origin.length - x - 1] = origin[x][y];
            }
        }
        return rotated;
    }

    private static boolean isMatched(int[][] key, int[][] lock) {
        for (int x = 0; x < key.length; x++) {
            for (int y = 0; y < key[0].length; y++) {
                if (key[x][y] == lock[x][y]) {
                    return false;
                }
            }
        }
        return true;
    }
}
